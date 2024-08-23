package august24

//Conway's Game of Life takes place on an infinite two-dimensional board of square cells.
//Each cell is either dead or alive, and at each tick, the following rules apply:
//
//Any live cell with less than two live neighbours dies.
//Any live cell with two or three live neighbours remains living.
//Any live cell with more than three live neighbours dies.
//Any dead cell with exactly three live neighbours becomes a live cell.
//A cell neighbours another cell if it is horizontally, vertically, or diagonally adjacent.
//
//Implement Conway's Game of Life. It should be able to be initialized with a starting list of live cell coordinates
// and the number of steps it should run for. Once initialized, it should print out the board state at each step.
//Since it's an infinite board, print out only the relevant coordinates, i.e. from the top-leftmost live cell to bottom-rightmost live cell.
//
//You can represent a live cell with an asterisk (*) and a dead cell with a dot (.).

fun problem(cells:Set<Cell>, moves:Int):Set<Cell> {
    if (moves == 0) return cells else {
        val newSet = cells.mapNotNull { cell -> cell.liveCellLivesOrNull(cells)}.toSet()  +
                cells.deadCells().mapNotNull { cell -> cell.deadCellLivesOrNull(cells) }.toSet()
        println(newSet.asString())
        return problem(newSet, moves - 1)
    }
}

data class Cell(val row:Int, val col:Int) {
    val surroundingCells by lazy { (-1..1).flatMap { r -> (-1..1).map { c -> Cell(row + r, col + c) } }.filter { it != this }.toSet() }
    fun neighboursOf(otherCells:Set<Cell>) = surroundingCells intersect otherCells

    fun liveCellLivesOrNull(otherCells: Set<Cell>):Cell? {
        return if (neighboursOf(otherCells).size in 2..3) this else null
    }
    fun deadCellLivesOrNull(otherCells: Set<Cell>):Cell? {
        return if (neighboursOf(otherCells).size == 3) this else null
    }
}

fun Set<Cell>.deadCells() = flatMap { it.surroundingCells.filter { it !in this } }.toSet()

fun  Set<Cell>.asString() = (minOf{it.row}..maxOf{it.row}).map{
    row -> (minOf{it.col}..maxOf{it.col}).map{ col -> if(Cell(row, col) in this) '*' else '.'}.joinToString("") + "\n"}.joinToString("")