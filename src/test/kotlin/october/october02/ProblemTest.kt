package october.october02

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec( {
    "[1] returns true" {
        problem(listOf(1)) shouldBe true
    }
    "[1,1] returns true" {
        problem(listOf(1,1)) shouldBe true
    }
    "[1,1,1] returns true" {
        problem(listOf(1,1,1)) shouldBe true
    }
    "[1,2,3] returns true" {
        problem(listOf(1,2,3)) shouldBe true
    }
    "[1,4,3] returns true" {
        problem(listOf(1,4,3)) shouldBe true
    }
    "[1,4,3,2] returns false" {
        problem(listOf(1,4,3,2)) shouldBe false
    }
    "[10,5,7] returns true" {
        problem(listOf(10,5,7)) shouldBe true
    }
    "[10,5,1] returns false" {
        problem(listOf(10,5,1)) shouldBe false
    }
    "[1,10,10,5,7] returns false" {
        problem(listOf(1,10,10,5,7)) shouldBe false
    }
})