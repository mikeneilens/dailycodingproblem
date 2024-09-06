package september.september06

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe

class ProblemTest: WordSpec( {
    "with a stack" should {
        "pushing 1 to stack results in 1 on top of the stack" {
            val stack = Stack<Int>()
            stack.push(1).topStackItem?.value shouldBe 1
            stack.topStackItem?.previous shouldBe null
        }
        "pushing 1,2 to stack results in 2 on top of the stack" {
            val stack = Stack<Int>()
            stack.push(1).push(2)
            stack.topStackItem?.value shouldBe 2
            stack.topStackItem?.previous shouldBe StackItem(1,null)
        }
        "popping from an empty stack gives null" {
            Stack<Int>().pop() shouldBe null
        }
        "pushing 1 to a stack and then popping it should give 1" {
            Stack<Int>().push(1).pop() shouldBe 1
        }
        "pushing 1 to a stack and then popping it twice should give null" {
            val stack = Stack<Int>().push(1)
            stack.pop()
            stack.pop() shouldBe null
        }
        "pushing 1,2 to a stack and then popping it should give 2" {
            Stack<Int>().push(1).push(2).pop() shouldBe 2
        }
        "pushing 1,2 to a stack and then popping it twice should give 1" {
            val stack = Stack<Int>().push(1).push(2)
            stack.pop()
            stack.pop() shouldBe 1
        }
        "pushing 1,2,3 to a stack and then transferring it results in a stack of 3,2,1" {
            val stack = Stack<Int>().push(1).push(2).push(3)
            val otherStack = Stack<Int>()
            stack.transferTo(otherStack)
            stack.topStackItem shouldBe null
            otherStack.pop() shouldBe 1
            otherStack.pop() shouldBe 2
            otherStack.pop() shouldBe 3
            otherStack.pop() shouldBe null
        }
    }

    "with a queue" should {
        "enqueuing 1 to an empty queue should result in 1 on the top of the queue" {
            val queue = Queue<Int>().enqueue(1)
            queue.topOfQueueValue() shouldBe 1
        }
        "enqueuing 1,2 to an empty queue should result in 2 on the top of the queue" {
            val queue = Queue<Int>().enqueue(1).enqueue(2)
            queue.topOfQueueValue() shouldBe 2
        }
        "enqueuing 1,2 to an empty queue and then de-queuing should return 1 and back of queue should contain 2" {
            val queue = Queue<Int>().enqueue(1).enqueue(2)
            queue.dequeue() shouldBe 1
            queue.backOfQueueValue() shouldBe 2
            queue.topOfQueue.isEmpty() shouldBe true
        }
        "enqueuing 1,2 to an empty queue and then de-queuing and then enqueuing 3 should result in top of queue of 3" {
            val queue = Queue<Int>().enqueue(1).enqueue(2)
            queue.dequeue()
            queue.enqueue(3)
            queue.topOfQueueValue() shouldBe 3
            queue.backOfQueue.isEmpty() shouldBe true
        }
    }
})