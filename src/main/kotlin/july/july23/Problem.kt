package july.july23

//An unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.
//
//Given the root to a binary tree, count the number of unival subtrees.
//
//For example, the following tree has 5 unival subtrees:
//
//   0
//  / \
// 1   0
//    / \
//   1   0
//  / \
// 1   1

class Tree (private val value:Int, var left: Tree? = null, var right: Tree? = null ) {
    fun isUnivalTree() = left?.value == right?.value

    fun univalTrees():Int = (if (isUnivalTree()) 1 else 0) + (left?.univalTrees() ?: 0) + (right?.univalTrees() ?: 0)
}