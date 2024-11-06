package november.november06

//Given a string of words delimited by spaces, reverse the words in string. For example, given "hello world here",
// return "here world hello"
//
//Follow-up: given a mutable string representation, can you perform this operation in-place?


fun problemSimple(string:String) = string.split(" ").reversed().joinToString(" ")

fun problem(mutableString:MutableList<Char>) {
    mutableString.reverseInPlace()
    mutableString.reverseWords()
}

fun MutableList<Char>.reverseInPlace(start:Int = 0, end:Int = lastIndex) {
    if (start > end) return
    swap(start,end)
    reverseInPlace(start + 1, end - 1)
}

fun MutableList<Char>.swap(a:Int, b:Int) {
    this[a] = this[b].also { this[b] = this[a]}
}

fun MutableList<Char>.reverseWords(wordStart:Int = 0) {
    if (wordStart > lastIndex ) return
    val nextWordStart = findStartIndexOfNextWord(wordStart)
    val wordEnd = findEndIndexOfWord(nextWordStart)
    reverseInPlace(nextWordStart, wordEnd - 1)
    reverseWords(wordEnd)
}

fun MutableList<Char>.findStartIndexOfNextWord(start:Int = 0):Int =
    if (start < size && get(start) == ' ') findStartIndexOfNextWord( start + 1) else start

fun MutableList<Char>.findEndIndexOfWord(end:Int = 0):Int =
    if (end < size && get(end) != ' ') findEndIndexOfWord( end + 1) else end

