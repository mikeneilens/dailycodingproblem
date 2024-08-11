package august.august08

import august.august08.Node
import august.august08.Status
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec( {
    "when a node has no ancestors its ancestors are locked" {
        val node = Node(1, ancestor = null)
        node.ancestorsAreLocked() shouldBe true
    }
    "when a node has an ancestor which is locked then its ancestors are locked" {
        val node = Node(1, ancestor = Node(2, status = Status.Locked))
        node.ancestorsAreLocked() shouldBe true
    }
    "when a node has an ancestor which is unlocked then its ancestors are not locked" {
        val node = Node(1, ancestor = Node(2, status = Status.Unlocked))
        node.ancestorsAreLocked() shouldBe false
    }
    "when a node has an ancestor which is locked which also has an ancestor which is locked then its ancestors are locked" {
        val node = Node(1, ancestor = Node(2, status = Status.Locked, ancestor = Node(3, status = Status.Locked)))
        node.ancestorsAreLocked() shouldBe true
    }
    "when a node has an ancestor which is locked which also has an ancestor which is unlocked then its ancestors are not locked" {
        val node = Node(1, ancestor = Node(2, status = Status.Locked, ancestor = Node(3, status = Status.Unlocked)))
        node.ancestorsAreLocked() shouldBe false
    }
    "when a node has a right which is locked then its right is locked" {
        val node = Node(1, right = Node(2, status = Status.Locked))
        node.rightIsLocked() shouldBe true
    }
    "when a node has a right which is unlocked then its right is unlocked" {
        val node = Node(1, right = Node(2, status = Status.Unlocked))
        node.rightIsLocked() shouldBe false
    }
    "when a node has a right which is locked which also has a descendant which is locked then its right is locked" {
        val node = Node(1, right = Node(2, status = Status.Locked, right = Node(3, status = Status.Locked)))
        node.rightIsLocked() shouldBe true
    }
    "when a node has a right which is locked which also has a descendant which is unlocked then its right are not locked" {
        val node = Node(1, right = Node(2, status = Status.Locked, right = Node(3, status = Status.Unlocked)))
        node.rightIsLocked() shouldBe false
    }
    "when a node has a left which is locked then its left is locked" {
        val node = Node(1, left = Node(2, status = Status.Locked))
        node.leftIsLocked() shouldBe true
    }
    "when a node has a left which is unlocked then its left is unlocked" {
        val node = Node(1, left = Node(2, status = Status.Unlocked))
        node.leftIsLocked() shouldBe false
    }
    "when a node has a left which is locked which also has a descendant which is locked then its left is locked" {
        val node = Node(1, left = Node(2, status = Status.Locked, left = Node(3, status = Status.Locked)))
        node.leftIsLocked() shouldBe true
    }
    "when a node has a left which is locked which also has a descendant which is unlocked then its left are not locked" {
        val node = Node(1, left = Node(2, status = Status.Locked, left = Node(3, status = Status.Unlocked)))
        node.leftIsLocked() shouldBe false
    }
    "when a node has an ancestor which is locked and a descendant which is unlocked then ancestors and descendants are not locked" {
        val node = Node(1, ancestor = Node(2, status = Status.Locked), left= Node(3, status = Status.Unlocked))
        node.ancestorsAndDescendantsAreLocked() shouldBe false
    }
    "when a node has an ancestor which is unlocked and a descendant which is locked then ancestors and descendants are not locked" {
        val node = Node(1, ancestor = Node(1, status = Status.Unlocked), left= Node(1, status = Status.Locked))
        node.ancestorsAndDescendantsAreLocked() shouldBe false
    }
    "when a node has an ancestor which is locked and a descendant which is locked then ancestors and descendants are not locked" {
        val node = Node(1, ancestor = Node(1, status = Status.Locked), left= Node(1, status = Status.Locked))
        node.ancestorsAndDescendantsAreLocked() shouldBe true
    }
    "when a node has an ancestor which is unlocked and a descendant which is locked then status cannot be changed to locked" {
        val node = Node(1, status = Status.Unlocked, ancestor = Node(1, status = Status.Unlocked), left= Node(1, status = Status.Locked))
        node.lock() shouldBe false
        node.status shouldBe Status.Unlocked
    }
    "when a node has an ancestor which is locked and a descendant which is locked then status can be changed to locked" {
        val node = Node(1, status = Status.Unlocked, ancestor = Node(1, status = Status.Locked), left= Node(1, status = Status.Locked))
        node.lock() shouldBe true
        node.status shouldBe Status.Locked
    }
    "when a node has an ancestor which is unlocked and a descendant which is locked then status cannot be changed to unlocked" {
        val node = Node(1, status = Status.Locked, ancestor = Node(1, status = Status.Unlocked), left= Node(1, status = Status.Locked))
        node.unlock() shouldBe false
        node.status shouldBe Status.Locked
    }
    "when a node has an ancestor which is locked and a descendant which is locked then status can be changed to unlocked" {
        val node = Node(1, status = Status.Locked, ancestor = Node(1, status = Status.Locked), left= Node(1, status = Status.Locked))
        node.unlock() shouldBe true
        node.status shouldBe Status.Unlocked
    }
})