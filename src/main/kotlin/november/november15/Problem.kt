package november.november15

//You are given a 2-d matrix where each cell represents number of coins in that cell. Assuming we start at matrix[0][0],
// and can only move right or down, find the maximum number of coins you can collect by the bottom right corner.

//For example, in this matrix
//
//0 3 1 1
//2 0 0 4
//1 5 3 1
//The most we can collect is 0 + 2 + 1 + 5 + 3 + 1 = 12 coins.

typealias Matrix = Map<Position, Int>

typealias BestRoute = Matrix.(locationCost:MutableMap<Position, Int>, newPosition:Position, oldPosition:Position)-> Boolean

fun List<String>.toMatrix():Matrix = flatMapIndexed{ row, string -> string.split(" ")
    .mapIndexed {col, num -> Pair(Position(col, row),num.toInt())} }.toMap()

data class Position(val col:Int, val row:Int) {
    fun neighbours(chart:Matrix)  = setOf(
        Position(col + 1, row), Position( col, row +1)
    ).filter{it in chart}
}

fun problem(m:List<String>, bestRoute:BestRoute):Int {
    val matrix = m.toMatrix()
    val locationCost = mutableMapOf(Position(0,0) to 0)
    matrix.findEnd(listOf(Position(0,0)), locationCost, Position(3,2), bestRoute)
    return locationCost[Position(3,2)] ?: 0
}


//depth first search with memoization
fun Matrix.findEnd(visited:List<Position>, locationCost:MutableMap<Position, Int>, end:Position, bestRoute:BestRoute) {
    if (visited.last() == end) return
    visited.last().neighbours(this).filter{ bestRoute(locationCost, it, visited.last()) }.forEach { newPosition ->
        locationCost[newPosition] = locationCost.getValue(visited.last()) + getValue(newPosition)
        findEnd(visited + newPosition, locationCost, end, bestRoute)
    }
}

fun Matrix.isHigher(locationCost:MutableMap<Position, Int>, newPosition:Position, oldPosition:Position) =
    newPosition !in locationCost || locationCost.getValue(oldPosition) + getValue(newPosition) > locationCost.getValue(newPosition)

fun Matrix.isLower(locationCost:MutableMap<Position, Int>, newPosition:Position, oldPosition:Position) =
    newPosition !in locationCost || locationCost.getValue(oldPosition) + getValue(newPosition) < locationCost.getValue(newPosition)

