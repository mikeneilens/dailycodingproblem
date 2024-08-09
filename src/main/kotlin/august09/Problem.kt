package august09

//Implement regular expression matching with the following special characters:
//
//. (period) which matches any single character
//* (asterisk) which matches zero or more of the preceding element
//That is, implement a function that takes in a string and a valid regular expression and returns whether the string matches the regular expression.
//
//For example, given the regular expression "ra." and the string "ray", your function should return true. The same regular expression on the string "raymond" should return false.
//
//Given the regular expression ".*at" and the string "chat", your function should return true. The same regular expression on the string "chats" should return false.

sealed class RegexItem {
    abstract fun isMatched(c:Char):Boolean

    data class Character(val value:Char):RegexItem() {
        override fun isMatched(c:Char) = c == value
    }

    data class Repeat(val value:RegexItem):RegexItem() {
        override fun isMatched(c:Char) = value.isMatched(c)
    }

    data object Wildcard:RegexItem() {
        override fun isMatched(c: Char) = true
    }
}

fun String.parse():List<RegexItem> = foldIndexed(listOf()){ index, result, char ->
    when {
        index < lastIndex && get(index + 1) == '*' -> result + RegexItem.Repeat(char.charOrWildCard())
        char == '*' -> result
        else -> result + char.charOrWildCard()
    }
}

fun Char.charOrWildCard() = if (equals('.')) RegexItem.Wildcard else RegexItem.Character(this)

fun problem(s:String, regex:List<RegexItem>):Boolean {
    var regexIndex = 0
    s.forEach { char ->
        if (regexIndex > regex.lastIndex) return false
        if (regex[regexIndex] is RegexItem.Repeat) {
            if (!regex[regexIndex].isMatched(char)) {
                regexIndex ++
            }
        }
        if (!regex[regexIndex].isMatched(char)) return false
        if (regex[regexIndex] !is RegexItem.Repeat) regexIndex++
    }
    return regexIndex == regex.size || regex.last() is RegexItem.Repeat && regex.last().isMatched(s.last())
}