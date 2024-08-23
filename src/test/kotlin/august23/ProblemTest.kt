package august23

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe

class ProblemTest: WordSpec( {
    "with a queen" should {
        "horizontal spaces occupied by queen on row 4, col 3 are all on row 4" {
            Queen(Position(4,3), (1..8)).horizontalSquares shouldBe listOf(
                Position(4, 1),Position(4, 2),Position(4, 3),Position(4, 4),
                Position(4, 5),Position(4, 6),Position(4, 7),Position(4, 8),
            )
        }
        "vertical spaces occupied by queen on row 4, col 3 are all on col 3" {
            Queen(Position(4,3), (1..8)).verticalSquares shouldBe listOf(
                Position(1, 3),Position(2, 3),Position(3, 3),Position(4, 3),
                Position(5, 3),Position(6, 3),Position(7, 3),Position(8, 3),
            )
        }
        "right diagonal spaces occupied by queen on row 4, col 3 are all on the same diagonal" {
            Queen(Position(4,3), (1..8)).rightDiagnal shouldBe listOf(
                Position(row=5, col=4), Position(row=3, col=2), Position(row=6, col=5), Position(row=2, col=1), Position(row=7, col=6), Position(row=8, col=7),
            )
        }
        "left diagonal spaces occupied by queen on row 4, col 3 are all on the same diagonal" {
            Queen(Position(4,3), (1..8)).leftDiagnal shouldBe listOf(
                Position(row=3, col=4), Position(row=5, col=2), Position(row=2, col=5), Position(row=6, col=1), Position(row=1, col=6),
            )
        }
    }
    "when placing a queen on a board containing queens" should {
        "when a board contains one queen at position (1,1) with a board size of 2 there are no possible positions to place a queen" {
            val boardRange = 1..2
            val boardPositions:Set<Position> = boardRange.flatMap { row -> boardRange.map{col -> Position(row, col) } }.toSet()
            val queen = Queen(Position(1,1), boardRange)
            possiblePositions(listOf(queen), boardPositions) shouldBe setOf()
        }
        "when a board contains one queen at position (1,1) with a board size of 3 there are two possible positions to place a queen" {
            val boardRange = 1..3
            val boardPositions:Set<Position> = boardRange.flatMap { row -> boardRange.map{col -> Position(row, col) } }.toSet()
            val queen = Queen(Position(1,1), boardRange)
            possiblePositions(listOf(queen), boardPositions) shouldBe setOf(Position(2,3), Position(3,2))
        }
        "when a board cotains one queen at position (1,1) with a board size of 3 there are two possible ways to add queens" {
            val boardRange = 1..3
            val boardPositions:Set<Position> = boardRange.flatMap { row -> boardRange.map{col -> Position(row, col) } }.toSet()
            val queen = Queen(Position(1,1), boardRange)
            addQueen(listOf(queen), BoardStatus(boardPositions), boardRange) shouldBe listOf(
                listOf(Queen(position=Position(row=1, col=1), boardRange=1..3), Queen(position=Position(row=2, col=3), boardRange=1..3)),
                listOf(Queen(position=Position(row=1, col=1), boardRange=1..3), Queen(position=Position(row=3, col=2), boardRange=1..3))
            )
        }
        "when a board cotains one queen at position (1,1) with a board size of 8 there are many possible ways to add queens and the max is 8" {
            val boardRange = 1..8
            val boardPositions:Set<Position> = boardRange.flatMap { row -> boardRange.map{col -> Position(row, col) } }.toSet()
            val queen = Queen(Position(1,1), boardRange)
            val result = addQueen(listOf(queen), BoardStatus(boardPositions), boardRange)
            result.maxOf{it.size} shouldBe 8
            result.first { it.size == 8 } shouldBe listOf(
                Queen(position=Position(row=1, col=1), boardRange=1..8),
                Queen(position=Position(row=2, col=5), boardRange=1..8),
                Queen(position=Position(row=3, col=8), boardRange=1..8),
                Queen(position=Position(row=4, col=6), boardRange=1..8),
                Queen(position=Position(row=5, col=3), boardRange=1..8),
                Queen(position=Position(row=6, col=7), boardRange=1..8),
                Queen(position=Position(row=7, col=2), boardRange=1..8),
                Queen(position=Position(row=8, col=4), boardRange=1..8))
        }
        "max queens added to a board of size 3 is 2" {
            problem(1..3) shouldBe 2
        }
        "max queens added to a board of size 5 is 2" {
            problem(1..5) shouldBe 5
        }
        "max queens added to a board of size 8 is 8" {
            problem(1..8) shouldBe 8
        }
        "max queens added to a board of size 10 is 10" {
            problem(1..10) shouldBe 10
        }

    }

})