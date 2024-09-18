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
        else -> firstHorizontal() +
                firstVertical() +
                secondHorizontal() +
                secondVertical() +
                removeBorder().clockwiseSpiral()
    }

fun List<List<Int>>.firstHorizontal() = get(0).subList(0, m)
fun List<List<Int>>.firstVertical() = subList(1, n - 1 + 1).map{it[m - 1]}
fun List<List<Int>>.secondHorizontal() = get(n - 1 ).subList(0 , m  - 1).reversed()
fun List<List<Int>>.secondVertical() = subList(1, n - 1).map{it[0]}.reversed()

fun List<List<Int>>.removeBorder() = subList(1, n - 1).map{it.subList(1, m - 1)}

val List<List<Int>>.n get() = size

val List<List<Int>>.m get() = first().size
