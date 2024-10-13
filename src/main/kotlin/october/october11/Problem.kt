package october.october11

//Implement division of two positive integers without using the division, multiplication, or modulus operators.
// Return the quotient as an integer, ignoring the remainder.

infix fun Int.div(numerator:Int):Int = when {
    (numerator == 0) -> throw ArithmeticException()
    (numerator < 0 && this > 0) -> -div(-numerator, 0)
    (numerator > 0 && this < 0) -> -(-this).div(numerator, 0)
    (numerator < 0 && this < 0) -> (-this).div(-numerator, 0)
    else ->  this.div(numerator, 0)
}

fun Int.div(numerator:Int, result:Int):Int =
    if (this - numerator < 0) result else (this - numerator).div(numerator, result + 1)