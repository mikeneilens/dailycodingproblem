package october.october04

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    "concatenating a list of [b,c,d] onto a list of [a] gives [ab, ac, ad]" {
        listOf("a").concat(listOf("b","c","d")) shouldBe listOf("ab","ac","ad")
    }
    "concatenating a list of [b,c,d] onto a list of [a,A] gives [ab, ac, ad, Ab, Ac, Ad]" {
        listOf("a","A").concat(listOf("b","c","d")) shouldBe listOf("ab","ac","ad","Ab","Ac","Ad")
    }
    "23 should return [ad, ae, af, bd, be, bf, cd, ce, cf]" {
        problem("23") shouldBe listOf("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")
    }
})