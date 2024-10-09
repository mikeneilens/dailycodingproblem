package october.october06

//Given a matrix of 1s and 0s, return the number of "islands" in the matrix.
// A 1 represents land and 0 represents water, so an island is a group of 1s that are neighboring
// whose perimeter is surrounded by water.
//
//For example, this matrix has 4 islands.
//
//1 0 0 0 0
//0 0 1 1 0
//0 1 1 0 0
//0 0 0 0 0
//1 1 0 0 1
//1 1 0 0 1

fun problem(data:List<String>):List<Set<Position>> {
    val terrain = data.toTerrain()
    val islands = mutableListOf<Set<Position>>()
    terrain.forEach{position ->
        if (!islands.contains(position)) islands.add(terrain.islandPositions(position))
    }
    return islands
}

data class Position(val row:Int, val col:Int) {
    fun adjacent(maxRow:Int, maxCol:Int) =
        (-1..1).flatMap{r -> (-1..1).map{c -> Position(row + r, col + c)}}
            .filter { it != this && it.col in 0..maxCol && it.row in 0..maxRow }
            .toSet()
}

fun List<String>.toTerrain():List<Position> =
    flatMapIndexed{row, string -> string.split(" ").mapIndexed {col, s -> Pair(Position(row, col), s.toInt())}}
        .filter {it.second != 0}.map{it.first}


fun List<Position>.islandPositions(start:Position, visited:MutableSet<Position> = mutableSetOf()):Set<Position> =
     if (contains(start) && start !in visited) {
         visited.add(start)
         setOf(start) + start.adjacent(maxOf { it.row },maxOf { it.col }).flatMap { islandPositions(it, visited) }.toSet()
     } else setOf()

fun  List<Set<Position>>.contains(position:Position) = any{it.contains(position)}

