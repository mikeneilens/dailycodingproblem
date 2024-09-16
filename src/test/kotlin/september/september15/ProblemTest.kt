package september.september15

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec( {
    "Number of routes for a 1 by 1 grid is 1 " {
        routes(Board(1,1)) shouldBe listOf(listOf(Position(1,1)))
    }
    "Number of routes for 2 by 2 grid is 2" {
        routes(Board(2,2)) shouldBe listOf(
            listOf(Position(1,1), Position(2,1), Position(2,2)),
            listOf(Position(1,1), Position(1,2), Position(2,2))
            )
    }
    "Number of routes for 3 by 2 grid is 3" {
        routes(Board(3,2)) shouldBe listOf(
            listOf(Position(row=1, col=1), Position(row=2, col=1), Position(row=3, col=1), Position(row=3, col=2)),
            listOf(Position(row=1, col=1), Position(row=2, col=1), Position(row=2, col=2), Position(row=3, col=2)),
            listOf(Position(row=1, col=1), Position(row=1, col=2), Position(row=2, col=2), Position(row=3, col=2)))
    }
    "Number of routes for 5 by 5 grid is 70" {
        routes(Board(5,5)).size shouldBe 70
    }
})