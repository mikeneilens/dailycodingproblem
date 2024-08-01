package july.july24

//Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.
//
//For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.
//
//Follow-up: Can you do this in O(N) time and constant space?


data class NonAdjacentSum(val total:Int, val lastIndex:Int, val numbers:List<Int>):Comparable<NonAdjacentSum>{
    fun next():List<NonAdjacentSum>  =
        ((lastIndex + 2)..(lastIndex  + 3)).fold(listOf()){result, index ->
            if (index < numbers.size) result + NonAdjacentSum(total + numbers[index], index, numbers) else result
        }
    override operator fun compareTo(other: NonAdjacentSum): Int = total - other.total
}

fun largestSumOfNonAdjacentNumbers2(numbers:List<Int>):Int = when {
    (numbers.isEmpty()) -> 0
    (numbers.size == 1) -> numbers[0]
    else -> listOf(
        NonAdjacentSum(numbers[0],0, numbers)
        , NonAdjacentSum(numbers[1],1, numbers)
    ).getNextTotals() .maxOf { it.total }
}

fun List<NonAdjacentSum>.getNextTotals():List<NonAdjacentSum> =
    if (any{it.lastIndex + 2 < it.numbers.size}) flatMap { it.next() }.bestResults().getNextTotals()
    else this

fun List<NonAdjacentSum>.bestResults() = maxForKey { it.lastIndex }

fun <E:Comparable<E>,K>List<E>.maxForKey(key: (E)->K):List<E> {
    val bestResults = mutableMapOf<K, E>()
    forEach{
        if (key(it) !in bestResults) bestResults[key(it)] = it
        else if (it > bestResults.getValue(key(it))) bestResults[key(it)] = it
    }
    return bestResults.values.toList()
}
