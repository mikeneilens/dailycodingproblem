package august02

//Given an array of integers and a number k, where 1 <= k <= length of the array, compute the maximum values of each subarray of length k.
//
//For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:
//
//10 = max(10, 5, 2)
//7 = max(5, 2, 7)
//8 = max(2, 7, 8)
//8 = max(7, 8, 7)
//Do this in O(n) time and O(k) space. You can modify the input array in-place and you do not need to store the results. You can simply print them out as you compute them.

data class Maximum(val value:Int = Int.MIN_VALUE, val count:Int = 0) {
    fun updateValue(new:Int) = Maximum(maxOf(value, new), count + 1)

    fun writeToOutputIfCountEqualsK(k: Int, output: MutableList<Int>):Maximum {
        if (count == k) {
            output.add(value)
            return Maximum()
        } else return this
    }
}

fun sumOfSubArrays(list:List<Int>, k:Int):List<Int> {
    val output = mutableListOf<Int>()
    val maximums = MutableList(k){Maximum()}
    list.forEachIndexed { listIndex, n ->
        maximums.indices.forEach{ i ->
            if (listIndex >= i) {
                maximums[i] = maximums[i].updateValue(n).writeToOutputIfCountEqualsK(k, output)
            }
        }
    }
    return output
}