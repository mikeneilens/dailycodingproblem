package september.september01

//Given pre-order and in-order traversals of a binary tree, write a function to reconstruct the tree.
//
//For example, given the following pre-order traversal:
//
//[a, b, d, e, c, f, g]
//
//And the following inorder traversal:
//
//[d, b, e, a, f, c, g]
//
//You should return the following tree:
//
//    a
//   / \
//  b   c
// / \ / \
//d  e f  g

data class Node(val value:Char, val left:Node? = null, val right:Node? = null )

fun buildNode(preOrder:List<Char>, inOrder:List<Char>):Node? {
    if (preOrder.isEmpty() ) return null
    val value = preOrder.first()
    val leftInOrder = leftInOrder(inOrder, value)
    val leftPreOrder = filterPreOrder(preOrder, leftInOrder)
    val rightInOrder =  rightInOrder(inOrder, value)
    val rightPreOrder = filterPreOrder(preOrder, rightInOrder)
    return Node(value, buildNode(leftPreOrder, leftInOrder), buildNode(rightPreOrder, rightInOrder) )
}

fun leftInOrder(inOrder: List<Char>, value:Char) = if (inOrder.indexOf(value) >= 0) inOrder.subList(0 , inOrder.indexOf(value)) else listOf()

fun rightInOrder(inOrder: List<Char>, value:Char) = if (inOrder.indexOf(value) >= 0) inOrder.subList(inOrder.indexOf(value) + 1, inOrder.size) else listOf()

fun filterPreOrder(preOrder: List<Char>, leftInOrder:List<Char>) = preOrder.filter{it in leftInOrder}


