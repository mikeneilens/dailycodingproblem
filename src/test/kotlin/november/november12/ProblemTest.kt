package november.november12

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    "smallest set of numbers covering ranges [0,3] and [2,6] is {2}" {
        listOf(0..3, 2..6).minimumSetOfNumbers() shouldBe setOf(2)
    }
    "smallest set of numbers covering ranges [0,3], [2,6] and [3,4] is {3}" {
        listOf(0..3, 2..6, 3..4).minimumSetOfNumbers() shouldBe setOf(3)
    }
    "smallest set of numbers covering ranges [0,3], [2,6], [3,4], [6,9] is {3,6}" {
        listOf(0..3, 2..6, 3..4, 6..9).minimumSetOfNumbers() shouldBe setOf(3,6)
    }
})