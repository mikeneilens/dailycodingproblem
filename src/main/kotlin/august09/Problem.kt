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
    abstract infix fun matches(c:Char):Boolean

    data class Character(val value:Char):RegexItem() {
        override infix fun matches(c:Char) = c == value
    }

    data class Repeat(val value:RegexItem):RegexItem() {
        override infix fun matches(c:Char) = value.matches(c)
    }

    data object Wildcard:RegexItem() {
        override infix fun matches(c: Char) = true
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

fun problem(string:String, regex:List<RegexItem>, sIndex:Int = 0, rIndex:Int = 0):Boolean = when {
    (sIndex > string.lastIndex) -> rIndex == regex.size || regex.last() is RegexItem.Repeat && regex.last() matches string.last()

    (rIndex > regex.lastIndex) -> false

     (regex[rIndex] is RegexItem.Repeat) -> {
         if ( regex[rIndex] matches string[sIndex]) {
             problem(string, regex, sIndex + 1, rIndex)
         } else {
             problem(string, regex, sIndex, rIndex + 1)
         }
     } else -> {
         if (regex[rIndex] matches string[sIndex]) {
             problem(string, regex, sIndex + 1, rIndex + 1)
         } else {
            false
         }
     }
}
