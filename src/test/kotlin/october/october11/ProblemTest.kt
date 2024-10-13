package october.october11

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    "dividing 0 by 2 gives 0" {
        (0 div 2) shouldBe 0
    }
    "dividing 5 by 2 gives 2" {
        (5 div 2) shouldBe 2
    }
    "dividing 100 by 3 gives 33" {
        (100 div 3) shouldBe 33
    }
    "dividing 100 by -3 gives -33" {
        (100 div -3) shouldBe  -33
    }
    "dividing -100 by 3 gives -33" {
        (-100 div 3) shouldBe  -33
    }
    "dividing -100 by -3 gives 33" {
        (-100 div -3) shouldBe  33
    }
    "dividig 1 by 0 throws an error" {
        shouldThrowExactly<ArithmeticException> {
            1 div 0
        }
    }
})