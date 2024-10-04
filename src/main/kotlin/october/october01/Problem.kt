package october.october01

//Given k sorted singly linked lists, write a function to merge all the lists into one sorted singly linked list.


data class Node(val value:Int, var next:Node?) {
    fun toList(result:List<Int> = listOf()):List<Int> = next?.toList(result + value) ?: (result + value)
}

data class LinkedList(var firstNode:Node? = null, var lastNode:Node? = null)

fun merge(lists:List<LinkedList>, result:LinkedList = LinkedList() ):LinkedList {
    if (lists.isEmpty() || lists.all{it.firstNode == null}) return result
    val indexOfNodeToAdd = lists.mapIndexed{ i, l -> Pair(i,l)}.minBy { it.second.firstNode?.value ?: Int.MAX_VALUE }.first
    result.add(lists[indexOfNodeToAdd])
    return merge(lists, result)
}

fun LinkedList.add(other:LinkedList) {
    if (firstNode == null) {
        firstNode = other.firstNode
    } else {
        lastNode?.next = other.firstNode
    }
    lastNode = other.firstNode
    other.firstNode = other.firstNode?.next
    if (other.firstNode == null) other.lastNode = null
    lastNode?.next = null
}