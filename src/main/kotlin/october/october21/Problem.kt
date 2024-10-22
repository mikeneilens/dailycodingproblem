package october.october21

//Given a 2D board of characters and a word, find if the word exists in the grid.
//
//The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally
// or vertically neighboring. The same letter cell may not be used more than once.
//
//For example, given the following board:
//
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//exists(board, "ABCCED") returns true, exists(board, "SEE") returns true, exists(board, "ABCB") returns false.

fun exists(board:Board, word:String)  =
    board.findPositions(word.first())
        .flatMap{ startPosition -> board.findWord(word.drop(1), listOf(startPosition))}
        .isNotEmpty()

typealias Board = List<List<Char>>

operator fun Board.get(position:Position ) = this[position.row][position.col]
val Board.rowRange get() = 0..lastIndex
val Board.colRange get() = 0..first().lastIndex

fun Board.findPositions(target:Char) =
    (0..lastIndex).flatMap { row -> (0..first().lastIndex).map{col -> Position(row, col)}}
        .filter{this[it] == target}

fun Board.findWord(word:String, visited:List<Position>):List<List<Position>> =
    if (word.isEmpty()) listOf(visited)
    else
        visited.last()
            .possibleMove(this, word.first()).filter{position -> position !in visited }
            .flatMap{ findWord(word.drop(1), visited +  it) }

data class Position(val row:Int, val col:Int) {
    fun possibleMove(board:Board, target:Char) = surroundings(board).filter {  board[it] == target}

    fun surroundings(board:Board) = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)
        .map{ Position(row + it.first, col + it.second) }
        .filter { it != this && it.row in board.rowRange && it.col in board.colRange}
}

