package october.october26

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    "when searching from position 1 ABCDEF contains {B,E} in substring BCDE" {
        "ABCDEF".substringContaining(setOf('B','E'),1) shouldBe "BCDE"
    }
    "when searching from position 2 ABCDEF does not contain {B,E} so returns null" {
        "ABCDEF".substringContaining(setOf('B','E'),2) shouldBe null
    }

    "when search ABCDEFABCDF for set {D,F} return [DEF, DF]" {
        "ABCDEFABCDF".allSubstringsContaining(setOf('D','F')) shouldBe listOf("DEF", "FABCD", "DF")
    }

    "shortest substring containing {D,f} in ABCDEFABCD should be DF" {
        problem("ABCDEFABCDF", setOf('D','F')) shouldBe "DF"
    }
    "given the string figehaeci and the set of characters {a, e, i}, you should return aeci" {
        problem("figehaeci", setOf('a', 'e', 'i')) shouldBe "aeci"
    }
})