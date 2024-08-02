package august02

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec( {
    "empty list should give empty array" {
        sumOfSubArrays(listOf(),0) shouldBe listOf()
    }
    "list with one item should give list of one item" {
        sumOfSubArrays(listOf(4),1) shouldBe listOf(4)
    }
    "list [1,2] and k of 1 shoiuld give [1,2]" {
        sumOfSubArrays(listOf(1,2),1) shouldBe listOf(1,2)
    }
    "list [1,2] and k of 2 shoiuld give [2]" {
        sumOfSubArrays(listOf(1,2),2) shouldBe listOf(2)
    }
    "list [1,2,3] and k of 2 shoiuld give [2,3]" {
        sumOfSubArrays(listOf(1,2,3),2) shouldBe listOf(2,3)
    }
    "list [10, 5, 2, 7, 8, 7] and k = 3 should give [10, 7, 8, 8]" {
        sumOfSubArrays(listOf(10, 5, 2, 7, 8, 7), 3) shouldBe listOf(10, 7, 8, 8)
    }
})
