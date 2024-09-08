package september.september08

//Implement a URL shortener with the following methods:
//
//shorten(url), which shortens the url into a six-character alphanumeric string, such as zLg6wl.
//restore(short), which expands the shortened string into the original url. If no such shortened string exists, return null.
//Hint: What if we enter the same URL twice?

interface StringDatabase{
    fun read():List<String>
    fun write(strings:List<String>)
}

class UrlShortener(private val stringDatabase:StringDatabase, val randomCharacter:()->Char = {validChars.shuffled().first()} ) {

    val urlMap: URLMap = stringDatabase.read().fromCsvToMap()

    fun shorten(url:String):String {
        if (url in urlMap.values) return urlMap.toList().first { it.second == url }.first
        val shortenedURL = createRandomShortURL()
        persist(url = url, shortenedURL = shortenedURL)
        return shortenedURL
    }

    fun restore(short:String) = urlMap[short]

    private fun persist(url:String, shortenedURL:String) {
        urlMap[shortenedURL] = url
        stringDatabase.write(urlMap.toCsv())
    }

    fun createRandomShortURL():String {
        val shortURL = (1..6).map{ randomCharacter()}.joinToString("")
        return if (urlMap.containsKey(shortURL)) createRandomShortURL() else shortURL
    }

    companion object {
        val validChars =  ('A'..'Z').toList() + ('a'..'z').toList() + ('0'..'9').toList()
    }
}

typealias URLMap = MutableMap<String, String>

fun URLMap.toCsv() = map{(k,v) -> "$k,$v" }

fun List<String>.fromCsvToMap() = associate { Pair(it.split(",")[0], it.split(",")[1])}.toMutableMap()

