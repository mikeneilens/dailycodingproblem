package november.november27

//Given a node in a binary search tree, return the next bigger element, also known as the inorder successor.
//
//For example, the inorder successor of 22 is 30.
//
//   10
//  /  \
// 5    30
//     /  \
//   22    35

//(I've assumed we get given a value rather than a node)

data class Node(val value:Int, var left:Node? = null, var right:Node? = null) {

    fun lowestValue():Int = if (left == null) value else left?.lowestValue() ?: 0

    fun inOrder(target:Int, successor:Int? = null):Int? = when {
        (value == target && right != null) -> right?.lowestValue()
        (value > target ) -> left?.inOrder(target, value) ?: value
        else -> right?.inOrder(target, successor) ?: successor
    }
}
