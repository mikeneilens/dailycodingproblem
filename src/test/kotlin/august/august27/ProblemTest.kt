package august.august27

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec( {
    "pushing 1 to a stack makes 1 the top of the stack" {
        val stack = Stack<Int>()
        stack.push(1).value() shouldBe 1
    }
    "pushing 1 and 2 to a stack makes 2 the top of the stack" {
        val stack = Stack<Int>()
        stack.push(1).push(2).value() shouldBe 2
    }
    "pushing 1 and 2 to a stack and popping once returns 2 and makes 1 the top of the stack" {
        val stack = Stack<Int>()
        stack.push(1).push(2).pop() shouldBe 2
        stack.value() shouldBe 1
    }
    "pushing 1 and 2 to a stack and popping twice returns 1 and makes null the top of the stack" {
        val stack = Stack<Int>()
        stack.push(1).push(2)
        stack.pop()
        stack.pop() shouldBe 1
        stack.value() shouldBe null
    }
    "pushing 1 and 2 to a stack and popping three times returns null and makes null the top of the stack" {
        val stack = Stack<Int>()
        stack.push(1).push(2)
        stack.pop()
        stack.pop()
        stack.pop() shouldBe null
        stack.value() shouldBe null
    }
    "an empty stack gives a max of null " {
        val stack = Stack<Int>()
        stack?.max() shouldBe null
    }
    "pushing 1 onto a stack gives a max of 1 " {
        val stack = Stack<Int>().push(1)
        stack?.max() shouldBe 1
    }
    "pushing 1,2 onto a stack gives a max of 2 " {
        val stack = Stack<Int>().push(1).push(2)
        stack?.max() shouldBe 2
    }
    "pushing 1,2,-1 onto a stack gives a max of 2 " {
        val stack = Stack<Int>().push(1).push(2).push(-1)
        stack?.max() shouldBe 2
    }
})