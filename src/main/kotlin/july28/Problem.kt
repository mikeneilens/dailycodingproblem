package july28

//Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.
//
//For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".

fun longestString(s:String, k:Int, longestFound:String = ""):String {
    if (s.isEmpty()) return longestFound
    val charactersFound = mutableSetOf<Char>()
    val result = s.takeWhile { addCharacterToSetOrReturnFalse(it, k, charactersFound) }
    return if (result.length > longestFound.length) longestString(s.drop(1),k,result) else longestString(s.drop(1),k,longestFound)
}

fun addCharacterToSetOrReturnFalse(c:Char, k:Int, charactersFound:MutableSet<Char>):Boolean {
    if (c !in charactersFound && charactersFound.size == k) return false
    else {
        charactersFound.add(c)
        return true
    }
}