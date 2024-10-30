package october.october30

//Print the nodes in a binary tree level-wise. For example, the following should print 1, 2, 3, 4, 5.
//
//  1
// / \
//2   3
//   / \
//  4   5

data class Node(val value:Int, val left:Node? = null, val right:Node? = null) {
    fun toText() = "$value${left.subTreeText()}${right.subTreeText()}"
}

fun Node?.subTreeText():String = this?.let{ ", ${it.toText()}" } ?: ""