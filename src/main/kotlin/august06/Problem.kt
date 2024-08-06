package august06

//Given a dictionary of words and a string made up of those words (no spaces), return the original sentence in a list. If there is more than one possible reconstruction, return any of them. If there is no possible reconstruction, then return null.
//
//For example, given the set of words 'quick', 'brown', 'the', 'fox', and the string "thequickbrownfox",
// you should return ['the', 'quick', 'brown', 'fox'].
//
//Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond', and the string "bedbathandbeyond",
// return either ['bed', 'bath', 'and', 'beyond] or ['bedbath', 'and', 'beyond'].

fun problem(dictionary:Set<String>, string:String) = if (string.isEmpty() || dictionary.isEmpty()) null else string.findWordsIn(dictionary)

tailrec fun String.findWordsIn(dictionary:Set<String>, result:List<String> = listOf()):List<String> =
    if (isEmpty())
        result
    else {
        val (length ,wordFound) = wordFoundIn(dictionary)
        drop(length).findWordsIn(dictionary,  result + wordFound )
    }

//returns either (word.length, [word]) if word is found in the dictionary or (1, []) if it isn't found
fun String.wordFoundIn(dictionary: Set<String>):Pair<Int, List<String>> {
    val wordLength = (1..length).lastOrNull{ take(it) in dictionary }
    return if (wordLength != null) Pair(wordLength, listOf( take(wordLength))) else Pair(1, listOf())
}
