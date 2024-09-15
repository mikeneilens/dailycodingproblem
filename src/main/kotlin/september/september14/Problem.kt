package september.september14

//Implement integer exponentiation. That is, implement the pow(x, y) function,
// where x and y are integers and returns x^y.
//
//Do this faster than the naive method of repeated multiplication.
//
//For example, pow(2, 10) should return 1024.

//Use divide and conquer if y > 4 as pow(2,10) is the same as pow(2,5) * pow(2,5)
fun power(x:Int, y:Int, memo:Memo = newMemo()):Int =when  {
    (memo.contains(x,y) ) -> memo.get(x,y)
    (x == 0) ->  0
    (y == 0) -> 1
    (y <=4) ->   List(y){x}.reduce(Int::times).memoize(x,y,memo)
    else -> (power(x, (y/2.0 + 0.5).toInt(), memo) * power(x, y/2, memo)).memoize(x,y,memo)
}

typealias Memo = MutableMap<Pair<Int, Int>, Int>

fun newMemo() = mutableMapOf<Pair<Int, Int>, Int>()

fun Memo.contains(x:Int, y:Int) = Pair(x,y) in this

fun Memo.get(x:Int, y:Int) = getValue(Pair(x,y))

fun Int.memoize(x:Int, y:Int, memo:Memo):Int =this.apply{memo[Pair(x,y)] = this}
