package september.september28

//Given an array of numbers, find the length of the longest increasing subsequence in the array.
// The subsequence does not necessarily have to be contiguous.
//
//For example, given the array [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15],
// the longest increasing subsequence has length 6: it is 0, 2, 6, 9, 11, 15.

fun problem(numbers:List<Int>):Int =
    numbers.indices.maxOf { index -> numbers.longSequence(index).maxOf { it.size } }

//depth first search - this could be really inefficient for a long list
fun List<Int>.longSequence(currentIndex:Int = 0, result:List<Int> = listOf(currentIndex)):List<List<Int>> =
    getOptions(currentIndex).let{ options ->
        if (options.isEmpty()) listOf(result)
        else options.flatMap {index -> longSequence(index, result + index) }
    }

fun List<Int>.getOptions(currentIndex: Int) =
    mapIndexedNotNull { index, num -> if (index > currentIndex && num > get(currentIndex)) index else null }


