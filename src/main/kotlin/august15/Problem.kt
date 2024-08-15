package august15

//The edit distance between two strings refers to the minimum number of character insertions, deletions, and
// substitutions required to change one string to the other.
// For example, the edit distance between “kitten” and “sitting” is three:
// substitute the “k” for “s”, substitute the “e” for “i”, and append a “g”.
//
//Given two strings, compute the edit distance between them.

typealias P = Pair<Int, Int>
typealias Matrix = MutableMap<P,Int>

fun Matrix.get(i:Int, j:Int) = get(P(i, j)) ?: 0

fun problem(str1:String, str2: String):Int {
    val matrix  = levenshteinFullMatrix(str1, str2)
    return matrix[P(str1.lastIndex, str2.lastIndex)] ?: 0
}

fun levenshteinFullMatrix(str1: String, str2: String, matrix: Matrix = mutableMapOf()):Matrix {
    str1.forEachIndexed  { i, char1 ->
        str2.forEachIndexed { j, char2 ->
            matrix[P(i + 1, j + 1)] =
                if (char1 == char2) { //Characters match
                    matrix.get(i, j)
                } else {
                    1 + minOf(
                        matrix.get(i + 1, j),   //Insert
                        matrix.get(i,  j + 1),  //Remove
                        matrix.get(i, j) // Replace
                    )
                }
        }
    }
    return matrix
}

