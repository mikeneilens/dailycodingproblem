package july19

//Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.
//
//For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
//
//You can modify the input array in-place.

fun List<Int>.firstMissingPositiveInteger():Int {
    val elementsGreaterThanZero = filter { it > 0 }.distinct()
    return (elementsGreaterThanZero
        .sorted()
        .withIndex()
        .firstOrNull(::indexDoesNotMatchElement)?.index ?: elementsGreaterThanZero.size ) + 1
}

fun indexDoesNotMatchElement(indexedValue:IndexedValue<Int>) = (indexedValue.index + 1 != indexedValue.value)



