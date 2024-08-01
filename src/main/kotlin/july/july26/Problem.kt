package july.july26

fun autocomplete(s:String, dictionary:Map<String, Set<String>>) = dictionary.getOrDefault(s.lowercase(),"")

fun createDictionary(animals:List<String>): Map<String, Set<String>> {
    val dictionary = mutableMapOf<String, Set<String>>()
    animals.forEach { animal ->
        val keys = animal.toDictionaryKeys()
        keys.forEach { key -> dictionary.addAnimalForKey(key, animal) }
    }
    return dictionary
}

fun MutableMap<String, Set<String>>.addAnimalForKey(key: String, animal: String) {
    if (key in this) this[key] = getValue(key) + animal else this[key] = setOf(animal)
}

fun String.toDictionaryKeys():List<String> = indices.map{take(it + 1).lowercase()}