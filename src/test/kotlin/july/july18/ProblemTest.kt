package july.july18

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import july.july18.*

class ProblemTest: StringSpec({

    "serialising a node should produce a valid string" {
        val node = Node("root", Node("left", Node("left.left")), Node("right"))
        node.serialise() shouldBe "Node(value='root', left=Node(value='left', left=Node(value='left.left', left=null, right=null), right=null), right=Node(value='right', left=null, right=null))"
    }
    "deserialising a node with Node(value='root', left=null, right=null) should create Node(value='root', left=null, right=null) " {
        val nodeString = "Node(value='root', left=null, right=null)"
        nodeString.deserialise() shouldBe Node(value = "root", left = null,right = null)
    }
    "contents of string Node(value='root', left=null, right=null) should be value='root', left=null, right=null"{
        "Node(value='root', left=null, right=null)".contentOfNode() shouldBe "value='root', left=null, right=null"
    }
    "value of node containing value='root', left=null, right=null should be 'root'" {
        val contentOfNode = "value='root', left=null, right=null"
        contentOfNode.valueOfNode() shouldBe "root"
    }
    "start of left value for value='root', left=null, right=null is position 24" {
        val nodeString = "value='root', left=null, right=null"
        nodeString.startOfLeftValue() shouldBe 19
    }
    "start of right value for Node(value='root', left=null, right=null) is position 36" {
        val nodeString = "value='root', left=null, right=null"
        nodeString.startOfRightValue() shouldBe 31
    }
    "start of right value for Node(value='root', left=left=Node(value='left', left=null, right=null), right=null) is position 28" {
        val nodeString = "value='root', left=Node(value='left', left=null, right=null), right=null"
        nodeString.startOfRightValue() shouldBe 68
    }
    "leftValue of node containing value='root', left=null, right=null should be null" {
        val contentOfNode = "Node(value='root', left=null, right=null)"
        contentOfNode.leftValueOfNode() shouldBe null
    }
    "rightValue of node containing value='root', left=null, right=null should be null" {
        val contentOfNode = "value='root', left=null, right=null"
        contentOfNode.rightValueOfNode() shouldBe null
    }
    "leftValue of node containing value='root', left=Node(value='left', left=null, right=null), right=null should be left" {
        val contentOfNode = "value='root', left=Node(value='left', left=null, right=null), right=null"
        contentOfNode.leftValueOfNode() shouldBe Node(value="left", left=null, right=null)
    }
    "rightValue of node containing value='root', left=null, right=Node(value='right', left=null, right=null) should be right" {
        val contentOfNode = "value='root', left=null, right=Node(value='right', left=null, right=null)"
        contentOfNode.rightValueOfNode() shouldBe Node(value="right", left=null, right=null)
    }
    "given node = Node('root', Node('left', Node('left.left')), Node('right')) node.serialise().deserialise().left?.left?.valu should give 'left.left" {
        val node = Node("root", Node("left", Node("left.left")), Node("right"))
        node.serialise().deserialise().left?.left?.value shouldBe "left.left"
    }
})