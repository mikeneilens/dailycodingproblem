package september.september08

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest:StringSpec( {

    class MockDatabase(var data:List<String> = listOf()):StringDatabase {
        override fun read(): List<String> = data
        override fun write(strings: List<String>)  { data = strings }
    }

    "a map of ['a' to 'b', 'c' to 'd'] is converted to a csv of ['a,b', 'c,d']" {
        mutableMapOf("a" to "b", "c" to "d").toCsv() shouldBe listOf("a,b","c,d")
    }
    "csv of ['a,b', 'c,d'] is converted to a map of ['a' to 'b', 'c' to 'd']" {
        listOf("a,b","c,d").fromCsvToMap() shouldBe mapOf("a" to "b", "c" to "d")
    }
    "create a random shortURL" {
        val chars:List<Char> = listOf('A','A','A','A','A','A')
        var n = 0
        val randomChar = {chars[n++]}
        val shortURL = UrlShortener(MockDatabase(), randomCharacter = randomChar).createRandomShortURL()
        shortURL shouldBe "AAAAAA"
        n shouldBe  6
    }
    "UrlShortener shortens a URL" {
        val mockDatabase = MockDatabase()
        val urlShortener = UrlShortener(mockDatabase)
        val shortenedURL = urlShortener.shorten("url1")
        urlShortener.urlMap[shortenedURL] shouldBe "url1"
        mockDatabase.read() shouldBe listOf("$shortenedURL,url1")
    }
    "UrlShortener retrieves a url for a shortened URL" {
        val urlShortener = UrlShortener(MockDatabase())
        val shortenedURL = urlShortener.shorten("url1")
        urlShortener.restore(shortenedURL) shouldBe "url1"
    }
    "UrlShortener shortening the same URL returns the same short url each time" {
        val urlShortener = UrlShortener(MockDatabase())
        val shortenedURL = urlShortener.shorten("url1")
        urlShortener.shorten("url2")
        urlShortener.shorten("url1") shouldBe shortenedURL
    }
})