package october.october06

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    val data = """
            0 1 0
            1 0 1
            0 2 1
        """.trimIndent().split("\n")
    " ['0 1 0','1 0 1','0 2 1'] is converted to 2 X 2 terrain " {
        val terrain = data.toTerrain()
        terrain shouldBe listOf(
        Position(0,1),
        Position(1,0),
        Position(1,2),
        Position(2,1),
        Position(2,2))
    }
    "positions adjacent to (0,0) are (0,1),(1,1),(1,0)" {
        Position(0,0).adjacent(2,2) shouldBe setOf(Position(0,1),Position(1,1),Position(1,0))
    }
    "positions adjacent to (1,1) are (0,0),(0,1),(0,2),(1,0),(1,2),(2,0),(2,1),(2,2)," {
        Position(1,1).adjacent(2,2) shouldBe setOf(
            Position(0,0),Position(0,1),Position(0,2),
            Position(1,0),                        Position(1,2),
            Position(2,0),Position(2,1),Position(2,2),
            )
    }
    val data2 = """
        1 0 0 0 0
        0 0 1 1 0
        0 1 1 0 0
        0 0 0 0 0
        1 1 0 0 1
        1 1 0 0 1
    """.trimIndent().split("\n")
    "island in data 2 at position (1,2) occupies (1,2),(1,3),(2,1),(2,2)" {
        data2.toTerrain().islandPositions(Position(1,2)) shouldBe setOf(
            Position(1,2),
            Position(1,3),
            Position(2,1),
            Position(2,2))
    }
    "island in data 2 at position (4,0) occupies (4,0),(4,1),(5,0),(5,1)" {
        data2.toTerrain().islandPositions(Position(4,0)) shouldBe setOf(
            Position(4,0),
            Position(4,1),
            Position(5,0),
            Position(5,1))
    }
    "position (2,1) is in sets({(1,2),(1,3),(2,1),(2,2)}, {(4,0),(4,1),(5,0),(5,1)})" {
        listOf(
            setOf(Position(4,0), Position(4,1), Position(5,0), Position(5,1)),
            setOf(Position(1,2), Position(1,3), Position(2,1), Position(2,2))
        ).contains(Position(2,1)) shouldBe true
    }
    "position (2,3) is not in sets({(1,2),(1,3),(2,1),(2,2)}, {(4,0),(4,1),(5,0),(5,1)})" {
        listOf(
            setOf(Position(4,0), Position(4,1), Position(5,0), Position(5,1)),
            setOf(Position(1,2), Position(1,3), Position(2,1), Position(2,2))
        ).contains(Position(2,3)) shouldBe false
    }
    "data 2 contains 4 islands" {
        problem(data2).size shouldBe 4
    }
})