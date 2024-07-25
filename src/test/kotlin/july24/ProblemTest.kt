package july24

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    "with max index of 1, list of lists is [0],[1]" {
        createLists(maxIndex = 1) shouldBe listOf(listOf(0),listOf(1))
    }
    "with max index of 2, list of lists is [0,2],[1]" {
        createLists(maxIndex = 2) shouldBe listOf(listOf(0,2),listOf(1))
    }
    "with max index of 3, list of lists is [0,2],[0,3],[1,3]" {
        createLists(maxIndex = 3) shouldBe listOf(listOf(0,2),listOf(0,3),listOf(1,3))
    }
    "with max index of 4, list of lists is [0,2,4],[0,3],[1,3],[1,4]" {
        createLists(maxIndex = 4) shouldBe listOf(listOf(0,2,4),listOf(0,3),listOf(1,3),listOf(1,4))
    }
    "with max index of 5, list of lists is [0,2,4],[0,2,5],[0,3,5],[1,3,5],[1,4]" {
        createLists(maxIndex = 5) shouldBe listOf(listOf(0,2,4),listOf(0,2,5),listOf(0,3,5),listOf(1,3,5),listOf(1,4))
    }
    "with max index of 6, list of lists is [0,2,4,6],[0,2,5],[0,3,5],[0,3,6],[1,3,5],[1,3,6],[1,4,6]" {
        createLists(maxIndex = 6) shouldBe listOf(
            listOf(0,2,4,6),
            listOf(0,2,5),
            listOf(0,3,5),
            listOf(0,3,6),
            listOf(1,3,5),
            listOf(1,3,6),
            listOf(1,4,6))
    }
    "with max index of 7, list of lists is [0,2,4,6],[0,2,4,7],[0,2,5,7],[0,3,5,7],[0,3,6],[1,3,5,7],[1,3,6],[1,4,6],[1,4,7]" {
        createLists(maxIndex = 7) shouldBe listOf(
            listOf(0,2,4,6),
            listOf(0,2,4,7),
            listOf(0,2,5,7),
            listOf(0,3,5,7),
            listOf(0,3,6),
            listOf(1,3,5,7),
            listOf(1,3,6),
            listOf(1,4,6),
            listOf(1,4,7))
    }

    "[2, 4, 6, 2, 5] should return 13" {
        largestSumOfNonAdjacentNumbers(listOf(2, 4, 6, 2, 5)) shouldBe 13
    }
    "[5, 1, 1, 5] should return 10" {
        largestSumOfNonAdjacentNumbers(listOf(5, 1, 1, 5)) shouldBe 10
    }
})