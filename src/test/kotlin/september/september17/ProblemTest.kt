package september.september17

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec( {
    "number of journeys for 1 X 1 board is one" {
        routes(Board(1)).size shouldBe 1
    }
    "number of journeys for 2 X 2 board is none" {
        routes(Board(2)).size shouldBe 0
    }
    "number of journeys for 3 X 3 board is none" {
        routes(Board(3)).size shouldBe 0
    }
    "number of journeys for 4 X 4 board is none" {
        routes(Board(4)).size shouldBe 0
    }
    "number of journeys for 5 X 5 board is 304" {
        routes(Board(5)).size shouldBe 304
    }

})