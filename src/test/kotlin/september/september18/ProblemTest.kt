package september.september18

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    "A 1 X 1 matrix should return a list containing 1 item" {
        listOf(
            listOf(1)
        ).clockwiseSpiral() shouldBe listOf(1)
    }
    "A 1 X 2 matrix should return a list containing 2 items" {
        listOf(
            listOf(1, 2)
        ).clockwiseSpiral() shouldBe listOf(1, 2)
    }
    "A 2 X 1 matrix should return a list containing 2 items" {
        listOf(
            listOf(1),
            listOf(2)
        ).clockwiseSpiral() shouldBe listOf(1, 2)
    }
    "A 2 X 2 matrix should return a list containing 4 items" {
        listOf(
            listOf(1, 2),
            listOf(3, 4)
        ).clockwiseSpiral() shouldBe listOf(1, 2, 4, 3)
    }
    "In a 3 X 2 matrix starting at 0,0 the first horizontal row is [1,2]" {
        listOf(
            listOf(1, 2),
            listOf(3, 4),
            listOf(5, 6),
        ).firstHorizontal() shouldBe listOf(1,2)
    }
    "In a 3 X 2 matrix starting at 0,0 the first vertical row is [4,6]" {
        listOf(
            listOf(1, 2),
            listOf(3, 4),
            listOf(5, 6),
        ).firstVertical() shouldBe listOf(4,6)
    }
    "In a 3 X 2 matrix starting at 0,0 the second horizontal row is [5]" {
        listOf(
            listOf(1, 2),
            listOf(3, 4),
            listOf(5, 6),
        ).secondHorizontal() shouldBe listOf(5)
    }
    "In a 3 X 2 matrix starting at 0,0 the second vertical row is [3]" {
        listOf(
            listOf(1, 2),
            listOf(3, 4),
            listOf(5, 6),
        ).secondVertical() shouldBe listOf(3)
    }
    "A 3 X 3 matrix should return a list containing 6 items" {
        listOf(
            listOf(1, 2),
            listOf(3, 4),
            listOf(5, 6),
        ).clockwiseSpiral() shouldBe listOf(1, 2, 4, 6, 5, 3)
    }

    "Removing the border of a 5 X 5 matrix leaves a 3 X 3 matrix" {
        listOf(
            listOf(1, 2, 3, 4, 5),
            listOf(6, 7, 8, 9, 10),
            listOf(11, 12, 13, 14, 15),
            listOf(16, 17, 18, 19, 20),
        ).removeBorder() shouldBe listOf(listOf(7,8,9),listOf(12,13,14))
    }

    "A 4 X 4 matrix should return a list containing 16 items" {
        listOf(
            listOf(1, 2, 3, 4),
            listOf(5, 6, 7, 8),
            listOf(9, 10, 11, 12),
            listOf(13, 14, 15, 16),
        ).clockwiseSpiral() shouldBe listOf(1, 2, 3, 4, 8, 12, 16, 15, 14 ,13, 9, 5, 6, 7, 11, 10)
    }
})