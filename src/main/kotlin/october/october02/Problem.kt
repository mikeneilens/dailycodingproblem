package october.october02

//Given an array of integers, write a function to determine whether the array could become non-decreasing by modifying at most 1 element.
//
//For example, given the array [10, 5, 7], you should return true, since we can modify the 10 into a 1 to make the array non-decreasing.
//
//Given the array [10, 5, 1], you should return false, since we can't modify any one element to get a non-decreasing array.

data class Output(val prevMinus1:Int = Int.MIN_VALUE, val prev:Int = Int.MIN_VALUE, val result:List<Int> = listOf())

fun problem(numbers:List<Int>):Boolean = numbers.fold(Output(), ::checkSequence).result.size <= 1

private fun checkSequence(output: Output, number: Int) = when {
    (number < output.prev && output.prev == output.prevMinus1) ->
        Output(prevMinus1 = output.prev, prev = number, output.result + listOf(number, number))
    (number < output.prev) ->
        Output(prevMinus1 = output.prev, prev = number, output.result + number)
    else -> Output(prevMinus1 = output.prev, prev = number, output.result)
}