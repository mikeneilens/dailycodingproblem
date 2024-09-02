package september.september02

//Given an array of numbers, find the maximum sum of any contiguous subarray of the array.
//
//For example, given the array [34, -50, 42, 14, -5, 86], the maximum sum would be 137,
// since we would take elements 42, 14, -5, and 86.
//
//Given the array [-5, -1, -8, -9], the maximum sum would be 0, since we would not take any elements.

//kadanes algorithm
data class Result(val maxSoFar:Int = 0, val maxToHere:Int = 0) {
    fun nextResult(number:Int):Result {
        val newMaxToHere =  maxToHere + number
        return if (newMaxToHere < 0) Result(maxSoFar = maxSoFar, maxToHere = 0)
        else if (newMaxToHere > maxSoFar) Result(maxSoFar = newMaxToHere, maxToHere = newMaxToHere)
        else Result(maxSoFar = maxSoFar, maxToHere = newMaxToHere)
    }
}

fun problem(numbers:List<Int>) =
    numbers.fold(Result(),Result::nextResult).maxSoFar
