package august.august28

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec( {
    "merge [4,2,6] with [7,3,1]" {
        val result = Result()
        val merged = merge(listOf(4,2,6), listOf(7,3,1), result)
        merged shouldBe listOf(4,2,6,7,3,1)
    }
    "The array [2, 4, 1, 3, 5] has three inversions" {
        val result = Result()
        mergeSort(listOf(2,4,1,3,5), result)
        result.value shouldBe 3
    }

    "[5, 4, 3, 2, 1] has ten inversions" {
        val result = Result()
        mergeSort(listOf(5,4,3,2,1), result)
        result.value shouldBe 10
    }
})