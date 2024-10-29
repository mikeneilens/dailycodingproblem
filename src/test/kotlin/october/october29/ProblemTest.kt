package october.october29

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    "ways to hop until end of [2,0,1,0] are [[0,2,1]]" {
        listOf(2,0,1,0).hopUntilEnd() shouldBe listOf(listOf(0,2,1))
    }
    "ways to hop until end of [1,1,0,1] are []" {
        listOf(1,1,0,1).hopUntilEnd() shouldBe listOf()
    }
    "ways to hop until end of [4,0,1,0] are [[0,2,1],[0,3]] as valid first hop is 2 or 3" {
        listOf(4,0,1,0).hopUntilEnd() shouldBe listOf(listOf(0,2,1), listOf(0,3))
    }
    "[2,0,1,0] can reach the end" {
        problem(listOf(2,0,1,0)) shouldBe true
    }
    "[1,1,0,1] cannot reach the end" {
        problem(listOf(1,1,0,1)) shouldBe false
    }
})