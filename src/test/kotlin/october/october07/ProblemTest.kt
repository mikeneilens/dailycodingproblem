package october.october07

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec( {
    "binary tree A [B, C] when inverted becomes A [C,B]" {
        val nodeB = Node("B")
        val nodeC = Node("C")
        val nodeA = Node("A", nodeB, nodeC)
        nodeA.inverted() shouldBe Node("A", nodeC, nodeB)
    }
    "binary tree A [B [D,E], C] when inverted becomes A [C, B [E, D]]" {
        val nodeD = Node("D")
        val nodeE = Node("E")
        val nodeB = Node("B", nodeD, nodeE)
        val nodeC = Node("C")
        val nodeA = Node("A", nodeB, nodeC)
        nodeA.inverted() shouldBe Node("A", nodeC, nodeB)
        nodeB shouldBe Node("B", nodeE, nodeD)
    }
    "binary tree A [B [D,E], C[F]] when inverted becomes A [C[F], B [E, D]]" {
        val nodeD = Node("D")
        val nodeE = Node("E")
        val nodeF = Node("F")
        val nodeB = Node("B", nodeD, nodeE)
        val nodeC = Node("C", nodeF)
        val nodeA = Node("A", nodeB, nodeC)
        nodeA.inverted() shouldBe Node("A", nodeC, nodeB)
        nodeB shouldBe Node("B", nodeE, nodeD)
        nodeC shouldBe Node("C", null, nodeF)
    }
})