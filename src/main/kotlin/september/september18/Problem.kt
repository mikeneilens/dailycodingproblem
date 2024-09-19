package september.september18

//Given an N by M matrix of numbers, print out the matrix in a clockwise spiral.
//
//For example, given the following matrix:
//
//[[1,  2,  3,  4,  5],
// [6,  7,  8,  9,  10],
// [11, 12, 13, 14, 15],
// [16, 17, 18, 19, 20]]
//You should print out the following:
//
// [1,2,3,4,5,10,15,20,19,18,17,16,11,6,7,8,9,14,13,12]

fun List<List<Int>>.clockwiseSpiral():List<Int> =
    when (size) {
        0 -> listOf()
        1 -> first()
        else -> topLine() +
                rightLine() +
                bottomLine() +
                leftLine() +
                removeBorder().clockwiseSpiral()
    }

fun List<List<Int>>.topLine() = elementsFor(0..0, 0..(m - 1))
fun List<List<Int>>.rightLine() = elementsFor(1..(n - 1), (m - 1)..(m - 1))
fun List<List<Int>>.bottomLine() = elementsFor((n - 1)..(n - 1), 0..(m - 2)).reversed()
fun List<List<Int>>.leftLine() = elementsFor(1..(n - 2), 0..0).reversed()

fun List<List<Int>>.removeBorder() =  subList(1, n - 1).map{it.subList(1, m - 1)}

fun List<List<Int>>.elementsFor(rows:IntRange, cols:IntRange) = rows.flatMap { row -> cols.map{col -> this[row][col]} }

val List<List<Int>>.n get() = size

val List<List<Int>>.m get() = first().size
