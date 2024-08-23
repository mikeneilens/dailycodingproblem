package august.august17

//Compute the running median of a sequence of numbers. That is, given a stream of numbers, print out the median of the list so far on each new element.
//
//Recall that the median of an even-numbered list is the average of the two middle numbers.
//
//For example, given the sequence [2, 1, 5, 7, 2, 0, 5], your algorithm should print out:
//
//2
//1.5
//2
//3.5
//2
//2
//2

fun problem(list:List<Int>):List<Double> = list.fold(Pair(listOf<Double>(), listOf<Int>())){ output, value ->
        val newMedian = (output.second + listOf(value)).median()
        Pair(output.first + newMedian, output.second + value)
}.first

fun List<Int>.median():Double {
    val middleRange = middleRange()
    val sorted = sorted()
    return 1.0 * middleRange.sumOf { sorted[it] } / middleRange.size
}

fun List<Int>.middleRange() = if (size % 2 == 1) listOf(size/2) else listOf(size/2 - 1, size/2)
