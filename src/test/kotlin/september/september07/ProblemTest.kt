package september.september07

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    "grid is complete " {
        val grid = listOf(listOf('1','2','3'),listOf('4','5','6'),listOf('7','8','9'))
        grid.isComplete() shouldBe true
    }
    "grid is not complete " {
        val grid = listOf(listOf('1','2','3'),listOf('4','5',' '),listOf('7','8','9'))
        grid.isComplete() shouldBe false
    }
    "get values of cells for a column " {
        val grid = listOf(listOf('1','2','3'),listOf('4','5','6'),listOf('7','8','9'))
        grid.cellsForColumn(1) shouldBe setOf('2','5','8')
    }
    "get values of cells for a row " {
        val grid = listOf(listOf('1','2','3'),listOf('4','5','6'),listOf('7','8','9'))
        grid.cellsForRow(1) shouldBe setOf('4','5','6')
    }
    "get values of cells in a subgrid" {
        val grid = listOf(
            listOf('5','3','4','6','7','8','9','1','2'),
            listOf('6','7','2','1','9','5','3','4','8'),
            listOf('1','9','8','3','4','2','5','6','7'),
            listOf('8','5','9','7','6','1','4','2','3'),
            listOf('4','2','6','8','5','3','7','9','1'),
            listOf('7','1','3','9','2','4','8','5','6'),
            listOf('9','6','1','5','3','7','2','8','4'),
            listOf('2','8','7','4','1','9','6','3','5'),
            listOf('3','4','5','2','8','6','1','7','9')
        )
        grid.cellsForSubGrid(0,1) shouldBe setOf('1','2','3','4','5','6','7','8','9')
        grid.cellsForSubGrid(0,3) shouldBe setOf('1','2','3','4','5','6','7','8','9')
        grid.cellsForSubGrid(0,8) shouldBe setOf('1','2','3','4','5','6','7','8','9')
        grid.cellsForSubGrid(3,8) shouldBe setOf('1','2','3','4','5','6','7','8','9')
        grid.cellsForSubGrid(7,8) shouldBe setOf('1','2','3','4','5','6','7','8','9')
    }
    "values allowed in a cell" {
        val grid = listOf(
            listOf('5','3','4','6','7','8','9','1','2'),
            listOf('6',' ','2',' ','9','5','3','4','8'),
            listOf(' ','9','8','3','4','2','5','6','7'),
            listOf('8','5','9','7','6','1','4','2','3'),
            listOf('4','2','6','8','5','3','7','9','1'),
            listOf('7',' ','3','9','2','4','8','5','6'),
            listOf('9','6','1','5','3','7','2','8','4'),
            listOf('2','8','7','4','1','9','6','3','5'),
            listOf('3','4','5','2','8','6','1','7','9')
        )
        grid.valuesAllowed(1,1) shouldBe setOf('1','7')
    }
    "candidates for the grid" {
        val grid = listOf(
            listOf('5','3','4','6','7','8','9','1','2'),
            listOf('6',' ','2',' ','9','5','3','4','8'),
            listOf(' ','9','8','3','4','2','5','6','7'),
            listOf('8','5','9','7','6','1','4','2','3'),
            listOf('4','2','6','8','5','3','7',' ','1'),
            listOf('7',' ','3','9','2','4','8','5','6'),
            listOf('9','6','1','5','3','7','2','8','4'),
            listOf('2','8','7','4',' ','9','6','3','5'),
            listOf('3','4','5','2','8','6','1','7','9')
        )
        grid.getCandidates() shouldBe listOf(
            Candidate(Position(row=1, col=1), values=setOf('1', '7')),
            Candidate(Position(row=1, col=3), values=setOf('1')),
            Candidate(Position(row=2, col=0), values=setOf('1')),
            Candidate(Position(row=4, col=7), values=setOf('9')),
            Candidate(Position(row=5, col=1), values=setOf('1')),
            Candidate(Position(row=7, col=4), values=setOf('1'))
        )
    }
    "replace a values in a grid with values in a map" {
        val grid = listOf(
            listOf('1','2','3'),
            listOf('4','5','6'),
            listOf('7','8','9'))
        val candidates = listOf(
            Candidate(Position(0,2), setOf('X')),
            Candidate(Position(1,1), setOf('Y')),
            Candidate(Position(2,0), setOf('Z')))
        grid.replaceValues(candidates) shouldBe listOf(
            listOf('1','2','X'),
            listOf('4','Y','6'),
            listOf('Z','8','9'))
    }
    "solve simple grid" {
        val grid = listOf(
            listOf('5','3','4','6','7','8','9','1','2'),
            listOf('6',' ','2',' ','9','5','3','4','8'),
            listOf(' ','9','8','3','4','2','5','6','7'),
            listOf('8','5','9','7','6','1','4','2','3'),
            listOf('4','2','6','8','5','3','7',' ','1'),
            listOf('7',' ','3','9','2','4','8','5','6'),
            listOf('9','6','1','5','3','7','2','8','4'),
            listOf('2','8','7','4',' ','9','6','3','5'),
            listOf('3','4','5','2','8','6','1','7','9')
        )
        solveGrid(grid) shouldBe listOf(
            listOf(
                listOf('5','3','4','6','7','8','9','1','2'),
                listOf('6','7','2','1','9','5','3','4','8'),
                listOf('1','9','8','3','4','2','5','6','7'),
                listOf('8','5','9','7','6','1','4','2','3'),
                listOf('4','2','6','8','5','3','7','9','1'),
                listOf('7','1','3','9','2','4','8','5','6'),
                listOf('9','6','1','5','3','7','2','8','4'),
                listOf('2','8','7','4','1','9','6','3','5'),
                listOf('3','4','5','2','8','6','1','7','9')
            )
        )
    }
    "solve a grid that requires trial and error" {
        val grid = listOf(
            listOf(' ',' ',' ',' ','6','8','5',' ','2'),
            listOf('4',' ',' ','7',' ',' ',' ',' ',' '),
            listOf(' ',' ','5',' ',' ',' ',' ','6','7'),
            listOf(' ','9','4',' ',' ',' ','8',' ',' '),
            listOf(' ','7','1','5',' ','6','4','2','3'),
            listOf(' ','5','3','8','4','1',' ','9','6'),
            listOf('5',' ',' ',' ','7','4',' ','3',' '),
            listOf(' ',' ','6',' ',' ',' ','2',' ',' '),
            listOf('3',' ','8','6',' ','9',' ',' ',' ')
        )
        solveGrid(grid).distinct() shouldBe listOf(
            listOf(
                listOf('1', '3', '7', '9', '6', '8', '5', '4', '2'),
                listOf('4', '6', '2', '7', '3', '5', '9', '8', '1'),
                listOf('9', '8', '5', '4', '1', '2', '3', '6', '7'),
                listOf('6', '9', '4', '3', '2', '7', '8', '1', '5'),
                listOf('8', '7', '1', '5', '9', '6', '4', '2', '3'),
                listOf('2', '5', '3', '8', '4', '1', '7', '9', '6'),
                listOf('5', '1', '9', '2', '7', '4', '6', '3', '8'),
                listOf('7', '4', '6', '1', '8', '3', '2', '5', '9'),
                listOf('3', '2', '8', '6', '5', '9', '1', '7', '4')
            )
        )
    }
})