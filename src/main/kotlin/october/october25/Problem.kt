package october.october25

//Given a list of integers and a number K, return which contiguous elements of the list sum to K.
//
//For example, if the list is [1, 2, 3, 4, 5] and K is 9, then it should return [2, 3, 4], since 2 + 3 + 4 = 9.



fun problem(numbers:List<Int>, target:Int):List<List<Int>> =
    numbers.createListOfSubLists()
        .flatMap{it.leadingSubListWithTotalEqualTo(target)}
        .filter { it.isNotEmpty() }

fun List<Int>.createListOfSubLists() =
    fold(listOf<List<Int>>()) { result, n ->
        if (result.isEmpty()) listOf(listOf(n))
        else result.map{it + n} + listOf(listOf(n))
    }

//In theory one list may contain more than one sublist that starts at 0 that adds up to the total
fun List<Int>.leadingSubListWithTotalEqualTo(total:Int):List<List<Int>> {
    val last = foldIndexed(Pair(0, listOf<List<Int>>())){index, result, n ->
        if (result.first + n == total) Pair(result.first + n, result.second + listOf(subList(0, index + 1)) )
        else Pair(result.first + n, result.second)
    }
    return last.second
}