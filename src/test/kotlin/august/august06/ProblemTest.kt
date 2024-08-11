package august.august06

import august.august06.problem
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    "empty string should return empty list" {
        problem(dictionary= setOf(), string = "") shouldBe emptyList()
    }
    "string containing a and an empty set of words should return empty list" {
        problem(dictionary= setOf(), string = "a") shouldBe listOf()
    }
    "string containing a and set of words is [a] should return [[a]]" {
        problem(dictionary= setOf("a"), string = "a") shouldBe listOf(listOf("a"))
    }
    "string containing ab and set of words is [a] should return empty list because b isn't in the dictionary" {
        problem(dictionary= setOf("a"), string = "ab") shouldBe emptyList()
    }
    "string containing ab and set of words is [a,ab] should return [[ab]]" {
        problem(dictionary= setOf("a", "ab"), string = "ab") shouldBe listOf(listOf("ab"))
    }
    "string containing ab and set of words is [a,ab,b] should return [[a.b][ab]]" {
        problem(dictionary= setOf("a", "ab", "b"), string = "ab") shouldBe listOf(listOf("a","b"),listOf("ab"))
    }

    "string thequickbrownfox and set of words [quick, brown, the, fox] should return [[the, quick, brown, fox]]." {
        val words= setOf("quick", "brown", "the", "fox")
        problem(words, "thequickbrownfox") shouldBe listOf(listOf("the", "quick", "brown", "fox"))
    }
    "string thequickbrownfox and set of words [quick, brown, the] should return []." {
        val words= setOf("quick", "brown", "the")
        problem(words, "thequickbrownfox") shouldBe emptyList()
    }
    "string bedbathandbeyond and set of words [bed, bath, bedbath, and, beyond] return [[bed, bath, and, beyond],[bedbath, and, beyond]]" {
        val words = setOf("bed", "bath", "bedbath", "and", "beyond")
        problem(words, "bedbathandbeyond") shouldBe listOf(listOf("bed", "bath", "and", "beyond"), listOf("bedbath", "and", "beyond"))
    }
})