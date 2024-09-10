package september.september10

//Given a string s and an integer k, break up the string into multiple lines such that each line has a length of k or
// less. You must break it up so that words don't break across lines. Each line has to have the maximum possible
// amount of words. If there's no way to break the text up, then return null.
//
//You can assume that there are no spaces at the ends of the string and that there is exactly one space between each word.
//
//For example, given the string "the quick brown fox jumps over the lazy dog" and k = 10, you should return:
// ["the quick", "brown fox", "jumps over", "the lazy", "dog"]. No string in the list has a length of more than 10.

fun problem(string:String, k:Int):List<String>? {
    if (string.isEmpty() || string.split(" ").any{it.length > k}) return null
    val addWordToOutput = {output:List<String>, word:String -> addWordToOutput(output, word, k)}
    return string.split(" ").fold(emptyList(), addWordToOutput)
}

fun addWordToOutput(output: List<String>, word: String, k: Int, ) =
    if (word.length + output.lengthOfLastString() >= k) output + word  else output.concatonateLastWith(word)

fun List<String>.lengthOfLastString() = lastOrNull()?.length ?: 0

fun List<String>.concatonateLastWith(s:String) = if (isEmpty()) listOf(s) else dropLast(1) + (last() + " $s")
