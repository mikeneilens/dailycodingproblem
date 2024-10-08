//Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
//
//For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
//
//Bonus: Can you do this in one pass?

fun numbersAddUpToK(numbers:List<Int>, k:Int, foundNumbers:MutableSet<Int> = mutableSetOf()):Boolean {
    numbers.forEach { n ->
        if (targetFound(foundNumbers, n, k)) return true
        else foundNumbers.add(n)
    }
    return false
}

fun targetFound(foundNumbers:Set<Int>, n:Int, k:Int ) = foundNumbers.contains(k - n)