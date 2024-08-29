package august30

//Using a function rand5() that returns an integer from 1 to 5 (inclusive) with uniform probability,
//implement a function rand7() that returns an integer from 1 to 7 (inclusive).

fun rand5() = (1..5).random()

fun rand25(rand5:()->Int) = rand5() * 5 + rand5() - 5 //generates a random number between 1 and 25

fun rand7(rand5:()->Int = ::rand5):Int =
    rand25(rand5).let { n -> if (n > 21) rand7(rand5) else (n % 7) + 1 }
