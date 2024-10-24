package october.october24

import kotlin.math.sqrt

//Given an even number (greater than 2), return two prime numbers whose sum will be equal to the given number.
//
//A solution will always exist. See Goldbach’s conjecture.
//
//Example:
//
//Input: 4
//Output: 2 + 2 = 4
//If there are more than one solution possible, return the lexicographically smaller solution.
//
//If [a, b] is one solution with a <= b, and [c, d] is another solution with c <= d, then
//
//[a, b] < [c, d]
//If a < c OR a==c AND b < d.

fun problem(evenNumber:Int, nextPrime:()->Int = createPrimeSequence() ):Pair<Int, Int> {
    val prime = nextPrime()
    return if (isPrime(evenNumber - prime)) Pair(prime, evenNumber - prime)
    else problem(evenNumber, nextPrime)
}

fun createPrimeSequence(start:Int = 1):()->Int {
    var n = start
    return { while(!isPrime(++n)) { continue }; n }
}

fun isPrime(n: Int): Boolean = when {
        (n <= 1) -> false
        (n <= 3) -> true
        (n % 2 == 0 || n % 3 == 0) -> false
        else -> (5..(sqrt(n.toDouble()).toInt()) step 6).firstOrNull{i -> (n % i == 0 || n % (i + 2) == 0)} == null
    }

