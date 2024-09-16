package september.september15

//There is an N by M matrix of zeroes. Given N and M, write a function to count the number of ways of starting in the top-left corner and getting to the bottom-right corner. You can only move right or down.
//
//For example, given a 2 by 2 matrix, you should return 2, since there are two ways to get to the bottom-right:
//
//Right, then down.
//Down, then right.
//Given a 5 by 5 matrix, there are 70 ways to get to the bottom-right.

data class Matrix(val rows:Int, val cols:Int) {
    val startPosition = Position(1,1)
    val endPosition = Position(rows, cols)
    operator fun contains(position:Position) = position.row in 1..rows && position.col in 1..cols
}

data class Position(val row:Int, val col:Int) {
    fun adjacentPositions(matrix:Matrix) =
        listOf(Position(row + 1, col), Position(row, col + 1)).filter{it in matrix}
}

//simple depth first search
fun routes(matrix:Matrix, route:List<Position> = listOf(matrix.startPosition)): List<List<Position>> =
    if (route.last() == matrix.endPosition) listOf(route)
    else route.last().adjacentPositions(matrix)
            .filter {newPosition -> newPosition !in route }
            .flatMap {newPosition -> routes( matrix, route + newPosition) }
