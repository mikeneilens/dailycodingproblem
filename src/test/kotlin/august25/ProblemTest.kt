package august25

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec( {
    "with array [6, 1, 3, 3, 3, 6, 6] single integer is 1" {
        problem(listOf(6, 1, 3, 3, 3, 6, 6)) shouldBe 1
    }
    "with array [13, 19, 13, 13] single integer is 19" {
        problem(listOf(13, 19, 13, 13)) shouldBe 19
    }
})