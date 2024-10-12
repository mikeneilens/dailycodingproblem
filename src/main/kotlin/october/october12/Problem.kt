package october.october12

//Determine whether a tree is a valid binary search tree.
//
//A binary search tree is a tree with two children, left and right, and satisfies the constraint that the key in the
// left child must be less than or equal to the root and the key in the right child must be greater than or equal to
// the root.

data class Node(val value:Int, var left:Node? = null, var right:Node? = null) {

    fun isValid():Boolean = (left?.let(::validLeft) ?: true) && (right?.let(::validRight) ?: true)

    fun validRight(left: Node) = left.value >= value && left.isValid()

    fun validLeft(right: Node) = right.value <= value && right.isValid()

}

