package october.october18

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec( {
    "With an array [1,2,3,4], the position of the last ascending digit is 2" {
        listOf(1,2,3,4).positionOfLastAscending() shouldBe 2
    }
    "With an array [4,3,2,1], the position of the last ascending digit is null" {
        listOf(4,3,2,1).positionOfLastAscending() shouldBe null
    }
    "With an array [1,2,3,4], the position of the last digit greater then [2] is 3" {
        listOf(1,2,3,4).positionOfLastDigitGreaterThan(2) shouldBe 3
    }
    "With an array [1,3,4,2], reversing the digits after position 1 gives [1,3,2,4] " {
        listOf(1,3,4,2).reverseDigitsAfter(1) shouldBe listOf(1,3,2,4)
    }
    "With an array [1,2,3,4] swap numbers at positions 2,3" {
        listOf(1,2,3,4).swap(2,3) shouldBe listOf(1,2,4,3)
    }
    "With array [1,2,3,4] the solution should be [1,2,4,3]" {
        problem(listOf(1,2,3,4)) shouldBe listOf(1,2,4,3)
    }
    "With array [1,2,4,3] the solution should be [1,3,2,4]" {
        problem(listOf(1,2,4,3)) shouldBe listOf(1,3,2,4)
    }
    "With array [4,3,2,1] the solution should be [1,2,3,4]" {
        problem(listOf(4,3,2,1)) shouldBe listOf(1,2,3,4)
    }
})