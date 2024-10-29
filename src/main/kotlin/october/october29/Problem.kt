package october.october29

//Given an integer list where each number represents the number of hops you can make,
// determine whether you can reach to the last index starting at index 0.
//
//For example, [2, 0, 1, 0] returns True while [1, 1, 0, 1] returns False.


fun problem(numbers:List<Int>) = numbers.hopUntilEnd().isNotEmpty()

//assume integers are all positive
fun List<Int>.hopUntilEnd(position:Int = 0, result:List<Int> = listOf(0)):List<List<Int>> = when {
        position == lastIndex -> listOf(result)
        position > lastIndex || get(position) == 0 -> listOf()
        else -> (1..get(position)).flatMap { hop -> hopUntilEnd(position + hop, result + hop) }
    }
