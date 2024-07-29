package july29

import kotlin.math.pow
import kotlin.random.Random

//The area of a circle is defined as πr^2. Estimate π to 3 decimal places using a Monte Carlo method.
//
//Hint: The basic equation of a circle is x^2 + y^2 = r^2.


//Assume a circle has diameter of 1.0. The centre of the circle is at point (0.5, 0.5).
//The distance point (a,b) is from the center is:
//     squareRoot of (a^2 + y^2) where a and b are the horizontal and vertical distance from the centre.
fun pointIsInCircle(x:Double, y:Double) = ((y - 0.5).pow(2) + (x - 0.5).pow(2)).pow(0.5) <= 0.5


fun addPointsToCircle(qtyToAdd:Int, randomDouble:()->Double = {Random.nextDouble()} ):Int {
    var i = 0
    var qtyInsideCircle = 0
    while (i++ < qtyToAdd) {
        if (pointIsInCircle(randomDouble(),randomDouble())) qtyInsideCircle++
    }
    return qtyInsideCircle
}

//On a 1 X 1 square containing a circle with a diameter of 1,  Pi is equal to 4 X (points inside a circle)/(total number of points)
fun calculatePi(qtyToAdd:Int):Double {
    val qtyInsideCirlce = addPointsToCircle(qtyToAdd)
    return (4.0 * qtyInsideCirlce / qtyToAdd).roundToThreeDigits()
}

fun Double.roundToThreeDigits() = "%.${3}f".format(this).toDouble()