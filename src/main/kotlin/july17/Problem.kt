package july17

//Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.
//
//For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
//
//Follow-up: what if you can't use division?

fun productExcludingItemAtIndex(numbers:List<Int>):List<Int> {
    val product = numbers.product()
    return numbers.map(product::div)
}

fun List<Int>.product() = reduceOrNull(Int::times) ?: 0

fun productExcludingItemAtIndexNoDivision(numbers:List<Int>) =
    numbers.mapIndexed(numbers::productExcludingItemAtIndex)

fun List<Int>.productExcludingItemAtIndex(index:Int, element:Int = 0) =
    reduceIndexedOrNull(){ i, acc, v -> if (i != index) acc * v else acc } ?: 0
