package november.november29

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    val testData = listOf(
        listOf(1,0,0,0),
        listOf(1,0,1,1),
        listOf(1,0,1,1),
        listOf(0,1,0,0)
    )
    "width starting at col 2 of [[0,0,1,1,1,0]]is 3 " {
        listOf(listOf(0,0,1,1,1,0,0)).width(0,2) shouldBe 3
    }
    "width starting at col 2 of [[0,0,0,1,1,0]]is 0 " {
        listOf(listOf(0,0,0,1,1,0,0)).width(0,2) shouldBe 0
    }
    "depth starting at row 1 of [[0,0,0],[1,0,0],[1,0,0],[0,0,0] is 2]" {
        listOf(listOf(0,0,0),listOf(1,0,0),listOf(1,0,0),listOf(0,0,0)).depth(1,0) shouldBe 2
    }
    "depth starting at row 3 of [[0,0,0],[1,0,0],[1,0,0],[0,0,0] is 0]" {
        listOf(listOf(0,0,0),listOf(1,0,0),listOf(1,0,0),listOf(0,0,0)).depth(3,0) shouldBe 0
    }
    " at row 1..3 and col 1..2 [[0,0,0,0],[0,1,1,0],[0,1,1,0],[0,1,1,0],[0,0,0,0]] should contain only 1s" {
        listOf(
            listOf(0,0,0,0),
            listOf(0,1,1,0),
            listOf(0,1,1,0),
            listOf(0,1,1,0),
            listOf(0,0,0,0),
        ).containsOnlyOnes(1..3, 1..2) shouldBe true
    }
    " at row 1..4 and col 1..2 [[0,0,0,0],[0,1,1,0],[0,1,1,0],[0,1,1,0],[0,0,0,0]] should not contain only 1s" {
        listOf(
            listOf(0,0,0,0),
            listOf(0,1,1,0),
            listOf(0,1,1,0),
            listOf(0,1,1,0),
            listOf(0,0,0,0),
        ).containsOnlyOnes(1..4, 1..2) shouldBe false
    }
    " at row 1..3 and col 1..1 [[0,0,0,0],[0,1,1,0],[0,1,1,0],[0,1,1,0],[0,0,0,0]] should contain only 1s" {
        listOf(
            listOf(0,0,0,0),
            listOf(0,1,1,0),
            listOf(0,1,1,0),
            listOf(0,1,1,0),
            listOf(0,0,0,0),
        ).containsOnlyOnes(1..3, 1..1) shouldBe true
    }
    " at row 1..3 and col 2..2 [[0,0,0,0],[0,1,1,0],[0,1,1,0],[0,1,1,0],[0,0,0,0]] should contain only 1s" {
        listOf(
            listOf(0,0,0,0),
            listOf(0,1,1,0),
            listOf(0,1,1,0),
            listOf(0,1,1,0),
            listOf(0,0,0,0),
        ).containsOnlyOnes(1..3, 2..2) shouldBe true
    }
    "with test data, max grid at 0,0 is (0..2, 0..0)" {
        testData.maxAt(0,0) shouldBe Pair(0..2, 0..0)
    }
    "with test data, max grid at 1,2 is (1..2, 2..3)" {
        testData.maxAt(1,2) shouldBe Pair(1..2, 2..3)
    }
    "with the test matrix the max is (1..2, 2..3)" {
        problem(testData) shouldBe Pair(1..2, 2..3)
    }
    "with [[0,0,0,0],[0,1,1,0],[0,1,1,0],[0,1,1,0],[0,0,0,0]] the max is (1..3,1..2)" {
        val matrix = listOf(
            listOf(0,0,0,0),
            listOf(0,1,1,0),
            listOf(0,1,1,0),
            listOf(0,1,1,0),
            listOf(0,0,0,0),
        )
        problem(matrix) shouldBe Pair(1..3, 1..2)
    }
})