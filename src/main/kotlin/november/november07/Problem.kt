package november.november07

//Given a string and a set of delimiters, reverse the words in the string while maintaining the relative order
// of the delimiters. For example, given "hello/world:here", return "here/world:hello"
//
//Follow-up: Does your solution work for the following cases: "hello/world:here/", "hello//world:here"


fun problem(string:String):String {
    val delimitersAndWords = string.toListOfDelimitersAndWords().toMutableList()
    delimitersAndWords.reverseWords()
    return delimitersAndWords.joinToString("")
}

enum class CharType{
    Delimiter, IsNotDelimiter
}

fun Char.charType(): CharType =
    if (this in 'a'..'z' || this in 'A'..'Z') CharType.IsNotDelimiter
    else CharType.Delimiter

fun String.toListOfDelimitersAndWords():List<String> = fold(listOf()) { result, char ->
    if (result.isEmpty() || result.last().last().charType() != char.charType())
        result + listOf( "$char")
    else
        result.addCharToLast(char)
}

fun List<String>.addCharToLast(char:Char) = dropLast(1) + listOf((last() + char))

fun MutableList<String>.reverseWords(first:Int = 0,last:Int = lastIndex) {
    if (first <= last ) Pair(indexOfFirstWordAfter(first), indexOfFirstWordBefore(last)).let{swapAndRepeat(it)}
}

fun MutableList<String>.swapAndRepeat(pair:Pair<Int, Int>) {
    swap(pair.first,pair.second)
    reverseWords(pair.first + 1, pair.second - 1)
}

fun List<String>.indexOfFirstWordAfter(ndx:Int):Int = indexOfFirstWord(ndx, +1)

fun List<String>.indexOfFirstWordBefore(ndx:Int):Int = indexOfFirstWord(ndx, -1)

fun List<String>.indexOfFirstWord(ndx:Int, increment:Int):Int = when {
    ndx !in indices -> ndx
    this[ndx].first().charType() == CharType.IsNotDelimiter -> ndx
    else -> indexOfFirstWord(ndx + increment, increment)
}

fun <E>MutableList<E>.swap(a:Int, b:Int) {
    if (a in indices && b in indices) this[a] = this[b].also { this[b] = this[a]}
}


