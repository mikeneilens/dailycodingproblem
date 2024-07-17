package july16

import foundNumbers
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import numbersAddUpToK
import targetFound

class ProblemTest: StringSpec( {
    "given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17" {
        numbersAddUpToK(numbers = listOf(10,15,3,7), k = 17) shouldBe true
    }

    "given an empty set and number 3 and target of 7, target is not found in set" {
        val foundNumbers = setOf<Int>()
        targetFound(foundNumbers = foundNumbers, n = 3, k = 7) shouldBe false
    }

    "given a set containing 2 and number 3 and target of 7, target is not found in set" {
        val foundNumbers = setOf<Int>(2)
        targetFound(foundNumbers = foundNumbers, n = 3, k = 7) shouldBe false
    }
    "given a set containing 4 and number 3 and target of 7, target is not found in set" {
        val foundNumbers = setOf<Int>(4)
        targetFound(foundNumbers = foundNumbers, n = 3, k = 7) shouldBe true
    }
})