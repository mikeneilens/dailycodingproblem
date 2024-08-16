package august.august13

import august.august13.encodeAsString
import august.august13.problem
import august.august13.toPairs
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    "[Pair<a,4>] encodes to 4a" {
        listOf(Pair('a',4)).encodeAsString() shouldBe "4a"
    }
    "[Pair<a,4>, Pair<12,b>] encodes to 4a12b" {
        listOf(Pair('a',4), Pair('b',12)).encodeAsString() shouldBe "4a12b"
    }
    "aaaa as a list of Pair<Char, Int> is [Pair('a',4)] " {
        "aaaa".toPairs() shouldBe listOf(Pair('a',4))
    }
    "aaaabbb as a list of Pair<Char, Int> is [Pair('a',4),Pair('b',3)] " {
        "aaaabbb".toPairs() shouldBe listOf(Pair('a',4), Pair('b',3))
    }
    "the string AAAABBBCCDAA is encoded as 4A3B2C1D2A" {
        problem("AAAABBBCCDAA") shouldBe "4A3B2C1D2A"
    }
})