package august.august17

import august.august17.median
import august.august17.middleRange
import august.august17.problem
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    "middle range of a list of length 1 is [0]" {
        listOf(1).middleRange() shouldBe listOf(0)
    }
    "middle range of a list of length 2 is [0, 1]" {
        listOf(1,2).middleRange() shouldBe listOf(0, 1)
    }
    "middle range of a list of length 3 is [1]" {
        listOf(1,2,3).middleRange() shouldBe listOf(1)
    }
    "middle range of a list of length 4 is [1..2]" {
        listOf(1,2,3,4).middleRange() shouldBe listOf(1, 2)
    }
    "median of [2] is 2" {
        listOf(2).median() shouldBe 2
    }
    "median of [1, 2] is 1.5" {
        listOf(1, 2).median() shouldBe 1.5
    }
    "median of [1, 2, 5] is 2" {
        listOf(1, 2, 5).median() shouldBe 2
    }
    "with [2] the problem returns [2]" {
        problem(listOf(2)) shouldBe listOf(2)
    }
    "with [2, 1] the problem returns [2, 1.5]" {
        problem(listOf(2, 1)) shouldBe listOf(2, 1.5)
    }
    "with [2, 1, 5, 7, 2, 0, 5] the problem returns [2, 1.5, 2, 3.5, 2, 2, 2]" {
        problem(listOf(2, 1, 5, 7, 2, 0, 5)) shouldBe listOf(2, 1.5, 2, 3.5, 2, 2, 2)
    }
})