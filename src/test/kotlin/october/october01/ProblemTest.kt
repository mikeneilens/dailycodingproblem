package october.october01

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    "[1,[2,[3]]] as a list is [1,2,3]" {
        Node(1, Node(2,Node(3,null))).toList() shouldBe listOf(1,2,3)
    }
    "merge [[1]] into a list should give [1]" {
        val node1_1 = Node(1, null)
        val list1 = LinkedList(node1_1, node1_1)
        val result = merge(listOf(list1))
        result.firstNode shouldBe node1_1
        result.lastNode shouldBe node1_1
        list1.firstNode shouldBe null
    }
    "merge [[1,2]] into a list should give [1,2]" {
        val node1_2 = Node(2, null)
        val node1_1 = Node(1, node1_2)
        val list1 = LinkedList(node1_1, node1_1)
        val result = merge(listOf(list1))
        result.firstNode shouldBe node1_1
        result.lastNode shouldBe  node1_2
        result.firstNode?.toList() shouldBe listOf(1,2)
        list1.firstNode shouldBe null
    }
    "merge [[1],[2]] into a list should give [1,2]" {

        val node1_1 = Node(1, null)
        val node2_1 = Node(2, null)
        val list1 = LinkedList(node1_1, node1_1)
        val list2 = LinkedList(node2_1, node2_1)
        val result = merge(listOf(list1, list2))
        result.firstNode shouldBe node1_1
        result.lastNode shouldBe  node2_1
        result.firstNode?.toList() shouldBe listOf(1,2)
        list1.firstNode shouldBe null
        list2.firstNode shouldBe null
    }
    "merge [[1,3],[2]] into a list should give [1,2,3]" {

        val node1_2 = Node(3, null)
        val node1_1 = Node(1, node1_2)
        val node2_1 = Node(2, null)
        val list1 = LinkedList(node1_1, node1_2)
        val list2 = LinkedList(node2_1, node2_1)
        val result = merge(listOf(list1, list2))
        result.firstNode shouldBe node1_1
        result.firstNode?.toList() shouldBe listOf(1,2,3)
        result.lastNode shouldBe  node1_2
        list1.firstNode shouldBe null
        list2.firstNode shouldBe null
    }
})