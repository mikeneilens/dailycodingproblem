package november.november24

//Given the head to a singly linked list,
// where each node also has a “random” pointer that points to anywhere in the linked list, deep clone the list.

class Node(val value:Int, var next:Node? = null, var other:Node? = null)

fun problem(node:Node?):Node? {
    val map = mutableMapOf<Node, Node>()
    return clone(node, map).apply { updateOther(this, map) }
}

fun clone(node:Node?, nodeMap:MutableMap<Node, Node>):Node? =
    node?.let{ Node(node.value,  clone(node.next, nodeMap), node.other).apply { nodeMap[node] = this }}

fun updateOther(node: Node?, nodeMap:MutableMap<Node, Node>) {
    if (node != null) node.other = nodeMap[node.other].also { updateOther(node.next, nodeMap) }
}