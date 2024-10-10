package october.october09

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    "empty string should return zero" {
        problem("") shouldBe 0
    }
    "() should return zero" {
        problem("()") shouldBe 0
    }
    "()() should return zero" {
        problem("()()") shouldBe 0
    }
    "(()) should return zero" {
        problem("(())") shouldBe 0
    }
    "( should return 1" {
        problem("(") shouldBe 1
    }
    ")( should return 2" {
        problem(")(") shouldBe 2
    }
    "()())() should return 1" {
        problem("()())()") shouldBe 1
    }
})