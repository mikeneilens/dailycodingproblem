package july18

//Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.
//
//For example, given the following Node class
//
//class Node:
//    def __init__(self, val, left=None, right=None):
//        self.val = val
//        self.left = left
//        self.right = right
//The following test should pass:
//
//node = Node('root', Node('left', Node('left.left')), Node('right'))
//assert deserialize(serialize(node)).left.left.val == 'left.left'

//This could be done by serialising/deserialising to/from json string using a framework like jackson but that may be cheating!

data class Node(val value:String, val left:Node? = null, val right:Node? = null) {
    fun serialise():String {
        return "Node(value='$value', left=${left?.serialise() ?: "null"}, right=${right?.serialise() ?: "null"})"
    }
}

fun String.deserialise() = Node(value = contentOfNode().valueOfNode(), left = contentOfNode().leftValueOfNode(),right = contentOfNode().rightValueOfNode())

fun String.contentOfNode():String {
    val increments = mapOf('(' to 1, ')' to -1 )
    var openBraces = 1
    var length = -1
    removePrefix("Node(").takeWhile {
        length++
        openBraces += increments[it] ?: 0
        openBraces != 0
    }
    return drop(5).take(length)
}

fun String.valueOfNode() = split(", ")[0].removePrefix("value='").dropLast(1)

fun String.startOfLeftValue() = valueOfNode().length + 15

fun String.startOfRightValue() =
    if (drop(startOfLeftValue()).startsWith("Node("))
        drop(startOfLeftValue()).contentOfNode().length + startOfLeftValue() + 14
    else
        startOfLeftValue() + 12

fun String.leftValueOfNode():Node? = drop(startOfLeftValue()).toNodeOrNull()

fun String.rightValueOfNode():Node? = drop(startOfRightValue()).toNodeOrNull()

private fun String.toNodeOrNull() = if (startsWith("Node(")) deserialise() else null

