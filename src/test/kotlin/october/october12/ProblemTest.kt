package october.october12

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    "node with no left or right is valid" {
        Node(value = 1).isValid() shouldBe true
    }
    "node with root value 1 and left value 1 and right value null  is valid" {
        val node = Node(value = 1, left = Node(value = 1))
        node.isValid() shouldBe true
    }
    "node with root value 1 and left value 0 and right value null  is valid" {
        val node = Node(value = 1, left = Node(value = 0))
        node.isValid() shouldBe true
    }
    "node with root value 1 and left value 1 and right value 1  is valid" {
        val node = Node(value = 1, left = Node(value = 1), right = Node(value = 1))
        node.isValid() shouldBe true
    }
    "node with root value 1 and left value 1 and right value 2  is valid" {
        val node = Node(value = 1, left = Node(value = 1), right = Node(value = 2))
        node.isValid() shouldBe true
    }
    "node with root value 1 and left value 2 and right value 1  is not valid" {
        val node = Node(value = 1, left = Node(value = 2), right = Node(value = 1))
        node.isValid() shouldBe false
    }
    "node with root value 1 and left value 1 and right value 0  is not valid" {
        val node = Node(value = 1, left = Node(value = 1), right = Node(value = 0))
        node.isValid() shouldBe false
    }
    "node with root value 1 and left value 1 and left child value 0 and is valid and right value 1  is not valid" {
        val node = Node(value = 1, left = Node(value = 1, left = Node(0)), right = Node(value = 1))
        node.isValid() shouldBe true
    }
    "node with root value 1 and left value 1 and right child value 2 is valid and right value 1 is not valid" {
        val node = Node(value = 1, left = Node(value = 1, right = Node(2)), right = Node(value = 1))
        node.isValid() shouldBe true
    }
    "node with root value 1 and left value 1 and left child value 1 is not valid and right value 1  is not valid" {
        val node = Node(value = 1, left = Node(value = 1, left = Node(2)), right = Node(value = 1))
        node.isValid() shouldBe false
    }
    "node with root value 1 and left value 1 and right child value 1 is not valid and right value 1  is not valid" {
        val node = Node(value = 1, left = Node(value = 1, right = Node(0)), right = Node(value = 1))
        node.isValid() shouldBe false
    }
})