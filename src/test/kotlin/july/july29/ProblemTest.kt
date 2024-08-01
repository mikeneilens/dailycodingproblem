package july.july29

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import july.july29.calculatePi
import july.july29.pointIsInCircle
import july.july29.qtyOfRandomPointsInsideCircle

class ProblemTest: StringSpec({
    "point 0.5, 0.5 is inside the circle" {
        pointIsInCircle(x = 0.5, y = 0.5) shouldBe true
    }
    "point 1, 0.5 is inside the circle" {
        pointIsInCircle(x = 1.0, y = 0.5) shouldBe true
    }
    "point 1.01, 0.5 is outside the circle" {
        pointIsInCircle(x = 1.01, y = 0.5) shouldBe false
    }
    "point 0.1, 0.1 is outside the circle" {
        pointIsInCircle(x = 0.1, y = 0.1) shouldBe false
    }
    "if random generator always returns 1.0 all points generated will be outside of the circle" {
        qtyOfRandomPointsInsideCircle(qtyToAdd = 100, randomDouble =  {1.0}) shouldBe 0
    }
    "if random generator always returns 0.5 all points generated will be inside of the circle" {
        qtyOfRandomPointsInsideCircle(qtyToAdd = 100, randomDouble =  {0.5}) shouldBe 100
    }
    "calculate pi" {
        val pi = calculatePi(1000000)
        println(pi)
        (pi > 3.13 && pi < 3.15) shouldBe true
    }
    "calculate pi more precisely" {
        val pi = calculatePi(10000000)
        println(pi)
        (pi > 3.14 && pi < 3.145) shouldBe true
    }
    "calculate pi even more precisely" {
        val pi = calculatePi(100000000)
        println(pi)
        (pi > 3.14 && pi < 3.145) shouldBe true
    }
})