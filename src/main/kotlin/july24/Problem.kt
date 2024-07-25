package july24

//Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.
//
//For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.
//
//Follow-up: Can you do this in O(N) time and constant space?


//For index 0 create list of [index 0, index 2] and [index 0, index 3]
//For index 1 create list of [index 1, index 3] and [index 1, index 4]
//Apply this pattern to the last index of each list so [index 0, index 2] becomes [index 0, index 2, index 2 + 2] and [index 0, index 2, index 2 +3]

fun createLists(lists:List<List<Int>> = listOf(listOf(0),listOf(1)), maxIndex:Int):List<List<Int>> {
    var newLists = mutableListOf<List<Int>>()
    lists.forEach { list ->
        if (list.last() +2 <= maxIndex ) {
            newLists.add(list + (list.last() + 2))
            if (list.last() +3 <= maxIndex ) newLists.add(list + (list.last() + 3))
        } else {
            newLists.add(list)
        }
    }
    return if (newLists.any{it.last() + 2 <= maxIndex}) createLists(newLists, maxIndex)
    else newLists
}
fun largestSumOfNonAdjacentNumbers(numbers:List<Int>) = when {
    (numbers.isEmpty()) -> 0
    (numbers.size == 1) -> numbers[0]
    else -> createLists(maxIndex = numbers.lastIndex).map{ it.sumOf{ index -> numbers[index] }}.max()
}
