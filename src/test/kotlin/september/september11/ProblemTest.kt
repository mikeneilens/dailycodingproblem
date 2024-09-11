package september.september11

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    "for [1,2,3,4,5,6,7,8] find index of each value" {
        listOf(1,2,3,4,5,6,7,8).findVal(1) shouldBe 0
        listOf(1,2,3,4,5,6,7,8).findVal(2) shouldBe 1
        listOf(1,2,3,4,5,6,7,8).findVal(3) shouldBe 2
        listOf(1,2,3,4,5,6,7,8).findVal(4) shouldBe 3
        listOf(1,2,3,4,5,6,7,8).findVal(5) shouldBe 4
        listOf(1,2,3,4,5,6,7,8).findVal(6) shouldBe 5
        listOf(1,2,3,4,5,6,7,8).findVal(7) shouldBe 6
        listOf(1,2,3,4,5,6,7,8).findVal(8) shouldBe 7
    }
    "for [8,1,2,3,4,5,6,7] find index of each value" {
        listOf(8,1,2,3,4,5,6,7).findVal(1) shouldBe 1
        listOf(8,1,2,3,4,5,6,7).findVal(2) shouldBe 2
        listOf(8,1,2,3,4,5,6,7).findVal(3) shouldBe 3
        listOf(8,1,2,3,4,5,6,7).findVal(4) shouldBe 4
        listOf(8,1,2,3,4,5,6,7).findVal(5) shouldBe 5
        listOf(8,1,2,3,4,5,6,7).findVal(6) shouldBe 6
        listOf(8,1,2,3,4,5,6,7).findVal(7) shouldBe 7
    }
    "for [13, 18, 25, 2, 8, 10] find index of 8" {
        listOf(13, 18, 25, 2, 8, 10).findVal(8) shouldBe 4
    }
    "for [13, 18, 25, 2, 8, 10] find index of 13" {
        listOf(13, 18, 25, 2, 8, 10).findVal(17) shouldBe null
    }
})