package august.august31

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec( {
    "When array is [] maximum profit is zero" {
        problem(emptyList()) shouldBe 0
    }
    "When array contains one item profit is zero" {
        problem(listOf(1)) shouldBe 0
    }
    "When array contains [2, 1] profit is zero" {
        problem(listOf(2, 1)) shouldBe 0
    }
    "When array contains [1, 2] profit is 1" {
        problem(listOf(1, 2)) shouldBe 1
    }
    "When array contains [1, 2, 3] profit is 2" {
        problem(listOf(1, 2, 3)) shouldBe 2
    }
    "When array contains [2, 1, 3] profit is 2" {
        problem(listOf(2, 1, 3)) shouldBe 2
    }
    "When array contains [9, 11, 8, 5, 7, 10] profit is 5" {
        problem(listOf(9, 11, 8, 5, 7, 10)) shouldBe 5
    }
    "When array contains [5, 11, 8, 5, 7, 10] profit is 6" {
        problem(listOf(5, 11, 8, 5, 7, 10)) shouldBe 6
    }
})