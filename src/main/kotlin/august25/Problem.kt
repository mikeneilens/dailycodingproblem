package august25

//Given an array of integers where every integer occurs three times except for one integer,
// which only occurs once, find and return the non-duplicated integer.
//
//For example, given [6, 1, 3, 3, 3, 6, 6], return 1. Given [13, 19, 13, 13], return 19.
//
//Do this in O(N) time and O(1) space.


data class Status(val ones:Int = 0, val twos:Int = 0) {
    fun updateForNumber(num:Int):Status {
        val updatedTwos = twos or (ones and num)
        val updatedOnes = ones xor num
        val not_threes = (updatedOnes and updatedTwos).inv()
        return Status(updatedOnes and not_threes, updatedTwos and not_threes )
    }
}

fun problem(numbers: List<Int>):Int = numbers.fold(Status(), Status::updateForNumber  ).ones

