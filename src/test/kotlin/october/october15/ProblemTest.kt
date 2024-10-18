package october.october15

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    "map [A:[B]] inverted should be [B:[A]]" {
        mapOf("A" to listOf("B")).inverted("") shouldBe mapOf("B" to listOf("A"))
    }
    "map [A:[B,C]] inverted should be [B:[A]],[C:[A]]"{
        mapOf("A" to listOf("B","C")).inverted("") shouldBe mapOf("B" to listOf("A"),"C" to listOf("A"))
    }
    "map [A:[B]],[C:[B]] inverted should be [B:[A,C]]" {
        mapOf("A" to listOf("B"), "C" to listOf("B")).inverted("") shouldBe mapOf("B" to listOf("A","C"))
    }
    "map [A:[]] inverted shouldBe [''':A]" {
        mapOf("A" to listOf<String>()).inverted("") shouldBe mapOf("" to listOf("A"))
    }

    "map['':[A,B],A:[B,C],C:[D],B:[C] gives possible courses of " {
        val courseMap = mapOf("" to listOf("A","B"), "A" to listOf("B","C"), "C" to listOf("D"), "B" to listOf("C"))
        courseMap.getPossibleCourses() shouldBe listOf(listOf("","A","B","C","D"), listOf("","A","C","D"), listOf("","B","C","D"))
    }
    "given {'CSC300': ['CSC100', 'CSC200'], 'CSC200': ['CSC100'], 'CSC100': []}, should return ['CSC100', 'CSC200', 'CSC300']" {
        val map = mapOf("CSC300" to listOf("CSC100", "CSC200"), "CSC200" to listOf("CSC100"), "CSC100" to listOf())
        problem(map) shouldBe listOf("CSC100", "CSC200", "CSC300")
    }
})

