package november.november02

//Given a binary tree, return all paths from the root to leaves.
//
//For example, given the tree:
//
//   1
//  / \
// 2   3
//    / \
//   4   5
//Return [[1, 2], [1, 3, 4], [1, 3, 5]].

fun problem(node:Node) = node.paths()

data class Node (val value:Int, var left:Node? = null, var right:Node? = null) {
    fun paths(path:List<Int> = listOf()):List<List<Int>> =
        if (left == null && right == null)
            listOf(path + value)
        else
            listOfNotNull(left, right).flatMap {node ->  node.paths(path + value) }
}
