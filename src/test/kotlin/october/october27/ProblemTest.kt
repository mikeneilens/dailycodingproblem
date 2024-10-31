package october.october27

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec( {
    "Node(1, next = Node(2,next = Node(3))) as a list is [1,2,3] " {
        Node('1', Node('2', Node('3'))).toList() shouldBe listOf('1','2','3')
    }
    "Node(3, prev = Node(2, prev = Node(1))) as a reversed list is [3,2,1]" {
        Node('3', prev = Node('2', prev = Node('1'))).toReversedList() shouldBe listOf('3','2','1')
    }
    "Linked list containing a,b,c,d,c,b,a is a palindrome" {
        val list = LinkedList<Char>()
            .add(Node('a'))
            .add(Node('b'))
            .add(Node('c'))
            .add(Node('d'))
            .add(Node('c'))
            .add(Node('b'))
            .add(Node('a'))
        list.isPalindrome() shouldBe true
    }
    "Linked list containing a,b,c,d,c,b is not a palindrome" {
        val list = LinkedList<Char>()
            .add(Node('a'))
            .add(Node('b'))
            .add(Node('c'))
            .add(Node('d'))
            .add(Node('c'))
            .add(Node('b'))
        list.isPalindrome() shouldBe false
    }

    " Pair([a],[a]) plus Pair([b],[b]) gives Pair([a,b], [b,a])" {
        Pair(listOf('a'), listOf('a')) + Pair(listOf('b'),listOf('b')) shouldBe Pair(listOf('a','b'), listOf('b','a'))
    }
    "Node(1, next = Node(2,next = Node(3))) as a list and reversed is ([1,2,3],[3,2,1])" {
        Node('1', Node('2', Node('3'))).toListAndReversedList() shouldBe Pair(listOf('1','2','3'),listOf('3','2','1'))
    }
    "Singly Linked list containing a,b,c,d,c,b,a is a palindrome" {
        val list = LinkedList(Node('a', Node('b', Node('c', Node('d', Node('c',Node('b',Node('a'))))))))
        list.isPalindromeSingleLink() shouldBe true
    }
    "Singly Linked list containing a,b,c,d,c,b is not a palindrome" {
        val list = LinkedList(Node('a', Node('b', Node('c', Node('d', Node('c',Node('b')))))))
        list.isPalindromeSingleLink() shouldBe false
    }
})