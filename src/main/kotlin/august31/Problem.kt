package august31

//Given a string, find the longest palindromic contiguous substring.
// If there are more than one with the maximum length, return any one.
//
//For example, the longest palindromic substring of "aabcdcb" is "bcdcb".
// The longest palindromic substring of "bananas" is "anana".

fun problem(s:String) = s.mapIndexed { index, _ -> maxPalindrome(s, index) }.maxByOrNull { it.length }

fun maxPalindrome(s:String, position:Int) =
    if (position + 1 in  s.indices && s[position] == s[position + 1])
        maxPalindrome(s, position, position - 1, position + 2 )
    else
        maxPalindrome(s, position, position - 1, position + 1 )

fun maxPalindrome(s:String, position:Int, newStart:Int, newEnd:Int):String = when {
    (newStart < 0 || newEnd > s.lastIndex) -> s.substring (newStart + 1 ..< newEnd)
    (s[newStart] != s[newEnd]) ->  s.substring(newStart + 1..< newEnd)
    else -> maxPalindrome(s, position, newStart - 1, newEnd + 1)
}