package september.september24

//Using a function rand7() that returns an integer from 1 to 7 (inclusive) with uniform probability,
// implement a function rand5() that returns an integer from 1 to 5 (inclusive).

fun rand5(rand7:()->Int = { (1..7).random()}):Int {
    val r = rand7()
    return if (r > 5 ) rand5(rand7) else r
}