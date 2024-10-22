package october.october21

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    val board = listOf(
        listOf('A','B','C','E'),
        listOf('S','F','C','S'),
        listOf('A','D','E','E')
    )
    "at position 0,0 and target B the option is position 0,1" {
        Position(0,0).possibleMove(board,'B') shouldBe listOf(Position(0,1))
    }
    "at position 1,3 and target E the option is position 0,3 and position 2,3" {
        Position(1,3).possibleMove(board,'E') shouldBe listOf(Position(0,3),Position(2,3))
    }
    "at position 1,3 and target C the option is position 1,2" {
        Position(1,3).possibleMove(board,'C') shouldBe listOf(Position(1,2))
    }
    "find positions of S in the grid should give position 1,0, position 1,3" {
        board.findPositions('S') shouldBe listOf(Position(1,0), Position(1,3))
    }
    "find word SEE in the grid starting at position 1,3" {
        board.findWord("EE",listOf(Position(1,3)))
            .first().map{board[it]}.joinToString("") shouldBe "SEE"
    }
    "ABCCED is found in the grid" {
        exists(board, "ABCCED") shouldBe true
    }
    "SEE is found in the grid" {
        exists(board, "SEE") shouldBe true
    }
    "ABCB is not found in the grid" {
        exists(board, "ABCB") shouldBe false
    }
})