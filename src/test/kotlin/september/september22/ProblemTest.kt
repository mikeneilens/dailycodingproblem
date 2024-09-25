package september.september22

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec( {
    " when all numbers are positive pick the highest three numbers" {
        problem(listOf(1,2,3,4,5,6).shuffled()) shouldBe listOf(4,5,6)
    }
    "[0] X [1] X [last] is higher than [last] X [last-1] X [last-2] pick two most negative and one most positive"{
        problem(listOf(-5,-4,-1,3,4).shuffled()) shouldBe listOf(-5,-4,4)
    }
    "[0] X [1] X [last] is less than [last] X [last-1] X [last-2] pick highest three numbers "{
        problem(listOf(-5,-4,5,6,7).shuffled()) shouldBe listOf(5,6,7)
    }
    "when all numbers are negative pick the highest three numbers"{
        problem(listOf(-5,-4,-3,-2,-1).shuffled()) shouldBe listOf(-3,-2,-1)
    }
    "when highest number is zero any two others plus zero is a valid result"{
        val result = problem(listOf(-5,-4,-3,-2,-1,0).shuffled())
        result.last() shouldBe 0
        (result[0] in listOf(-5,-4,-3,-2,-1,0)) shouldBe true
        (result[1] in listOf(-5,-4,-3,-2,-1,0)) shouldBe true
    }
})