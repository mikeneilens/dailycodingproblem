package september.september08

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest:StringSpec( {

    class MockDatabase(var data:List<String> = listOf<String>()):StringDatabase {
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
        val shortURL = UrlShortner(MockDatabase(), randomCharacter = {'A'}).createRandomShortURL()
        shortURL shouldBe "AAAAAA"
    }
    "UrlShortner shortens a URL" {
        val mockDatabase = MockDatabase()
        val urlShortner = UrlShortner(mockDatabase)
        val shortnedURL = urlShortner.shortern("url1")
        urlShortner.urlMap[shortnedURL] shouldBe "url1"
        mockDatabase.read() shouldBe listOf("$shortnedURL,url1")
    }
    "UrlShortner retrieves a url for a shortened URL" {
        val urlShortner = UrlShortner(MockDatabase())
        val shortnedURL = urlShortner.shortern("url1")
        urlShortner.restore(shortnedURL) shouldBe "url1"
    }
    "UrlShortner shortening the same URL returns the same short url each time" {
        val urlShortner = UrlShortner(MockDatabase())
        val shortnedURL = urlShortner.shortern("url1")
        urlShortner.shortern("url2")
        urlShortner.shortern("url1") shouldBe shortnedURL
    }
})