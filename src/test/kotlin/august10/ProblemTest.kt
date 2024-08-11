package august10

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    "with list of four nodes, 1 from last is node number 3" {
        val node = Node(1, Node(2, Node(3, Node(4))))
        kThFromLast(node, 1)?.value shouldBe 3
    }
    "with list of four nodes, 2 from last is node number 2" {
        val node = Node(1, Node(2, Node(3, Node(4))))
        kThFromLast(node, 2)?.value shouldBe 2
    }
    "with list of four nodes, 3 from last is node number 1" {
        val node = Node(1, Node(2, Node(3, Node(4))))
        kThFromLast(node, 3)?.value shouldBe 1
    }
    "with list of four nodes with values 1, 2, 3, 4, removing 1 from last gives 1,2,4" {
        val node = Node(1, Node(2, Node(3, Node(4))))
        val result = problem(node, 1)
        result?.value shouldBe 1
        result?.next?.value shouldBe 2
        result?.next?.next?.value shouldBe 4
    }
    "with list of four nodes with values 1, 2, 3, 4, removing 3 from last gives 2,3,4" {
        val node = Node(1, Node(2, Node(3, Node(4))))
        val result = problem(node, 3)
        result?.value shouldBe 2
        result?.next?.value shouldBe 3
        result?.next?.next?.value shouldBe 4
    }
    "with list of four nodes with values 1, 2, 3, 4, removing 0 from last gives 1,2,3" {
        val node = Node(1, Node(2, Node(3, Node(4))))
        val result = problem(node, 0)
        result?.value shouldBe 1
        result?.next?.value shouldBe 2
        result?.next?.next?.value shouldBe 3
    }
})