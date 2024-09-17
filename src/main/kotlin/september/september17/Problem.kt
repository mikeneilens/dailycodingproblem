package september.september17

//A knight's tour is a sequence of moves by a knight on a chessboard such that all squares are visited once.
//
//Given N, write a function to return the number of knight's tours on an N by N chessboard.

data class Board(val n:Int) {
    val startPosition = Position(1,1)
    val size = n * n
    operator fun contains(position: Position) = position.row in 1..n && position.col in 1..n
}

data class Position(val row:Int, val col:Int) {
    fun newPositions(board: Board) = listOf(
        Position(row + 2, col - 1), Position(row + 2, col + 1),
        Position(row - 2, col - 1), Position(row - 2, col + 1),
        Position(row + 1, col + 2), Position(row - 1, col + 2),
        Position(row + 1, col - 2), Position(row - 1, col - 2)).filter{it in board}
}

//simple depth first search
var x = 0
fun routes(board:Board, route:Set<Position> = setOf(board.startPosition), last:Position = board.startPosition): List<List<Position>> =
    if (route.size == board.size){
        println("route found ${++x}")
        listOf(route.toList())
    } else route.last().newPositions(board)
        .filter {newPosition -> newPosition !in route }
        .flatMap {newPosition -> routes(  board, route + newPosition, newPosition) }
