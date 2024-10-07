package october.october04

//Given a mapping of digits to letters (as in a phone number), and a digit string, return all possible letters the number could represent. You can assume each valid number in the mapping is a single digit.
//
//For example if {“2”: [“a”, “b”, “c”], 3: [“d”, “e”, “f”], …} then “23” should return [“ad”, “ae”, “af”, “bd”, “be”, “bf”, “cd”, “ce”, “cf"].

val numberMap = mapOf('2' to listOf("a","b","c"), '3' to listOf("d","e","f"))

fun problem(letters:String) = letters.concatAll()

fun String.concatAll( result:List<String> = listOf() ):List<String> = when {
    isEmpty() -> result
    result.isEmpty() -> drop(1).concatAll( numberMap.getValue(first()))
    else -> drop(1).concatAll( result.concat(numberMap.getValue(first())))
}

fun List<String>.concat(other:List<String>) = flatMap{ s ->  other.map{ o -> s + o}}
