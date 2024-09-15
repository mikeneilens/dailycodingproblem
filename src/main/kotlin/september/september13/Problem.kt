package september.september13

//Given a multiset of integers, return whether it can be partitioned into two subsets whose sums are the same.
//
//For example, given the multiset {15, 5, 20, 10, 35, 15, 10}, it would return true, since we can split it up
// into {15, 5, 10, 15, 10} and {20, 35}, which both add up to 55.
//
//Given the multiset {15, 5, 20, 10, 35}, it would return false, since we can't split it up into two subsets that
// add up to the same sum.

//Had to use a class as Ints can't ve duplicated in a set
class Num(val value:Int) {
    override fun toString(): String = "$value"
}

fun permutations(set:Set<Num>, result:Set<Set<Num>> = set.map{setOf(it)}.toSet()):Set<Set<Num>> {
    if (set.isEmpty()) return setOf()
    if (set in result ) return result
    val newResult =  result.flatMap { s -> set.map{ n -> s + n }.toSet()}.toSet()
    if (newResult.contains(set)) return newResult
    else return permutations(set, newResult)
}

fun permutationsContainingTwo(set:Set<Set<Num>>, n:Int):Set<Set<Set<Num>>>  {
    val permutations =  set.combineIntoPairs()
    return permutations.filter { it.first().size + it.last().size == n  && (it.first() + it.last()).size == n }.toSet()
}

fun Set<Set<Num>>.combineIntoPairs(): Set<Set<Set<Num>>> =  flatMap { s -> mapNotNull{ n -> if (n!=s) setOf(s,n) else null }}.toSet()

fun Set<Num>.sum() = sumOf { num -> num.value }

fun problem(set:Set<Num>):Boolean {
    val subsets = permutations(set)
    val permutationsOfSubset = permutationsContainingTwo(subsets, set.size)
    val matchingPairs = permutationsOfSubset.filter { it.first().sum() == it.last().sum()}
    return matchingPairs.isNotEmpty()
}
