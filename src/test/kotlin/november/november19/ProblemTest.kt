package november.november19

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest:StringSpec ({
    "rotate [1,2,3,4,5,6] 1 left gives [2,3,4,5,6,1]" {
        listOf(1,2,3,4,5,6).rotateLeft(1) shouldBe listOf(2,3,4,5,6,1)
    }
    "rotate [1,2,3,4,5,6] 2 left gives [3,4,5,6,1,2]" {
        listOf(1,2,3,4,5,6).rotateLeft(2) shouldBe listOf(3,4,5,6,1,2)
    }
    "rotate [1,2,3,4,5,6] 0 left gives [1,2,3,4,5,6]" {
        listOf(1,2,3,4,5,6).rotateLeft(0) shouldBe listOf(1,2,3,4,5,6)
    }
    "rotate [1,2,3,4,5,6] 7 left gives [2,3,4,5,6,1]" {
        listOf(1,2,3,4,5,6).rotateLeft(7) shouldBe listOf(2,3,4,5,6,1)
    }

    "reverse substring 3,8 in [0,1,2,3,4,5,6,7,8,9,10] gives [0,1,2,8,7,6,5,4,3,9,10]" {
        mutableListOf(0,1,2,3,4,5,6,7,8,9,10).reverseSubString(3,8) shouldBe mutableListOf(0,1,2,8,7,6,5,4,3,9,10)
    }

    "rotate mutable [1,2,3,4,5,6] 1 left gives [2,3,4,5,6,1]" {
        mutableListOf(1,2,3,4,5,6).rotateLeft2(1) shouldBe listOf(2,3,4,5,6,1)
    }
    "rotate mutable [1,2,3,4,5,6] 2 left gives [3,4,5,6,1,2]" {
        mutableListOf(1,2,3,4,5,6).rotateLeft2(2) shouldBe listOf(3,4,5,6,1,2)
    }
    "rotate mutable [1,2,3,4,5,6] 0 left gives [1,2,3,4,5,6]" {
        mutableListOf(1,2,3,4,5,6).rotateLeft2(0) shouldBe listOf(1,2,3,4,5,6)
    }
    "rotate mutable [1,2,3,4,5,6] 7 left gives [2,3,4,5,6,1]" {
        mutableListOf(1,2,3,4,5,6).rotateLeft2(7) shouldBe listOf(2,3,4,5,6,1)
    }
})