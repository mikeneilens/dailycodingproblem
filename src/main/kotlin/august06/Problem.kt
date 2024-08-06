package august06

//Given a dictionary of words and a string made up of those words (no spaces), return the original sentence in a list. If there is more than one possible reconstruction, return any of them. If there is no possible reconstruction, then return null.
//
//For example, given the set of words 'quick', 'brown', 'the', 'fox', and the string "thequickbrownfox",
// you should return ['the', 'quick', 'brown', 'fox'].
//
//Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond', and the string "bedbathandbeyond",
// return either ['bed', 'bath', 'and', 'beyond] or ['bedbath', 'and', 'beyond'].

fun problem(dictionary:Set<String>, string:String) = string.findWordsIn(dictionary)

tailrec fun String.findWordsIn(dictionary:Set<String>, result:List<String> = listOf()):List<String>? =
    when {
        result.contains("") -> null
        isEmpty() -> result
        else -> {
            val wordFound = wordFoundIn(dictionary)
            drop(wordFound.first().length).findWordsIn(dictionary,  result + wordFound )
        }
    }

fun String.wordFoundIn(dictionary: Set<String>):List<String> {
    val wordLength = (1..length).lastOrNull{ take(it) in dictionary }
    return if (wordLength != null) listOf(take(wordLength)) else listOf("")
}
