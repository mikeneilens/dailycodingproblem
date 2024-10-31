package october.october31

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    "empty string is equal to an empty string" {
        problem(a = "", b = "") shouldBe true
    }
    "empty string is not equal to A" {
        problem(a = "", b = "A") shouldBe false
    }
    "empty A is equal to A" {
        problem(a = "A", b = "A") shouldBe true
    }
    "empty AB is equal to BA" {
        problem(a = "AB", b = "BA") shouldBe true
    }
    "if A is abcde and B is cdeab, return true" {
        problem(a = "abcde", b = "cdeab") shouldBe true
    }
    "if A is abc and B is acb, return false" {
        problem(a = "abc", b = "acb") shouldBe false
    }

})