package august.august19

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec( {
    "re-order [] should give []" {
        val array = mutableListOf<String>()
        threeWayPartition(array)
        array shouldBe mutableListOf()
    }
    "re-order [R] should give [R]" {
        val array = mutableListOf("R")
        threeWayPartition(array)
        array shouldBe mutableListOf("R")
    }
    "re-order [G, R] should give [R, G]" {
        val array = mutableListOf("G","R")
        threeWayPartition(array)
        array shouldBe mutableListOf("R","G")
    }
    "re-order [G, B, R] should give [R, G, B]" {
        val array = mutableListOf("G", "B", "R")
        threeWayPartition(array)
        array shouldBe mutableListOf("R","G", "B")
    }
    "re-order ['G', 'B', 'R', 'R', 'B', 'R', 'G'] should give ['R', 'R', 'R', 'G', 'G', 'B', 'B']" {
        val array = mutableListOf("G", "B", "R", "R", "B", "R", "G")
        threeWayPartition(array)
        array shouldBe mutableListOf("R", "R", "R", "G", "G", "B", "B")
    }
})