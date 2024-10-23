package october.october23

import kotlin.math.abs

//You are in an infinite 2D grid where you can move in any of the 8 directions
//
//You are given a sequence of points and the order in which you need to cover the points.
// Give the minimum number of steps in which you can achieve it. You start from the first point.
//
//Example:
//
//Input: [(0, 0), (1, 1), (1, 2)]
//Output: 2
//It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).


fun List<Point>.steps() = drop(1).fold(Pair(0, first())){ result, nextPoint ->
    Pair(result.first + result.second.distanceTo(nextPoint), nextPoint)
}.first

data class Point(val row:Int, val col:Int) {
    fun distanceTo(other:Point) = minOf(abs(row - other.row), abs(col - other.col)) +
            abs(abs(row - other.row) - abs(col - other.col))
}

