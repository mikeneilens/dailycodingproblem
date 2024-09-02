package august.august26

//Given a list of integers S and a target number k, write a function that returns a subset of S that adds up to k. If such a subset cannot be made, then return null.
//
//Integers can appear more than once in the list. You may assume all numbers in the list are positive.
//
//For example, given S = [12, 1, 61, 5, 9, 2] and k = 24, return [12, 9, 2, 1] since it sums up to 24.


data class Status(val target:Int, var result:List<Int> = listOf())

//this could be optimised to avoid retrying the same numbers, e.g. if the answer doesn't contain 12, skip all 12s in the list
fun problem(numbers: List<Int>, target: Int):List<Int>? {
    if (numbers.isEmpty()) return null
    val result = findTarget(numbers, Status(target = target))
    return result.ifEmpty { problem(numbers.drop(1), target) }
}

//Depth first search.
fun findTarget(numbers:List<Int>, status: Status, result:List<Int> = listOf(), sum:Int = 0):List<Int> =
    if (sum ==  status.target) {
        status.result = result
        result
    } else numbers.filter{number -> sum + number <= status.target }
        .flatMap{number ->
            if (status.result.isEmpty()) findTarget(numbers.removeFirst(number), status, result + number, sum + number)
            else listOf()
        }

fun List<Int>.removeFirst(n:Int):List<Int> {
    val index:Int = this.indexOfFirst { it == n }
    return subList(0, index) + subList(index + 1, size)
}

