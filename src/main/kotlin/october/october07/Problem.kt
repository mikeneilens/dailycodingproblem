package october.october07

//Invert a binary tree.
//
//For example, given the following tree:
//
//    a
//   / \
//  b   c
// / \  /
//d   e f
//should become:
//
//  a
// / \
// c  b
// \  / \
//  f e  d

data class Node(val s:String, var left:Node? = null, var right:Node? = null) {
    fun inverted():Node {
        left = right?.inverted().also{right = left?.inverted()}
        return this
    }
}