package november.november19

//Write a function that rotates a list by k elements.
// For example, [1, 2, 3, 4, 5, 6] rotated by two becomes [3, 4, 5, 6, 1, 2].
// Try solving this without creating a copy of the list. How many swap or move operations do you need?

//simple solution:
fun List<Int>.rotateLeft(k: Int) = drop(k % size).takeLast(size - k % size) + take(k % size)


//rotate in situ.
// This requires reversing first k elements, reversing the remaining elements and then reversing the whole list.
fun MutableList<Int>.rotateLeft2(k: Int):List<Int> =
    reverseSubString(0, k % size - 1)
        .reverseSubString(k % size , lastIndex)
        .reverseSubString(0, lastIndex)

fun MutableList<Int>.reverseSubString(start:Int, end:Int):MutableList<Int> =
    if (start >= end) this
    else swap(start, end).reverseSubString(start + 1, end - 1)

fun MutableList<Int>.swap(a:Int, b:Int): MutableList<Int> {
    this[a] = this[b].also { this[b] = this[a] }
    return this
}