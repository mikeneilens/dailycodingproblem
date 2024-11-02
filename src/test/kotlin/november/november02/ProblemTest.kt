package november.november02

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    "node(1) with no left or right nodes has path of [[1]]" {
        Node(1).paths() shouldBe listOf(listOf(1))
    }
    "node(1, left = node(2), right = null)  has path of [[1,2]]" {
        Node(1, left = Node(2)).paths() shouldBe listOf(listOf(1,2))
    }
    "node(1, left = node(2), right = node(3)  has path of [[1,2],[1,3]]" {
        Node(1, left = Node(2), right = Node(3)).paths() shouldBe listOf(listOf(1,2),listOf(1,3))
    }
    "node(1, left = node(2), right = node(3, left = node(4), right node(5))  has path of [[1,2],[1,3,4], [1,3,5]]" {
        val node = Node(1,
            left = Node(2),
            right = Node(3,
                left= Node(4),
                right = Node(5)))

        problem(node) shouldBe listOf(listOf(1,2), listOf(1,3,4), listOf(1,3,5))
    }
})