package august.august19

//Given an array of strictly the characters 'R', 'G', and 'B', segregate the values of the array so that all the Rs come first,
// the Gs come second, and the Bs come last. You can only swap elements of the array.
//
//Do this in linear time and in-place.
//
//For example, given the array ['G', 'B', 'R', 'R', 'B', 'R', 'G'], it should become ['R', 'R', 'R', 'G', 'G', 'B', 'B'].

//This is the Dutch national flag problem
fun threeWayPartition(array:MutableList<String>) {
    var bottomIndex = 0
    var topIndex = array.lastIndex
    var index = 0

    while (index <= topIndex) {
        when (array[index]) {
           "R" -> array.swap(bottomIndex++, index++)
           "B" -> array.swap(index, topIndex--)
            else -> index++
        }
    }
}

fun <E>MutableList<E>.swap(index1:Int, index2:Int) {
    this[index1] = this[index2].also{ this[index2] = this[index1] }
}