package october.october19

//Given a number in the form of a list of digits, return all possible permutations.
//
//For example, given [1,2,3], return [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

//Simple solution
fun <V>permutation(set:Set<V>, result:List<List<V>> = listOf(listOf())):List<List<V>> =
    if (set.isEmpty()) result
    else set.flatMap { n -> permutation(set - n, result.map{ it + n } )}

//Heap's algorithm
 fun <V>MutableList<V>.permutations(k: Int = this.size, retVal:MutableList<List<V>> = mutableListOf()):List<List<V>> {

     if (k == 1) {
         retVal.add(this.toList())
     } else {
         (0 until k).forEach { i ->
             if (k % 2 == 0) {
                 permutations(k - 1, retVal).also{ swap(i, k - 1) }
             } else {
                 permutations(k - 1, retVal).also{ swap(0, k - 1) }
             }
         }
     }
     return retVal
 }

fun <E>MutableList<E>.swap(a:Int, b:Int) { this[a]= this[b].also { this[b] = this[a] } }
