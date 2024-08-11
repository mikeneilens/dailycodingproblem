package august.august06

//Given a dictionary of words and a string made up of those words (no spaces), return the original sentence in a list. If there is more than one possible reconstruction, return any of them. If there is no possible reconstruction, then return null.
//
//For example, given the set of words 'quick', 'brown', 'the', 'fox', and the string "thequickbrownfox",
// you should return ['the', 'quick', 'brown', 'fox'].
//
//Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond', and the string "bedbathandbeyond",
// return either ['bed', 'bath', 'and', 'beyond] or ['bedbath', 'and', 'beyond'].

fun problem(dictionary:Set<String>, string:String) = string.findWordsIn(dictionary).filter(List<String>::isNotEmpty)

fun String.findWordsIn(dictionary:Set<String>, result:List<String> = listOf()):List<List<String>> =
    when {
        isEmpty() -> listOf(result)
        else -> wordsFoundIn(dictionary)
            .flatMap{wordFound -> drop(wordFound.length).findWordsIn(dictionary, result + listOf(wordFound))}
    }

fun String.wordsFoundIn(dictionary: Set<String>):List<String> =
    (1..length).mapNotNull{ if (take(it) in dictionary) take(it) else null }


