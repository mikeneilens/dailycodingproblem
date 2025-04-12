package april.april12

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec( {
    val board = """
        ...K....
        ........
        .B......
        ......P.
        .......R
        ..N.....
        ........
        .....Q..
    """.trimIndent().split("\n")

    "king is the only piece on the board" {
        val board = """
            ...K....
        """.trimIndent().split("\n")
        val pieces = parse(board)
        pieces.size  shouldBe 1
        pieces[0] shouldBe Piece('K', 0 ,3)
    }
    "king and bishop are the pieces on the board" {
        val board = """
            ...K....
            ........
            .B......
        """.trimIndent().split("\n")
        val pieces = parse(board)
        pieces.size  shouldBe 2
        pieces[0] shouldBe Piece('K', 0 ,3)
        pieces[1] shouldBe Piece('B', 2 ,1)
    }
    "one piece is on the same diagonal as another with nothing else on the board" {
        val piece03 = Piece('K', 0, 3)
        val piece11 = Piece('B', 2, 1)
        val allPieces = listOf(piece03, piece11)
        piece03.isOnSameDiagonal(piece11, allPieces) shouldBe true
        val piece25 = Piece('B', 2, 5)
        piece03.isOnSameDiagonal(piece25, allPieces) shouldBe true
    }
    "no pieces in between two pieces" {
        val piece03 = Piece('K', 0, 3)
        val piece11 = Piece('B', 2, 1)
        val allPieces = listOf(Piece('P',4,4) ,piece03, piece11)
        pieceInBetween(piece11, piece03, allPieces) shouldBe emptyList()
    }
    "one piece in between two pieces" {
        val piece03 = Piece('K', 0, 3)
        val piece11 = Piece('B', 2, 1)
        val allPieces = listOf<Piece>(Piece('P',1,1), piece03, piece11)
        pieceInBetween(piece11, piece03, allPieces) shouldBe listOf(Piece('P',1,1))
    }
    "one piece is on the same diagonal as another with another piece in between them" {
        val piece03 = Piece('K', 0, 3)
        val piece11 = Piece('B', 2, 1)
        val allPieces = listOf<Piece>(Piece('P',1,2))
        piece03.isOnSameDiagonal(piece11, allPieces) shouldBe false
    }
    "two pieces are on the same row with no other pieces in between them" {
        val piece03 = Piece('K', 0, 3)
        val piece04 = Piece('B', 0, 4)
        val allPieces = listOf(piece03, piece04)
        piece03.isOnSameRow(piece04, allPieces) shouldBe true
    }
    "two pieces are on the same row with another piece in between them" {
        val piece03 = Piece('K', 0, 3)
        val piece06 = Piece('B', 0, 6)
        val piece05 = Piece('B', 0, 5)
        val allPieces = listOf(piece03, piece06, piece05)
        piece03.isOnSameRow(piece06, allPieces) shouldBe false
    }
    "two pieces are on the same col with no pieces in between them" {
        val piece30 = Piece('K', 3, 0)
        val piece60 = Piece('B', 6, 0)
        val allPieces = listOf(piece30, piece60)
        piece30.isOnSameCol(piece60, allPieces) shouldBe true
    }
    "two pieces are on the same col with another piece in between them" {
        val piece30 = Piece('K', 3, 0)
        val piece60 = Piece('B', 6, 0)
        val piece50 = Piece('B', 5, 0)
        val allPieces = listOf(piece30, piece60, piece50)
        piece30.isOnSameCol(piece60, allPieces) shouldBe false
    }
    "two pieces are on the same col or the same row" {
        val piece30 = Piece('K', 3, 0)
        val piece60 = Piece('B', 6, 0)
        val allPieces = listOf(piece30, piece60)
        piece30.isOnSameRowOrCol(piece60, allPieces) shouldBe true
        val piece03 = Piece('K', 0, 3)
        val piece06 = Piece('B', 0, 6)
        piece03.isOnSameRowOrCol(piece06, allPieces) shouldBe true
    }
    "piece is one row away on same diagonal" {
        val piece32 = Piece('K', 3, 2)
        val piece41 = Piece('P', 4, 1)
        piece32.isOneRowAwayOnSameDiagonal(piece41, listOf()) shouldBe true
        val piece43 = Piece('P', 4,3)
        piece32.isOneRowAwayOnSameDiagonal(piece43, listOf()) shouldBe true
    }
    "piece is one row away and two cols away or two rows away and one row away" {
        val piece32 = Piece('K', 3, 2)
        val piece41 = Piece('N', 4, 4)
        piece32.isOneRowAwayAndTwoColsAwayOrOneColAwayAndTwoRowsAway(piece41, listOf()) shouldBe true
        val piece53 = Piece('N', 5, 3)
        piece32.isOneRowAwayAndTwoColsAwayOrOneColAwayAndTwoRowsAway(piece53, listOf()) shouldBe true
    }
    "test using sample data" {
        problem(board) shouldBe true
    }
    "test using sample data with bishop removed" {
        val revisedBoard  = board.map{if (it == ".B......") "........" else it}
        problem(revisedBoard) shouldBe false
    }
})