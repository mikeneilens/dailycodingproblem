package november.november06

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    "swapping 0 and 4 in mutable string abcde should give ebcda" {
        val mutableString = "abcde".toMutableList()
        mutableString.swap(0,4)
        mutableString shouldBe "ebcda".toList()
    }
    "reversing mutable string abcd should give dcba" {
        val mutableString = "abcd".toMutableList()
        mutableString.reverseInPlace()
        mutableString shouldBe "dcba".toList()
    }
    "reversing mutable string abcde should give edcba" {
        val mutableString = "abcde".toMutableList()
        mutableString.reverseInPlace()
        mutableString shouldBe "edcba".toList()
    }
    "reversing string 'the cat' should give 'cat the'" {
        val mutableString = "the cat".toMutableList()
        problem(mutableString)
        mutableString shouldBe "cat the".toList()
    }
    "reversing string 'hello world here' should give 'here world hello'" {
        val mutableString = "hello world here".toMutableList()
        problem(mutableString)
        mutableString shouldBe "here world hello".toList()
    }
    "reversing string 'hello world here' using simple solution should give 'here world hello'" {
        problemSimple("hello world here") shouldBe "here world hello"
    }
})