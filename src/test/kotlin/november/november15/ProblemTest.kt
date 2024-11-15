package november.november15

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    val matrix = """
        0 3 1 1
        2 0 0 4
        1 5 3 1
    """.trimIndent().split("\n")
    "map matrix data into a Matrix type" {
        matrix.toMatrix() shouldBe mapOf(
            Position(0,0) to 0, Position(1,0) to 3, Position(2,0) to 1, Position(3,0) to 1,
            Position(0,1) to 2, Position(1,1) to 0, Position(2,1) to 0, Position(3,1) to 4,
            Position(0,2) to 1, Position(1,2) to 5, Position(2,2) to 3, Position(3,2) to 1,
        )
    }
    "find most expensive route" {
        problem(matrix, Matrix::isHigher) shouldBe 12
    }
    "find least expensive route" {
        problem(matrix, Matrix::isLower) shouldBe 6
    }
})