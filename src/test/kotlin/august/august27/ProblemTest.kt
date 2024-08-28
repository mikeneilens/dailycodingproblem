package august.august27

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec( {
    "with [1,2,3,4,3] remove 3 from the list" {
        listOf(1,2,3,4,3).removeFirst(3) shouldBe listOf(1,2,4,3)
    }
    "with [1,2,4,6] and target 7 result is [1,2,4]" {
        findTarget(listOf(1,2,4,6), Status(target = 7)) shouldBe listOf(1,2,4)
    }
    "with [1,2,4,6] and target 14 result is []" {
        findTarget(listOf(1,2,4,6), Status(target = 14)) shouldBe emptyList()
    }
    "with [2,4,6] and target 8 result is [2,6]" {
        findTarget(listOf(2,4,6), Status(target = 8)) shouldBe listOf(2,6)
    }
    "with [1,2,4,6] and target 8 result is [2,6]" {
        problem(listOf(1,2,4,6), target = 8) shouldBe listOf(2,6)
    }
    "with [12, 1, 61, 5, 9, 2] and target 24 result is [12, 9, 2, 1]" {
        problem(listOf(12, 1, 61, 5, 9, 2).sortedDescending(), 24) shouldBe listOf(12,9,2,1)
    }
})

