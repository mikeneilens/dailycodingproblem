package july17

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

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
})