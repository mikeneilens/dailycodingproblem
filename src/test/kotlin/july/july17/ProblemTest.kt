package july.july17

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import july.july17.product
import july.july17.productExcludingItemAtIndex
import july.july17.productExcludingItemAtIndexNoDivision

class ProblemTest: StringSpec( {
    "given [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]" {
        productExcludingItemAtIndex(listOf(1, 2, 3, 4, 5)) shouldBe listOf(120, 60, 40, 30, 24)
    }
    "product of an empty list is zero" {
        listOf<Int>().product() shouldBe 0
    }
    "product of [44] is 44" {
        listOf(44).product() shouldBe 44
    }
    "product of [5,7] is 35" {
        listOf(5,7).product() shouldBe  35
    }
    "given [3, 2, 1], the expected output would be [2, 3, 6]" {
        productExcludingItemAtIndex(listOf(3, 2, 1)) shouldBe listOf(2, 3, 6)
    }

    "product of [1, 2, 3, 4, 5] excluding item at index 0 should be 120" {
        listOf(1, 2, 3, 4, 5).productExcludingItemAtIndex(0) shouldBe 120
    }
    "product of [1, 2, 3, 4, 5] excluding item at index 1 should be 60" {
        listOf(1, 2, 3, 4, 5).productExcludingItemAtIndex(1) shouldBe 60
    }
    "given [1, 2, 3, 4, 5] without using division, the expected output would be [120, 60, 40, 30, 24]" {
        productExcludingItemAtIndexNoDivision(listOf(1, 2, 3, 4, 5)) shouldBe listOf(120, 60, 40, 30, 24)
    }
})