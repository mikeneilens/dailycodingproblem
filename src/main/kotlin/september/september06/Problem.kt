package september.september06

//Implement a queue using two stacks. Recall that a queue is a FIFO (first-in, first-out) data structure
// with the following methods: enqueue, which inserts an element into the queue, and dequeue, which removes it.

data class StackItem<E>(val value: E, var previous: StackItem<E>?)

data class Stack<E>(var topStackItem: StackItem<E>? = null) {
    fun push(value :E) :Stack<E>{
        topStackItem = StackItem(value, topStackItem)
        return this
    }
    fun pop():E? = topStackItem?.let {
            topStackItem = it.previous
            it.value
        }

    fun isEmpty() = topStackItem == null

    fun transferTo(other: Stack<E>) :Stack<E> {
        while (topStackItem != null) {
            pop()?.let{ other.push(it) }
        }
        return other
    }
}

data class Queue<E>(val topOfQueue: Stack<E> = Stack(), val backOfQueue: Stack<E> = Stack()) {
    fun enqueue(value: E) :Queue<E> {
        if (topOfQueue.isEmpty()) backOfQueue.transferTo(topOfQueue).push(value) else topOfQueue.push(value)
        return this
    }
    fun dequeue() = if (backOfQueue.isEmpty()) topOfQueue.transferTo(backOfQueue).pop() else backOfQueue.pop()

    fun topOfQueueValue() = topOfQueue.topStackItem?.value

    fun backOfQueueValue() = backOfQueue.topStackItem?.value
}