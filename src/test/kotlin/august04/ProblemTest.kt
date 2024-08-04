package august04

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    "when list1 and list2 contain 1 node which are both different then intersection is null" {
        val list1 = Node(1)
        val list2 = Node(2)
        intersection(list1, list2 ) shouldBe null
    }
    "when list1 and list2 containing 1 node which are both the same then intersection is the node" {
        val list1 = Node(1)
        val list2 = list1
        intersection(list1, list2) shouldBe list1
    }
    "when list1 and list2 containing more than 1 node but none match then intersection is null" {
        val list1 = Node(1, Node(2, Node(3)))
        val list2 = Node(4, Node(5, Node(6)))
        intersection(list1, list2 ) shouldBe null
    }
    "when list1 and list2 contain a matching node at the same position then inersection is the node" {
        val tailOfList = Node(10, Node(11, Node(12)))
        val list1 = Node(1, Node(2, tailOfList))
        val list2 = Node(3, Node(4, tailOfList))
        intersection(list1, list2) shouldBe tailOfList
    }
    "when list1 and list2 contain a matching node at an earlier position in list1 then inersection is the node" {
        val tailOfList = Node(10, Node(11, Node(12)))
        val list1 = Node(1, Node(2, tailOfList))
        val list2 = Node(3, Node(4, Node(5, tailOfList)))
        intersection(list1, list2) shouldBe tailOfList
    }
    "when list1 and list2 contain a matching node at an earlier position in list2 then inersection is the node" {
        val tailOfList = Node(10, Node(11, Node(12)))
        val list1 = Node(1, Node(2, Node(3, tailOfList)))
        val list2 = Node(4, Node(5, tailOfList))
        intersection(list1, list2) shouldBe tailOfList
    }
    "given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8" {
        val tailOfList = Node(8, Node(10))
        val list1 = Node(3, Node(7, tailOfList))
        val list2 = Node(99, Node(1, tailOfList))
        intersection(list1, list2)?.value shouldBe 8
    }
})