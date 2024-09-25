package september.september22

//Given a list of integers, return the largest product that can be made by multiplying any three integers.
//
//For example, if the list is [-10, -10, 5, 2], we should return 500, since that's -10 * -10 * 5.
//
//You can assume the list has at least three integers.

fun problem(numbers:List<Int>, sorted:List<Int> = numbers.sorted()) =
    if ( sorted.negativesAreBest()) listOf(sorted[0], sorted[1], sorted.last())  else sorted.takeLast(3)

fun List<Int>.negativesAreBest() = get(0) * get(1) * get(lastIndex) > get(lastIndex) * get(lastIndex - 1) * get(lastIndex - 2)