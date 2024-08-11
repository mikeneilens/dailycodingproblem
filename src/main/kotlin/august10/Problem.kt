package august10

//Given a singly linked list and an integer k, remove the kth last element from the list. k is guaranteed to be smaller than the length of the list.
//
//The list is very long, so making more than one pass is prohibitively expensive.
//
//Do this in constant space and in one pass.

class Node(val value:Int, var next:Node? = null)

fun problem(node:Node, k:Int):Node? {
    val nodeBeforeOneToRemove = kThFromLast(node, k + 1)
    if (nodeBeforeOneToRemove != null) {
        nodeBeforeOneToRemove.next = nodeBeforeOneToRemove.next?.next
        return node
    } else {
        return node.next
    }
}

fun kThFromLast(root:Node, k:Int, currentNode:Node = root, n:Int = 1, result:Node? = null):Node? {
    currentNode.next?.let{ next ->
        return if (n == k)
            kThFromLast(root, k , currentNode = next, n = n + 1, result = root)
        else
            kThFromLast(root, k , currentNode = next, n = n + 1, result = result?.next)

    } ?: return result
}