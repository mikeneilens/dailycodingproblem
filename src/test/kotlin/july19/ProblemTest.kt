package july19

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec ({
    "input [] should give 1"{
        val input = listOf(3,4,-1,1)
        input.firstMissingPositiveInteger() shouldBe 2
    }
    "input [3, 4, -1, 1] should give 2"{
        val input = listOf(3,4,-1,1)
        input.firstMissingPositiveInteger() shouldBe 2
    }
    "input [1, 2, 0] should give 3"{
        val input = listOf(1,2,0)
        input.firstMissingPositiveInteger() shouldBe 3
    }
    "input [1, 2, 3, 4, 6, 2] should give 5"{
        val input = listOf(1,2,3,4,6,2)
        input.firstMissingPositiveInteger() shouldBe 5
    }
})

