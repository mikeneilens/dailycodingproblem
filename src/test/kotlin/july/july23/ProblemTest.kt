package july.july23

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import july.july23.Tree

class ProblemTest: StringSpec ({
    "tree with no children is a unival tree" {
        Tree(1).isUnivalTree() shouldBe true
    }
    "tree with one child is not a unival tree" {
        Tree(1, left = Tree(1)).isUnivalTree() shouldBe false
        Tree(1, right = Tree(1)).isUnivalTree() shouldBe false
    }
    "tree with both children with same value is a unival tree" {
        Tree(1, left = Tree(2), right = Tree(2)).isUnivalTree() shouldBe true
    }
    "tree with two children with different values is not a unival tree" {
        Tree(1, left = Tree(2), right = Tree(3)).isUnivalTree() shouldBe false
    }

    "tree with no children has one unival tree" {
        Tree(1).univalTrees() shouldBe 1
    }
    "tree with one child has one unival trees" {
        Tree(1, left = Tree(1)).univalTrees() shouldBe 1
    }
    "tree with two children with same value has three unival trees" {
        Tree(1, left = Tree(1), right = Tree(1)).univalTrees() shouldBe 3
    }
    "tree with two children with different value has two unival trees" {
        Tree(1, left = Tree(1), right = Tree(2)).univalTrees() shouldBe 2
    }
    "test the problem example" {
        val tree = Tree(0,
            left = Tree(1),
            right = Tree(0,
                left = Tree(1,
                    left = Tree(1),
                    right = Tree(1) ),
                right = Tree(0)
            )
        )
        tree.univalTrees() shouldBe 5
    }
})