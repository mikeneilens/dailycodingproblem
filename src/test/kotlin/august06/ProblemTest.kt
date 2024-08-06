package august06

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    "empty string should return null" {
        problem(dictionary= setOf(), string = "") shouldBe null
    }
    "string containing a and an empty set of words should return null" {
        problem(dictionary= setOf(), string = "a") shouldBe null
    }
    "string containing a and set of words is [a] should return [a]" {
        problem(dictionary= setOf("a"), string = "a") shouldBe listOf("a")
    }
    "string containing ab and set of words is [a] should return [a]" {
        problem(dictionary= setOf("a"), string = "ab") shouldBe listOf("a")
    }
    "string containing ab and set of words is [a,ab] should return [ab]" {
        problem(dictionary= setOf("a", "ab"), string = "ab") shouldBe listOf("ab")
    }
    "string containing ab and set of words is [a,ab,b] should return [ab]" {
        problem(dictionary= setOf("a", "ab", "b"), string = "ab") shouldBe listOf("ab")
    }
    "string thequickbrownfox and set of words [quick, brown, the, fox] should return [the, quick, brown, fox]." {
        val words= setOf("quick", "brown", "the", "fox")
        problem(words, "thequickbrownfox ") shouldBe listOf("the", "quick", "brown", "fox")
    }
    "string bedbathandbeyond and set of words [bed, bath, bedbath, and, beyond]" {
         val words = setOf("bed", "bath", "bedbath", "and", "beyond")
        problem(words, "bedbathandbeyond") shouldBe listOf("bedbath", "and", "beyond")
    }

})