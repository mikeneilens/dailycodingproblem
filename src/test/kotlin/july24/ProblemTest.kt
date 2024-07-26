package july24

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({

    "best result for [(total=5, lastIndex = 2), (total=5, lastIndex = 3)] should return [(total=5, lastIndex = 2), (total=5, lastIndex = 3)]" {
        val result1 = NonAdjacentSum(5, 2, listOf())
        val result2 = NonAdjacentSum(5, 3, listOf())
        listOf(result1, result2).bestResults() shouldBe listOf(result1, result2)
    }
    "best result for [(total=5, lastIndex = 2), (total=5, lastIndex = 2)] should return [(total=5, lastIndex = 2)]" {
        val result1 = NonAdjacentSum(5, 2, listOf())
        val result2 = NonAdjacentSum(5, 2, listOf())
        listOf(result1, result2).bestResults() shouldBe listOf(result1)
    }
    "best result for [(total=5, lastIndex = 2), (total=6, lastIndex = 2)] should return [(total=6, lastIndex = 2)]" {
        val result1 = NonAdjacentSum(5, 2, listOf())
        val result2 = NonAdjacentSum(6, 2, listOf())
        listOf(result1, result2).bestResults() shouldBe listOf(result2)
    }
    "best result for [(total=6, lastIndex = 2), (total=5, lastIndex = 2)] should return [(total=6, lastIndex = 2)]" {
        val result1 = NonAdjacentSum(6, 2, listOf())
        val result2 = NonAdjacentSum(5, 2, listOf())
        listOf(result1, result2).bestResults() shouldBe listOf(result1)
    }

    "with total of 2 and last index of 2 and list of numbers (0,1,2,3,4,5) the next totals are (6, 4) and (7,5)" {
        val nonAdjacentSum = NonAdjacentSum(total=2, lastIndex=2, numbers=listOf(0,1,2,3,4,5))
        nonAdjacentSum.next() shouldBe listOf(
            NonAdjacentSum(total=6, lastIndex=4, numbers=listOf(0,1,2,3,4,5)),
            NonAdjacentSum(total=7, lastIndex=5, numbers=listOf(0,1,2,3,4,5))
        )
    }
    "with total of 6 and last index of 4 and list of numbers (0,1,2,3,4,5,6) the next totals are (12, 6)" {
        val nonAdjacentSum = NonAdjacentSum(total=6, lastIndex=4, numbers=listOf(0,1,2,3,4,5,6))
        nonAdjacentSum.next() shouldBe listOf(
            NonAdjacentSum(total=12, lastIndex=6, numbers=listOf(0,1,2,3,4,5,6)),
        )
    }
    "[] should return 0" {
        largestSumOfNonAdjacentNumbers2(listOf()) shouldBe 0
    }
    "[4] should return 4" {
        largestSumOfNonAdjacentNumbers2(listOf(4)) shouldBe 4
    }
    "[4,1] should return 4" {
        largestSumOfNonAdjacentNumbers2(listOf(4,1)) shouldBe 4
    }
    "[1,4] should return 4" {
        largestSumOfNonAdjacentNumbers2(listOf(1,4)) shouldBe 4
    }
    "[2, 4, 6, 2, 5] should return 13 with O(N) time" {
        largestSumOfNonAdjacentNumbers2(listOf(2, 4, 6, 2, 5)) shouldBe 13
    }
    "[5, 1, 1, 5] should return 10 with O(N) time" {
        largestSumOfNonAdjacentNumbers2(listOf(5, 1, 1, 5)) shouldBe 10
    }
})