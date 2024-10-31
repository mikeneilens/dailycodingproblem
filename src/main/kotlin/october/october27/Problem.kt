package october.october27

//Determine whether a doubly linked list is a palindrome. What if it’s singly linked?
//
//For example, 1 -> 4 -> 3 -> 4 -> 1 returns True while 1 -> 4 returns False.

data class Node<E>(val value:E, var next:Node<E>? = null,var prev:Node<E>? = null ) {
    fun toList():List<E> = listOf(value) + (next?.toList() ?: listOf())

    fun toReversedList():List<E> =
        listOf(value) + (prev?.toReversedList() ?: listOf())

    fun toListAndReversedList():Pair<List<E>, List<E>> {
        return Pair(listOf(value), listOf(value)) + (next?.toListAndReversedList() ?: Pair(listOf(),listOf()))
    }
}

operator fun <E>Pair<List<E>, List<E>>.plus(other:Pair<List<E>,List<E>>) = Pair(this.first + other.first, other.second + this.second )

data class LinkedList<E>(var firstNode:Node<E>? = null, var lastNode:Node<E>? = null) {
    fun add(node:Node<E>) = if (firstNode == null) {
        firstNode = node
        lastNode =node
        this
    } else {
        lastNode?.next = node
        node.prev = lastNode
        lastNode = node
        this
    }
    fun isPalindrome() =
        firstNode?.toList() == lastNode?.toReversedList()

    fun isPalindromeSingleLink():Boolean{
      val (list, reversedList) =  firstNode?.toListAndReversedList() ?: Pair(listOf(),listOf())
      return list == reversedList
    }
}