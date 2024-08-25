package august.august24

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec( {
    "there are eight cells surrounding cell(1,1)" {
        Cell(1, 1).surroundingCells shouldBe setOf(
            Cell(row=0, col=0), Cell(row=0, col=1), Cell(row=0, col=2),
            Cell(row=1, col=0),  Cell(row=1, col=2)
            , Cell(row=2, col=0), Cell(row=2, col=1), Cell(row=2, col=2)
        )
    }
    "when cell(1,1) is in same grid as cel(2,0), cell(4,3), cell(1,-1) it has two neighbours" {
        val grid = setOf(Cell(1,1), Cell(2,1), Cell(4,3), Cell(1,0))
        Cell(1,1).neighboursOf(grid) shouldBe setOf(Cell(2,1), Cell(1,0))
    }
    "living cell(1,1) with with no neighbours should become null " {
        Cell(1,1).liveCellLivesOrNull(emptySet()) shouldBe null
    }
    "living cell(1,1) with with one neighbours should become null " {
        Cell(1,1).liveCellLivesOrNull(setOf(Cell(2,2))) shouldBe null
    }
    "living cell(1,1) with with two neighbours should remain alive " {
        Cell(1,1).liveCellLivesOrNull(setOf(Cell(2,2), Cell(1,2))) shouldBe Cell(1,1)
    }
    "living cell(1,1) with with three neighbours should remain alive " {
        Cell(1,1).liveCellLivesOrNull(setOf(Cell(2,2), Cell(1,2), Cell(1,0))) shouldBe Cell(1,1)
    }
    "living cell(1,1) with with four neighbours should become null " {
        Cell(1,1).liveCellLivesOrNull(setOf(Cell(2,2), Cell(1,2), Cell(1,0), Cell(0,0))) shouldBe null
    }
    "dead cell(1,1) with with three neighbours should become alive " {
        Cell(1,1).deadCellLivesOrNull(setOf(Cell(2,2), Cell(1,2), Cell(1,0))) shouldBe Cell(1,1)
    }
    "dead cell(1,1) with with two neighbours should remain null " {
        Cell(1,1).deadCellLivesOrNull(setOf(Cell(2,2), Cell(1,2))) shouldBe null
    }
    "dead cell(1,1) with with four neighbours should become null " {
        Cell(1,1).deadCellLivesOrNull(setOf(Cell(2,2), Cell(1,2), Cell(1,0), Cell(0,0))) shouldBe null
    }
    "for grid containing one cell, dead cells are the cells surrounding it" {
        setOf(Cell(1,1)).deadCells() shouldBe Cell(1,1).surroundingCells
    }
    "for grid containing two adjacent cells, dead cells are the cells surrounding both of them but not including the two cells" {
        val expectedResults = Cell(1,1).surroundingCells + Cell(2,1).surroundingCells - Cell(1,1) - Cell(2,1)
        setOf(Cell(1,1), Cell(2,1)).deadCells() shouldBe expectedResults
    }
    "for grid containining 3 adjacent cells in a line, after 1 move the end cells die and a new cell is created either side of the line" {
        val grid = setOf(Cell(1,1), Cell(2,1), Cell(3,1))
        problem(grid, moves = 1) shouldBe setOf(Cell(row=2, col=0), Cell(row=2, col=1), Cell(row=2, col=2))
    }
    "for grid containining 3 adjacent cells in a line, after 2 moves the grid returns to its original state" {
        val grid = setOf(Cell(1,1), Cell(2,1), Cell(3,1))
        problem(grid, moves = 2) shouldBe setOf(Cell(row=1, col=1), Cell(row=2, col=1), Cell(row=3, col=1))
    }
    "for grid containining 4 adjacent cells in a line, after 3 moves the grid becomes stable" {
        val grid = setOf(Cell(1,1), Cell(2,1), Cell(3,1), Cell(4,1))
        problem(grid, moves = 3) shouldBe setOf(
            Cell(row=1, col=1),
            Cell(row=2, col=0), Cell(row=2, col=2),
            Cell(row=3, col=0), Cell(row=3, col=2),
            Cell(row=4, col=1),
            )
        problem(grid, moves = 3) shouldBe problem(grid, moves = 4)
    }
    "print a grid" {
        val grid = setOf(Cell(1,1), Cell(2,1), Cell(2,3), Cell(3,1), Cell(4,1),)
        grid.asString() shouldBe
                "*..\n" +
                "*.*\n" +
                "*..\n" +
                "*..\n"
    }
})