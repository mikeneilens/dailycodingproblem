package october.october26

//Given a string and a set of characters, return the shortest substring containing all the characters in the set.
//
//For example, given the string "figehaeci" and the set of characters {a, e, i}, you should return "aeci".
//
//If there is no substring containing all the characters in the set, return null.


fun problem(string:String, chars:Set<Char>):String = string.allSubstringsContaining(chars).minBy { it.length }

fun String.allSubstringsContaining(chars:Set<Char>) =
    foldIndexed(listOf<String>()){position, result, char ->
        if (char in chars) substringContaining(chars, position)?.let{ result + it } ?: result
        else result
    }

fun String.substringContaining(chars:Set<Char>, startPos:Int, result:String = ""):String? = when {
        (chars - result.toCharArray().toSet()).isEmpty() -> result
        startPos > lastIndex -> null
        else -> substringContaining(chars, startPos + 1, result + get(startPos))
    }
