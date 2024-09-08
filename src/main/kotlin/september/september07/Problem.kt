package september.september07

//Sudoku is a puzzle where you're given a partially-filled 9 by 9 grid with digits.
// The objective is to fill the grid with the constraint that every row, column, and box (3 by 3 subgrid) must
// contain all the digits from 1 to 9.
//
//Implement an efficient sudoku solver.

typealias Grid = List<List<Char>>

fun solveGrid(grid:Grid):List<Grid> {
    if (grid.isComplete()) return listOf(grid)
    val candidateValues = grid.getCandidates()
    if (candidateValues.isEmpty()) return listOf()
    val singleValues = candidateValues.filter{it.values.size == 1}
    if (singleValues.isNotEmpty()) {
        return solveGrid(grid.replaceValues(singleValues))
    } else {
        val (position, values) = candidateValues.minBy { it.values.size }
        val newGrids = values.map { newValue -> grid.replaceValue(position, newValue) }
        return newGrids.flatMap { solveGrid(it) }
    }
}

fun Grid.isComplete() = flatMap{columns -> columns.map{ it != ' '}}.all{ it }

data class Position(val row:Int, val col:Int)

data class Candidate(val position:Position, val values:Set<Char>)

fun List<Candidate>.toMap():Map<Position, Set<Char>> = associate { Pair(it.position, it.values) }

val numbers = setOf('1','2','3','4','5','6','7','8','9')

fun Grid.cellsForColumn(col:Int) = indices.map{row -> get(row)[col] }.toSet()

fun Grid.cellsForRow(row:Int) = get(row).toSet()

fun Grid.cellsForSubGrid(row:Int, col:Int) =
    row.subRange.flatMap{ r -> col.subRange.map{ c -> get(r)[c] }}.toSet()

fun Grid.valuesAllowed(row:Int, col:Int) = if (get(row)[col] !in numbers)
    numbers - (cellsForRow(row) + cellsForColumn(col) + cellsForSubGrid(row, col)) else setOf()

fun Grid.getCandidates() =
    flatMapIndexed{row, columns -> columns.indices.map{col -> Candidate(Position(row, col), valuesAllowed(row, col))}}.filter{it.values.isNotEmpty()}

val Int.subRange get() = (this / 3 * 3)..(this / 3 * 3 + 2)

fun Grid.replaceValues(candidates:List<Candidate>):Grid {
    val mapOfValues = candidates.toMap()
    return  mapIndexed{row, columns -> columns.mapIndexed {col, value -> if (mapOfValues.containsKey(Position(row,col))) mapOfValues.getValue(Position(row, col)).first() else value } }
}

fun Grid.replaceValue(position:Position, newValue:Char) =
    mapIndexed{row, columns -> columns.mapIndexed {col, value -> if (Position(row, col)== position) newValue else value } }
