package august.august24

//Given an array of integers where every integer occurs three times except for one integer,
// which only occurs once, find and return the non-duplicated integer.
//
//For example, given [6, 1, 3, 3, 3, 6, 6], return 1. Given [13, 19, 13, 13], return 19.
//
//Do this in O(N) time and O(1) space.


data class Status(val ones:Int = 0, val twos:Int = 0) {
    fun updateForNumber(num:Int): Status {
        val updatedOnes = ones xor num
        val updatedTwos = twos or (ones and num)
        val not_threes = (updatedOnes and updatedTwos).inv()
        return Status(updatedOnes and not_threes, updatedTwos and not_threes )
    }
}

fun problem(numbers: List<Int>):Int = numbers.fold(Status(), Status::updateForNumber  ).ones

//Solution that doesn't run in O(1) space that uses the same principle but uses sets instead of bitwise logic
data class StatusSimple(val ones:Set<Int> = emptySet(), val twos:Set<Int> = emptySet()) {
    fun updateForNumber(num:Int): StatusSimple =
        if (num in ones) StatusSimple(ones - num, twos + num)
        else if (num in twos) StatusSimple(ones , twos -num)
        else StatusSimple(ones + num, twos)
}

fun problemSimple(numbers: List<Int>):Int = numbers.fold(StatusSimple(), StatusSimple::updateForNumber  ).ones.first()
