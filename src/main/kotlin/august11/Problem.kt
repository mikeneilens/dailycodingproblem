package august11

//Given a string of round, curly, and square open and closing brackets, return whether the brackets are balanced (well-formed).
//
//For example, given the string "([])[]({})", you should return true.
//
//Given the string "([)]" or "((()", you should return false.

fun problem(string:String) = string.removeMatchedBrackets() == ""

fun String.removeMatchedBrackets(brackets:Map<Char, Char> = mapOf('(' to ')', '{' to '}', '[' to ']')) =
    fold(""){output, char -> when {
            (output.isEmpty()) -> "$char"
            ( brackets[output.last()] == char) -> output.dropLast(1)
            else -> output + char
        }
    }
