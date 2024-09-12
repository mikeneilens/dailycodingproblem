package august.august19

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec( {
    "re-order [] should give []" {
        val array = mutableListOf<String>()
        threeWayPartition(array)
        array shouldBe mutableListOf<String>()
    }
    "re-order [R] should give [R]" {
        val array = mutableListOf<String>("R")
        threeWayPartition(array)
        array shouldBe mutableListOf<String>("R")
    }
    "re-order [G, R] should give [R, G]" {
        val array = mutableListOf<String>("G","R")
        threeWayPartition(array)
        array shouldBe mutableListOf<String>("R","G")
    }
    "re-order [G, B, R] should give [R, G, B]" {
        val array = mutableListOf<String>("G", "B", "R")
        threeWayPartition(array)
        array shouldBe mutableListOf<String>("R","G", "B")
    }
    "re-order ['G', 'B', 'R', 'R', 'B', 'R', 'G'] should give ['R', 'R', 'R', 'G', 'G', 'B', 'B']" {
        val array = mutableListOf<String>("G", "B", "R", "R", "B", "R", "G")
        threeWayPartition(array)
        array shouldBe mutableListOf<String>("R", "R", "R", "G", "G", "B", "B")
    }
})