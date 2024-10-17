package october.october15

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    "map [A:[B]] inverted should be [B:[A]]" {
        mapOf("A" to listOf("B")).inverted() shouldBe mapOf("B" to listOf("A"))
    }
    "map [A:[B,C]] inverted should be [B:[A]],[C:[A]]"{
        mapOf("A" to listOf("B","C")).inverted() shouldBe mapOf("B" to listOf("A"),"C" to listOf("A"))
    }
    "map [A:[B]],[C:[B]] inverted should be [B:[A,C]]" {
        mapOf("A" to listOf("B"), "C" to listOf("B")).inverted() shouldBe mapOf("B" to listOf("A","C"))
    }
    "map [A:[]] inverted shouldBe [''':A]" {
        mapOf("A" to listOf<String>()).inverted() shouldBe mapOf("" to listOf("A"))
    }
})

