package august.august30

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec( {
    "max palindrome position 0 in string 'A' is 'A' " {
        maxPalindrome("A", 0) shouldBe "A"
    }
    "max palindrome position 0 in string 'AA' is 'AA' " {
        maxPalindrome("AA", 0) shouldBe "AA"
    }
    "max palindrome position 1 in string '1A2' is 'A' " {
        maxPalindrome("1A2", 1) shouldBe "A"
    }
    "max palindrome position 1 in string '1A1' is '1A1' " {
        maxPalindrome("1A1", 1) shouldBe "1A1"
    }
    "max palindrome position 1 in string '1AA2' is 'AA' " {
        maxPalindrome("1AA2", 1) shouldBe "AA"
    }
    "max palindrome position 1 in string '1AA1' is '1AA1' " {
        maxPalindrome("1AA1", 1) shouldBe "1AA1"
    }
    "biggest palindrome in aabcdcb is bcdcb " {
        problem("aabcdcb") shouldBe "bcdcb"
    }
    "biggest palindrome in bananas is anana " {
        problem("bananas") shouldBe "anana"
    }
    "biggest palindrome in aabbccddccbbcc is bbccddccbb " {
        problem("aabbccddccbbcc") shouldBe "bbccddccbb"
    }
})