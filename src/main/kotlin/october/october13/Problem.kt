package october.october13

//Given an integer n and a list of integers l, write a function that randomly generates a number
// from 0 to n-1 that isn't in l (uniform).


fun problem(n:Int, l:List<Int>, randFunction:List<Int>.() -> Int = List<Int>::random):Int =
    rangeExcludingList(n, l).toList().randFunction()

fun rangeExcludingList(n:Int, l:List<Int>) = (0..<n).toSet() - l.toSet()