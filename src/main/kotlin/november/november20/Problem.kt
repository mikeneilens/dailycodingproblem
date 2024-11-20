package november.november20

//Let's represent an integer in a linked list format by having each node represent a digit in the number.
// The nodes make up the number in reversed order.
//
//For example, the following linked list:
//
//1 -> 2 -> 3 -> 4 -> 5
//is the number 54321.
//
//Given two linked lists in this format, return their sum in the same linked list format.
//
//For example, given
//
//9 -> 9
//5 -> 2
//return 124 (99 + 25) as:
//
//4 -> 2 -> 1

data class Node(val value:Int, val next: Node? = null)

fun Node?.plus(other: Node?, carry:Int = 0): Node? =
    if (this == null && other == null && carry == 0) null
    else Node(total(this, other, carry), this?.next.plus(other?.next, carry(this, other, carry)))

fun sum(node1:Node?, node2:Node?, carry:Int ) = ((node1?.value ?: 0) + (node2?.value ?: 0) + carry)

fun total(node1:Node?, node2:Node?, carry:Int ) = sum(node1, node2, carry) % 10

fun carry(node1:Node?, node2:Node?, carry:Int ) = sum(node1, node2, carry) / 10