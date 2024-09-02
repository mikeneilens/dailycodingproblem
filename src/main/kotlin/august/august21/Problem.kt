package august.august21

//The power set of a set is the set of all its subsets. Write a function that, given a set, generates its power set.
//
//For example, given the set {1, 2, 3}, it should return {{}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}}.
//
//You may also use a list or array to represent a set.

fun <E>Set<E>.powerSet(output:Set<Set<E>> = setOf(setOf())):Set<Set<E>> =
    if (isEmpty())
        output
    else
        drop(1).toSet().powerSet( output + output.map{ set -> set + first() })


