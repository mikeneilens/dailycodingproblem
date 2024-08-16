package august.august13

//Run-length encoding is a fast and simple method of encoding strings.
// The basic idea is to represent repeated successive characters as a single count and character.
// For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".
//
//Implement run-length encoding and decoding.
//You can assume the string to be encoded have no digits and consists solely of alphabetic characters.
//You can assume the string to be decoded is valid.


fun problem(string: String) = string.toPairs().encodeAsString()

fun List<Pair<Char, Int>>.encodeAsString() = map{"${it.second}${it.first}"}.joinToString("")

fun String.toPairs():List<Pair<Char, Int>> = fold(listOf()) { pairs, char ->
    when {
        pairs.isEmpty() -> listOf(Pair(char, 1))
        pairs.last().first == char -> pairs.incrementLastPair()
        else -> pairs + Pair(char, 1)
    }
}

fun List<Pair<Char, Int>>.incrementLastPair() = dropLast(1) + Pair(last().first, last().second + 1)