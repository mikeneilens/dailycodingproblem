package september.september26

//Given the head of a singly linked list, reverse it in-place.

data class Node(val value:String, val next:Node? = null) {

    fun  reversed(previousNode:Node? = null):Node = next?.reversed( Node(value, previousNode)) ?: Node(value, previousNode )

}

