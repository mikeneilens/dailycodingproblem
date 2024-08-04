package august04

//Given two singly linked lists that intersect at some point, find the intersecting node. The lists are non-cyclical.
//
//For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.
//
//In this example, assume nodes with the same value are the exact same node objects.
//
//Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.

data class Node(val value:Int, val next:Node? = null)

fun intersection(list1:Node?, list2:Node?, list1NodesFound:MutableSet<Node> = mutableSetOf(), list2NodesFound:MutableSet<Node> = mutableSetOf()):Node? = when {
    (list1 == list2 ) -> list1
    (list1 in list2NodesFound) -> list1
    (list2 in list1NodesFound) -> list2
    else -> {
        list1?.let{list1NodesFound.add(it)}
        list2?.let{list2NodesFound.add(it)}
        intersection(list1?.next, list2?.next, list1NodesFound, list2NodesFound)
    }
}