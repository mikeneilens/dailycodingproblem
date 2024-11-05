package november.november03

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    "empty word with empty string gives empty list" {
        problem(w = "", s = "") shouldBe listOf()
    }
    "empty word with string a gives empty list" {
        problem(w = "", s = "a") shouldBe listOf()
    }
    "word a with string a gives [0]" {
        problem(w = "a", s = "a") shouldBe listOf(0)
    }
    "string aba with word a gives [0,2]" {
        problem(w = "a", s = "aba") shouldBe listOf(0,2)
    }
    "string aba with word ab gives [0,1]" {
        problem(w = "ab", s = "aba") shouldBe listOf(0,1)
    }
    "string abxaba with word ab gives [0,1]" {
        problem(w = "ab", s = "abxaba") shouldBe listOf(0,3,4)
    }
})