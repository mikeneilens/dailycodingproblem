package august.august07

//You are given an M by N matrix consisting of booleans that represents a board. Each True boolean represents a wall.
// Each False boolean represents a tile you can walk on.
//
//Given this matrix, a start coordinate, and an end coordinate, return the minimum number of steps required to reach
// the end coordinate from the start. If there is no possible path, then return null.
// You can move up, left, down, and right. You cannot move through walls. You cannot wrap around the edges of the board.
//
//For example, given the following board:
//
//[[f, f, f, f],
//[t, t, f, t],
//[f, f, f, f],
//[f, f, f, f]]
//and start = (3, 0) (bottom left) and end = (0, 0) (top left),
// the minimum number of steps required to reach the end is 7, since we would need to go through (1, 2) because there is a wall everywhere else on the second row.

fun problem(start: Position, end: Position, board:List<List<Boolean>>):Int {
    return expandFrontierUntilEnd(setOf(start), board.toChart(), end)
}

fun List<List<Boolean>>.toChart():Set<Position> =
    flatMapIndexed { row, list ->
        list.mapIndexedNotNull{ col, bool -> if (bool) null else Position(row, col) }
    }.toSet()

data class Position(val row: Int, val col: Int) {
    fun neighbours(chart:Set<Position>)  = setOf(
        Position(row -1, col), Position(row, col + 1), Position(row +1, col), Position(row, col -1)
    ).filter{it in chart}
}

//Do a breadth first search
tailrec fun expandFrontierUntilEnd(frontier: Set<Position>, chart: Set<Position>, end: Position, visited: Set<Position> = setOf(), steps: Int = 0):Int {
    if (end in frontier || frontier.isEmpty()) return steps
    val newFrontier = createNewFrontier(frontier, visited, chart)
    return expandFrontierUntilEnd(newFrontier, chart, end, visited + frontier, steps + 1)
}

fun createNewFrontier(frontier:Set<Position>, visited:Set<Position>, chart:Set<Position>) =
    frontier.neighboursOnChart(chart).positionsNotVisited(visited).toSet()

fun Set<Position>.neighboursOnChart(chart:Set<Position>) = flatMap { position -> position.neighbours(chart)}

fun List<Position>.positionsNotVisited(visited:Set<Position>) = filter{ position -> position !in visited}