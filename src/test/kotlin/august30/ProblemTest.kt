package august30

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec( {
    "using rand5 for to create a 1..25 random number when first 2 random numbers are 5 gives 25" {
        var r = 0
        val rand5 = { listOf(5,5)[r++] }
        rand25(rand5) shouldBe 25
    }
    "using rand5 for to create a 1..25 random number when first 2 random numbers are 1 gives 1" {
        var r = 0
        val rand5 = { listOf(1,1)[r++] }
        rand25(rand5) shouldBe 1
    }
    "using rand5 for to create a 1..25 random number when first 2 random numbers are [1,2] gives 2" {
        var r = 0
        val rand5 = { listOf(1,2)[r++] }
        rand25(rand5) shouldBe 2
    }
    "using rand5 for to create a 1..25 random number when first 2 random numbers are [1,3] gives 3" {
        var r = 0
        val rand5 = { listOf(1,3)[r++] }
        rand25(rand5) shouldBe 3
    }
    "using rand5 for to create a 1..25 random number when first 2 random numbers are [2,1] gives 6" {
        var r = 0
        val rand5 = { listOf(2,1)[r++] }
        rand25(rand5) shouldBe 6
    }
    "using rand5 for to create a 1..7 random number when first 2 random numbers are 1 gives 2" {
        var r = 0
        val rand5 = { listOf(1,1)[r++] }
        rand7(rand5) shouldBe 2
    }
    "using rand5 for to create a 1..7 random number when first 2 random numbers are [1,2] gives 3" {
        var r = 0
        val rand5 = { listOf(1,2)[r++] }
        rand7(rand5) shouldBe 3
    }
    "using rand5 for to create a 1..7 random number when first 2 random numbers are [2,1] gives 7" {
        var r = 0
        val rand5 = { listOf(2,1)[r++] }
        rand7(rand5) shouldBe 7
    }
    "using rand5 for to create a 1..7 random number when first 2 random numbers are [2,2] gives 1" {
        var r = 0
        val rand5 = { listOf(2,2)[r++] }
        rand7(rand5) shouldBe 1
    }
    "using rand5 for to create a 1..7 random number when first 2 random numbers are [5,5,2,1] gives 7" {
        var r = 0
        val rand5 = { listOf(5,5,2,1)[r++] }
        rand7(rand5) shouldBe 7
    }
    "try rand7 10000 times using a real rand5 and measure spread" {
        val repititions = 10000
        val result = mutableMapOf(1 to 0, 2 to 0, 3 to 0, 4 to 0, 5 to 0, 6 to 0, 7 to 0)
        val hasValidRange = {it:Int -> it/repititions.toDouble() > 0.132 && it/repititions.toDouble() < 0.152 }
        repeat(repititions){
            val n = rand7()
            result[n] = result.getValue(n) + 1
        }
        result.keys.toSet() shouldBe setOf(1,2,3,4,5,6,7)
        (1..7).forEach{n-> hasValidRange(result.getValue(n)) shouldBe true }
    }
})