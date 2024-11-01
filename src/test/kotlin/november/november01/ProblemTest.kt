package november.november01

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec( {
    "number 0 should produce binary 00 " {
        problem(0) shouldBe "00"
    }
    "number 1 should produce binary 10 " {
        problem(1) shouldBe "10"
    }
    "number 2 should produce binary 01 " {
        problem(2) shouldBe "01"
    }
    "number 3 should produce binary 11 " {
        problem(3) shouldBe "11"
    }
    "number 4 should produce binary 1000 " {
        problem(4) shouldBe "1000"
    }
    "number 5 should produce binary 1010 " {
        problem(5) shouldBe "1010"
    }
    "10101010 (170) should be 01010101" {
        problem(170) shouldBe "01010101"
    }
    "11100010 (226) should be 11010001" {
        problem(226) shouldBe "11010001"
    }
})