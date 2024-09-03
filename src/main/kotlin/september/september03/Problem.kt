package september.september03

//Suppose an arithmetic expression is given as a binary tree.
// Each leaf is an integer and each internal node is one of '+', '−', '∗', or '/'.
//
//Given the root to such a tree, write a function to evaluate it.
//
//For example, given the following tree:
//
//    *
//   / \
//  +    +
// / \  / \
//3  2  4  5
//You should return 45, as it is (3 + 2) * (4 + 5).

sealed interface Node {
    fun evaluate():Int
}

class Plus(val left: Node, val right: Node) :Node {
    override fun evaluate() = left.evaluate() + right.evaluate()
}
class Minus(val left: Node, val right: Node) :Node {
    override fun evaluate() = left.evaluate() - right.evaluate()
}
class Times(val left: Node, val right: Node) :Node {
    override fun evaluate() = left.evaluate() * right.evaluate()
}
class Divide(val left: Node, val right: Node) :Node {
    override fun evaluate() = left.evaluate() / right.evaluate()
}
class Leaf(val value: Int) :Node {
    override fun evaluate() = value
}