package august.august14

import august.august14.captureWater
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec( {
    "with empty list captured water is zero" {
        listOf<Int>().captureWater() shouldBe 0
    }
    "with list of one wall captured water is zero" {
        listOf(1).captureWater() shouldBe 0
    }
    "with list of two walls captured water is zero" {
        listOf(1, 2).captureWater() shouldBe 0
    }
    "with list of three ascending walls captured water is zero" {
        listOf(1, 2, 3).captureWater() shouldBe 0
    }
    "with list [2,1,2] walls captured water is one" {
        listOf(2,1,2).captureWater() shouldBe 1
    }
    "with list [2,0,1,3] walls captured water is one" {
        listOf(2,0,1,3).captureWater() shouldBe 3
    }
    "with list [3, 0, 1, 3, 0, 5] walls captured water is eight" {
        listOf(3, 0, 1, 3, 0, 5).captureWater() shouldBe 8
    }
    "with list of [6,0,4,0,2] walls captured water is 6" {
        listOf(6,0,4,0,2).captureWater() shouldBe 6
    }
    "with list of [2,0,6,0,4,0,2] walls captured water is 8 " {
        listOf(2,0,6,0,4,0,2).captureWater() shouldBe 8
    }
    "with list of [2,0,6,4,4,2,2] walls captured water is 8 " {
        listOf(2,0,6,4,4,2,2).captureWater() shouldBe 2
    }
})