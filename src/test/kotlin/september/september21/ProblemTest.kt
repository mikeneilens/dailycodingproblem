package september.september21

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    "check diagonals on a 4X4 board are calculated" {
        diagnols(4) shouldBe setOf(
            setOf(Square(1,1),Square(2,2),Square(3,3),Square(4,4)),
            setOf(Square(1,2),Square(2,3),Square(3,4)),
            setOf(Square(1,3),Square(2,4)),
            setOf(Square(2,1),Square(3,2),Square(4,3)),
            setOf(Square(3,1),Square(4,2)),
            setOf(Square(4,1),Square(3,2),Square(2,3),Square(1,4)),
            setOf(Square(1,3),Square(2,2),Square(3,1)),
            setOf(Square(1,2),Square(2,1)),
            setOf(Square(2,4),Square(3,3),Square(4,2)),
            setOf(Square(3,4),Square(4,3))
        )
    }
    "check diagonals on a 5X5 board are calculated" {
        diagnols(5).size shouldBe 14
    }

    "for bishops (1,1), (2,3), (3,3), (5,1) on a 5 X 5 board there are two diagonals with one collision each" {
        val bishops = setOf(
            Square(1,1),
            Square(2,3),
            Square(3,3),
            Square(5,1))
        problem(5, bishops) shouldBe listOf(1,1)
    }

    "for bishops (1,1), (2,3), (3,3), (5,1), (5,5) on a 5 X 5 board there are two diagonals with one collision each" {
        val bishops = setOf(
            Square(1,1),
            Square(2,3),
            Square(3,3),
            Square(5,1),
            Square(5,5))
        problem(5, bishops) shouldBe listOf(3,1)
    }
})