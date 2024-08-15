package august15

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec( {
    "edit distance of kitten and sitting is 3" {
        val matrix = levenshteinFullMatrix("kitten", "sitting")
        matrix.get(5,6) shouldBe 3
    }
    "edit distance of sitting and kitten is 3" {
        val matrix = levenshteinFullMatrix("sitting", "kitten")
        matrix.get(6,5) shouldBe 3
    }
    "edit distance of cotton and sitting is 4" {
        problem("cotton","sitting") shouldBe 4
    }
})