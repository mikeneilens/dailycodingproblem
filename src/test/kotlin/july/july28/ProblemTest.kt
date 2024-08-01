package july.july28

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import july.july28.longestString

class ProblemTest: StringSpec( {
    "with empty string longest string is an empty string" {
        longestString("",2) shouldBe ""
    }
    "with string a longest string is a" {
        longestString("a",2) shouldBe "a"
    }
    "with string aba longest string is aba" {
        longestString("aba",2) shouldBe "aba"
    }
    "with string aba longest string is abc" {
        longestString("abc",2) shouldBe "ab"
    }
    "with string abcba longest string is bcb" {
        longestString("abcba",2) shouldBe "bcb"
    }
    "with string abcba and k=3 longest string is abcba" {
        longestString("abcba",3) shouldBe "abcba"
    }
})