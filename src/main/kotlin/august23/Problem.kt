package august23

data class Position(val row:Int, val col:Int)

data class Queen(val position:Position, val boardRange:IntRange) {
    val horizontalSquares get() = boardRange.map { Position(position.row, it) }
    val verticalSquares get() = boardRange.map { Position(it, position.col) }
    val rightDiagnal get() = boardRange.flatMap{ listOf(Position(position.row + it , position.col + it),Position(position.row - it , position.col - it)) }
        .filter{it.col in boardRange && it.row in boardRange}
    val leftDiagnal get() = boardRange.flatMap{ listOf(Position(position.row - it , position.col + it),Position(position.row + it , position.col - it)) }
        .filter{it.col in boardRange && it.row in boardRange}
    val occupiedSquares = (horizontalSquares + verticalSquares + rightDiagnal + leftDiagnal).toSet()
}

fun possiblePositions(board:List<Queen>, boardPositions:Set<Position>):Set<Position> {
    val occupiedSquares:Set<Position> =  board.occupiedSquares()
    return boardPositions - occupiedSquares
}

fun List<Queen>.occupiedSquares() = fold(setOf<Position>()){ result, queen -> result + queen.occupiedSquares}

data class BoardStatus(val boardPositions:Set<Position>, var bestFound:List<Queen> = listOf(), val bestPossible:Int = boardPositions.distinctBy {it.row}.size) {
    fun solutionFound() = bestFound.size == bestPossible
}

fun addQueen(board:List<Queen>, boardStatus:BoardStatus, boardRange:IntRange ):List<List<Queen>> {
    val possiblePositions = if (!boardStatus.solutionFound()) possiblePositions(board, boardStatus.boardPositions) else listOf()
    if (possiblePositions.isEmpty()) {
        if (board.size > boardStatus.bestFound.size) boardStatus.bestFound = board
        return listOf(board)
    }
    else return possiblePositions.flatMap{position -> addQueen(board + Queen(position, boardRange), boardStatus, boardRange)}
}