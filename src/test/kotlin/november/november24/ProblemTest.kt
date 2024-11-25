package november.november24

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class ProblemTest: StringSpec({
    "cloning a node in a linked list with no other nodes creates an identical list" {
        val nodeMap = mutableMapOf<Node, Node>()
        val node = Node(1, Node(2, Node(3)))
        val clone = clone(node, nodeMap)
        clone?.value shouldBe 1
        clone?.next?.value shouldBe 2
        clone?.next?.next?.value shouldBe 3
        clone?.next?.next?.next?.value shouldBe null
        nodeMap[node] shouldBe clone
        nodeMap[node.next] shouldBe clone?.next
        nodeMap[node.next?.next] shouldBe clone?.next?.next
    }
    "cloning a node in a linked list with links to other nodes creates an identical list" {
        val node3 = Node(3)
        val node2 = Node(2, node3)
        val node1 = Node(1, node2)
        node1.other = node3
        node2.other = node1
        node3.other = node2
        val nodeMap = mutableMapOf<Node, Node>()
        val clone = clone(node1, nodeMap)
        clone?.value shouldBe 1
        clone?.next?.value shouldBe 2
        clone?.next?.next?.value shouldBe 3
        clone?.next?.next?.next?.value shouldBe null
        clone?.other shouldBe node3
        clone?.next?.other shouldBe node1
        clone?.next?.next?.other shouldBe node2
        nodeMap[node1] shouldBe clone
        nodeMap[node2] shouldBe clone?.next
        nodeMap[node3] shouldBe clone?.next?.next
    }
    "updates other correctly" {
        val random1 = Node(4)
        val random2 = Node(5)
        val random3 = Node(6)
        val node3 = Node(3)
        val node2 = Node(2, node3)
        val node1 = Node(1, node2)
        node1.other = node3
        node2.other = node1
        node3.other = node2
        val map = mutableMapOf(node1 to random1, node2 to random2, node3 to random3)

        updateOther(node1, map)

        node1.other shouldBe random3
        node2.other shouldBe random1
        node3.other shouldBe random2
    }
    "clones node including the random links" {
        val node3 = Node(3)
        val node2 = Node(2, node3)
        val node1 = Node(1, node2)
        node1.other = node3
        node2.other = node1
        node3.other = node2

        val clone = problem(node1)

        clone?.value shouldBe 1
        clone?.next?.value shouldBe 2
        clone?.next?.next?.value shouldBe 3
        clone?.next?.next?.next?.value shouldBe null

        clone?.other?.value shouldBe 3
        clone?.next?.other?.value shouldBe 1
        clone?.next?.next?.other?.value shouldBe 2

        clone?.other shouldNotBe  node1.other
        clone?.next?.other shouldNotBe  node2.other
        clone?.next?.next?.other shouldNotBe  node3.other

    }
})