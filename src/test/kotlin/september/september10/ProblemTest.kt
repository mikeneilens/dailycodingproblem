package september.september10

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    "length of last string in [] is zero" {
        listOf<String>().lengthOfLastString() shouldBe 0
    }
    "length of last string in ['abc'] is 3" {
        listOf("abc").lengthOfLastString() shouldBe 3
    }
    "length of last string in ['abc','ef'] is 2" {
        listOf("abc","ef").lengthOfLastString() shouldBe 2
    }
    "concatonate the last item of an array [] with 'def' gives ['def']" {
        listOf<String>().concatenateLastWith("def") shouldBe listOf("def")
    }
    "concatonate the last item of an array ['abc'] with 'def' gives ['abc def]" {
        listOf("abc").concatenateLastWith("def") shouldBe listOf("abc def")
    }
    "with string 'abc def' and k of 7 output is ['abc def']" {
        problem("abc def", 7) shouldBe listOf("abc def")
    }
    "with string 'abc def ghi' and k of 7 output is ['abc def','ghi']" {
        problem("abc def ghi", 7) shouldBe listOf("abc def", "ghi")
    }
    "with empty string output is null" {
        problem("", 7) shouldBe null
    }
    "with '123 12345678 1234' and k of 7 output is null" {
        problem("123 12345678 1234", 7) shouldBe null
    }
    "with string 'the quick brown fox jumps over the lazy dog' and k of 10 the output is ['the quick', 'brown fox', 'jumps over', 'the lazy', 'dog']"{
        problem("the quick brown fox jumps over the lazy dog", 10) shouldBe   listOf("the quick", "brown fox", "jumps over", "the lazy", "dog")
    }
})