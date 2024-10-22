package october.october18

//Given a number represented by a list of digits, find the next greater permutation of a number,
// in terms of lexicographic ordering.
// If there is not greater permutation possible, return the permutation with the lowest value/ordering.
//
//For example, the list [1,2,3] should return [1,3,2]. The list [1,3,2] should return [2,1,3].
// The list [3,2,1] should return [1,2,3].


fun problem(numbers:List<Int>) =
    numbers.positionOfLastAscending()?.let{ positionOfLastAscending ->
        val positionToSwap = numbers.positionOfLastDigitGreaterThan(positionOfLastAscending)
        numbers.swap(positionOfLastAscending, positionToSwap).reverseDigitsAfter(positionOfLastAscending)
    } ?: numbers.sorted()

fun List<Int>.positionOfLastAscending(default:Int? = null) =
    foldIndexed(default){index, result, number ->
        if (index < lastIndex && number < get(index + 1)) index
        else result
    }

fun List<Int>.positionOfLastDigitGreaterThan(position:Int) =
    foldIndexed(-1){index, result, number ->
        if (number > get(position)) index
        else result
    }

fun List<Int>.swap(a:Int, b:Int) = toMutableList().swapInt(a, b).toList()

fun MutableList<Int>.swapInt(a:Int, b:Int):List<Int> {
    this[a]= this[b].also { this[b] = this[a] }
    return this
}

fun List<Int>.reverseDigitsAfter(position:Int) =
    if (position >= lastIndex) this
    else (dropLast(lastIndex - position)) + subList(position + 1, size).reversed()
