package august.august28


//We can determine how "out of order" an array A is by counting the number of inversions it has.
// Two elements A[i] and A[j] form an inversion if A[i] > A[j] but i < j.
// That is, a smaller element appears after a larger element.
//
//Given an array, count the number of inversions it has. Do this faster than O(N^2) time.
//
//You may assume each element in the array is distinct.
//
//For example, a sorted list has zero inversions. The array [2, 4, 1, 3, 5] has three inversions:
// (2, 1), (4, 1), and (4, 3).
// The array [5, 4, 3, 2, 1] has ten inversions: every distinct pair forms an inversion.

data class Result(var value:Int = 0)

fun mergeSort(slice: List<Int>, result: Result = Result()): List<Int> {
    // Slice of 1 element is always sorted
    if (slice.size == 1) return slice

    // Get middle position
    val middle = slice.size / 2

    // Partition slice by the middle position
    val left = mergeSort(slice.subList(0, middle), result)
    val right = mergeSort(slice.subList(middle, slice.size), result)
    return merge(left, right, result)
}

fun merge(left: List<Int>, right: List<Int>, result: Result): List<Int> {
    val merged: MutableList<Int> = mutableListOf()

    var i = 0
    var j = 0
    while (i < left.size && j < right.size) {
        if (left[i] <= right[j]) {
            merged.add(left[i++])
        } else {
            // This effectively indirectly shifts the element
            // to the left by the number of elements remaining in the first array
            result.value += left.size - i
            merged.add(right[j++])
        }
    }

    merged.addAll (left.subList(i, left.size) + right.subList(j, right.size))

    return merged
}

