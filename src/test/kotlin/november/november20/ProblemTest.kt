package november.november20

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    "adding a null node to null returns the null node" {
        val node:Node? = null
        node.plus(null) shouldBe node
    }
    "adding a node to null returns the node" {
        Node(1).plus(null) shouldBe Node(1)
    }
    "adding node(1) to node(2) return node(3)" {
        Node(1).plus(Node(2)) shouldBe Node(3)
    }
    "adding node(1,Node(2) to node(3) returns node(4, node(2))" {
        Node(1, Node(2)).plus(Node(3)) shouldBe Node(4, Node(2))
    }
    "adding node(1,node(2) to node(3, node(4)) returns node(4, node(6))" {
        Node(1, Node(2)).plus(Node(3, Node(4))) shouldBe Node(4, Node(6))
    }
    "adding node(5) to node(5) returns node(0, node(1))" {
        Node(5).plus(Node(5)) shouldBe Node(0, Node(1))
    }
    "adding node(9, node(9)) to node(5,node(2)) returns node(4, node(2, node(1)))" {
        Node(9, Node(9)).plus(Node(5, Node(2))) shouldBe Node(4, Node(2, Node(1)))
    }
})