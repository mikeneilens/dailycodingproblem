package september.september01

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest:StringSpec({
    "with order [d, b, e, a, f, c, g] and a, left in order is [d, b, e]" {
        val inOrder = listOf('d', 'b', 'e', 'a', 'f', 'c', 'g')
        leftInOrder(inOrder, 'a') shouldBe listOf('d', 'b','e')
    }

    "with preorder [a, b, d, e, c, f, g] and in order [d, b, e] new preorder is [b, d, e] " {
        val preOrder = listOf('a', 'b', 'd', 'e', 'c', 'f', 'g')
        val inOrder = listOf('b','d','e')
        filterPreOrder(preOrder, inOrder) shouldBe listOf('b','d','e')
    }

    "with order [d, b, e, a, f, c, g] and a, right in order is [f, c, g]" {
        val inOrder = listOf('d', 'b', 'e', 'a', 'f', 'c', 'g')
        rightInOrder(inOrder, 'a') shouldBe listOf('f', 'c','g')
    }

    "With pre-order [a, b, d, e, c, f, g] and in order [d, b, e, a, f, c, g], build a node" {
        val preOrder = listOf('a', 'b', 'd', 'e', 'c', 'f', 'g')
        val inOrder = listOf('d', 'b', 'e', 'a', 'f', 'c', 'g')
        buildNode(preOrder, inOrder) shouldBe Node(
            value =  'a',
            left = Node( value ='b', left = Node('d'), right = Node('e')),
            right = Node('c', left = Node('f'), right = Node('g')))
    }
})