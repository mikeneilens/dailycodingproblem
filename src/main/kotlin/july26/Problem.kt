package july26

fun autocomplete(s:String, dictionary:Map<String, Set<String>>) = dictionary.getOrDefault(s.lowercase(),"")

fun createDictionary(animals:List<String>): Map<String, Set<String>> {
    val dictionary = mutableMapOf<String, Set<String>>()
    animals.forEach { animal ->
        val keys = animal.toDictionaryKeys()
        keys.forEach { key -> if (dictionary.contains(key)) dictionary[key] = dictionary.getValue(key) + animal else dictionary[key] = setOf(animal) }
    }
    return dictionary
}

fun String.toDictionaryKeys():List<String> = indices.map{take(it + 1).lowercase()}