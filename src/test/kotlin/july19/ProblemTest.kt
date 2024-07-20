package july19

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec ({
    "when index = 0 and element = 1 then index should match element" {
        indexDoesNotMatchElement( IndexedValue(index= 0, value = 1)) shouldBe false
    }
    "when index = 1 and element = 1 then index should not match element" {
        indexDoesNotMatchElement(IndexedValue(index = 1, value = 1)) shouldBe true
    }
    "when index = 1 and element = 0 then index should not match element" {
        indexDoesNotMatchElement(IndexedValue(index = 1, value = 0)) shouldBe true
    }

    "input [3, 4, -1, 1] should give 2"{
        val input = listOf(3,4,-1,1)
        input.firstMissingPositiveInteger() shouldBe 2
    }
    "input [1, 2, 0] should give 3"{
        val input = listOf(1,2,0)
        input.firstMissingPositiveInteger() shouldBe 3
    }
})

