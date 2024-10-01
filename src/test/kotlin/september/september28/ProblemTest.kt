package september.september28

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec( {
    "longest sequence from index 0 for array [5]  is 1" {
        listOf(5).longSequence().maxOf { it.size }   shouldBe 1
    }
    "longest sequence from index 0 for array [5,7]  is 2" {
        listOf(5,7).longSequence().maxOf { it.size }   shouldBe 2
    }
    "longest sequence from index 0 for array [5,4,7]  is 2" {
        listOf(5,4,7).longSequence().maxOf { it.size }   shouldBe 2
    }
    "longest sequence from index 0 for array [5,7,4]  is 2" {
        listOf(5,7,4).longSequence().maxOf { it.size }   shouldBe 2
    }
    "longest sequence from index 1 for array [5,4,7]  is 2" {
        listOf(5,4,7).longSequence(1).maxOf { it.size }   shouldBe 2
    }
    "longest sequence from index 0 for array [5,6,7]  is 3 and from index 1 is 2" {
        listOf(5,6,7).longSequence(0).maxOf { it.size }   shouldBe 3
        listOf(5,6,7).longSequence(1).maxOf { it.size }   shouldBe 2
    }
    "longest sequence from index 0 for array [5,99,6,7]  is 3" {
        listOf(5,99,6,7).longSequence(0).maxOf { it.size }   shouldBe 3
    }
    "For [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15] longest sequence is 6" {
        val numbers = listOf(0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15)
        problem(numbers) shouldBe 6
    }
    "For [99, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15] longest sequence is 6" {
        val numbers = listOf(99, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15)
        problem(numbers) shouldBe 5
    }
})