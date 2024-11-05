package november.november03

//Given a word W and a string S, find all starting indices in S which are anagrams of W.
//
//For example, given that W is "ab", and S is "abxaba", return 0, 3, and 4.

fun problem(w: String, s: String):List<Int> =
    if (w.isEmpty()) listOf()
    else {
        val mapper = {index:Int, string:String -> wordMatchesStringIndexOrNull(index, string, w.toList().sorted())}
        s.windowed(w.length,1).mapIndexedNotNull(mapper)
    }


fun wordMatchesStringIndexOrNull(index: Int, s: String, word: List<Char>) =
    if (word == s.toList().sorted()) index else null