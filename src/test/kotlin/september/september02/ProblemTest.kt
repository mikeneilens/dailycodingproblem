package september.september02

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({

    "when 3 is greater than max so far, max so far becomes 3" {
        Result(2,0).nextResult(3) shouldBe Result(3,3)
    }
    "when max to here is less than zero ,max to here becomes zero" {
        Result(2,0).nextResult(-1) shouldBe Result(2,0)
    }
    "when max to here is greater than zero and less than max so far result is updated with max so far" {
        Result(5,0).nextResult(2) shouldBe Result(5,2)
    }

    "with [] the result is 0" {
        problem(listOf()) shouldBe 0
    }
    "with [1] the result is 1" {
        problem(listOf(1)) shouldBe 1
    }
    "with [1,2] the result is 3" {
        problem(listOf(1,2)) shouldBe 3
    }
    "with [34, -50, 42, 14, -5, 86] the result is 137" {
        problem(listOf(34, -50, 42, 14, -5, 86)) shouldBe 137
    }
    "with [-5, -1, -8, -9] the result is 0" {
        problem(listOf(-5, -1, -8, -9)) shouldBe 0
    }
})