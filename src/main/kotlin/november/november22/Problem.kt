package november.november22

import kotlin.math.roundToInt

//Given a real number n, find the square root of n. For example, given n = 9, return 3.

fun problem(n:Int):Int  {
    val checker = createChecker(n) { (it * it).roundToInt() }
    return binarySearch(0.0, n.toDouble()/2, checker)
}

enum class Result {
    Matches, TooBig, TooSmall
}

fun binarySearch(min:Double, max:Double, checker:(Double) ->Result):Int =
    listOf(min, max).average().let{midpoint ->
        when (checker(midpoint)) {
            Result.Matches -> midpoint.roundToInt()
            Result.TooBig -> binarySearch(min, midpoint - 0.1, checker)
            Result.TooSmall -> binarySearch(midpoint + 0.1, max, checker)
        }
    }

fun createChecker(n:Int, f:(Double) -> Int = {it.roundToInt()} ) = { m:Double -> f(m).let{
    if(it == n) Result.Matches else if (it > n ) Result.TooBig else Result.TooSmall
} }