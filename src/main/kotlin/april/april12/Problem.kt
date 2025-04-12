package april.april12

import kotlin.math.abs

//You are presented with an 8 by 8 matrix representing the positions of pieces on a chess board. The only pieces on the board are the black king and various white pieces. Given this matrix, determine whether the king is in check.
//
//For details on how each piece moves, see here.
//
//For example, given the following matrix:
//
//...K....
//........
//.B......
//......P.
//.......R
//..N.....
//........
//.....Q..
//You should return True, since the bishop is attacking the king diagonally.

data class Piece (val type:Char, val row:Int, val col:Int)

fun problem(board: List<String>):Boolean {
    val pieces = parse(board)
    val king = pieces.first{it.type == 'K'}
    return pieces.filter{it != king}.any{piece ->
        val canCheck = pieceCanCheckFunctions.getValue(piece.type)
        canCheck(king, piece, pieces)
    }
}

fun parse(rows:List<String>) =
    rows.flatMapIndexed {
        row, line -> line.mapIndexed{col, char -> Piece(char, row, col)}
    }.filter{it.type != '.'}

fun Piece.isOnSameDiagonal(other:Piece, allPieces:List<Piece>) =
    abs(row - other.row) == abs(col - other.col) && pieceInBetween(this, other, allPieces).isEmpty()

fun Piece.isOnSameRowOrCol(other: Piece, allPieces: List<Piece>) = isOnSameRow(other, allPieces) || isOnSameCol(other, allPieces)

fun Piece.isOnSameRowOrColOrDiagonal(other: Piece, allPieces: List<Piece>) = isOnSameRowOrCol(other, allPieces) || isOnSameDiagonal(other, allPieces)

fun Piece.isOnSameRow(other:Piece, allPieces:List<Piece>) =
    row == other.row && pieceInBetween(this, other, allPieces).isEmpty()

fun Piece.isOnSameCol(other:Piece, allPieces:List<Piece>) =
    col == other.col && pieceInBetween(this, other, allPieces).isEmpty()

fun pieceInBetween(piece1:Piece, piece2:Piece,otherPieces:List<Piece> ) =
    (minOf(piece1.row, piece2.row)..maxOf(piece1.row, piece2.row))
        .flatMap{ row ->
            (minOf(piece1.col, piece2.col)..maxOf(piece1.col, piece2.col)).mapNotNull { col ->
                otherPieces.firstOrNull{ it.col == col && it.row == row && it != piece1 && it != piece2} }
            }

fun Piece.isOneRowAwayOnSameDiagonal(other: Piece, allPieces: List<Piece>) = (other.row - row == 1) && abs(other.col - col) == 1

fun Piece.isOneRowAwayAndTwoColsAwayOrOneColAwayAndTwoRowsAway(other:Piece, allPieces: List<Piece>) =
    (abs(other.col - col) == 1 && abs(other.row - row) == 2) ||
            (abs(other.col - col) == 2 && abs(other.row - row) == 1)

val pieceCanCheckFunctions = mapOf(
    'B' to Piece::isOnSameDiagonal,
    'R' to Piece::isOnSameRowOrCol,
    'Q' to Piece::isOnSameRowOrColOrDiagonal,
    'P' to Piece::isOneRowAwayOnSameDiagonal,
    'N' to Piece::isOneRowAwayAndTwoColsAwayOrOneColAwayAndTwoRowsAway
)

