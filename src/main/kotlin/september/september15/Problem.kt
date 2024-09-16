package september.september15

//There is an N by M matrix of zeroes. Given N and M, write a function to count the number of ways of starting in the top-left corner and getting to the bottom-right corner. You can only move right or down.
//
//For example, given a 2 by 2 matrix, you should return 2, since there are two ways to get to the bottom-right:
//
//Right, then down.
//Down, then right.
//Given a 5 by 5 matrix, there are 70 ways to get to the bottom-right.

data class Position(val row:Int, val col:Int) {
    fun adjacentPositions(rowRange:IntRange, colRange:IntRange) =
        listOf(Position(row + 1, col), Position(row, col + 1)).filter{it.row in rowRange && it.col in colRange}
}

//simple depth first search
fun routes(rowRange:IntRange, colRange:IntRange, route:List<Position> = listOf(Position(1,1))): List<List<Position>> =
    if (route.last() == Position(rowRange.last, colRange.last)) listOf(route)
    else route.last().adjacentPositions(rowRange, colRange)
            .filter {newPosition -> newPosition !in route }
            .flatMap {newPosition -> routes( rowRange, colRange, route + newPosition) }
