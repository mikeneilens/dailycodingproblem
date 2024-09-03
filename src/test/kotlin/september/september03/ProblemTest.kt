package september.september03

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest:StringSpec({
    "Leaf(1) evaluates to 1" {
        Leaf(1).evaluate() shouldBe 1
    }
    "Plus(Leaf(1), Leaf(2)) evaluates to 3" {
        Plus(Leaf(1), Leaf(2)).evaluate() shouldBe 3
    }
    "Minus(Leaf(1), Leaf(2)) evaluates to -1" {
        Minus(Leaf(1), Leaf(2)).evaluate() shouldBe -1
    }
    "Times(Leaf(3), Leaf(2)) evaluates to 6" {
        Times(Leaf(3), Leaf(2)).evaluate() shouldBe 6
    }
    "Divide(Leaf(39), Leaf(3)) evaluates to 13" {
        Divide(Leaf(39), Leaf(3)).evaluate() shouldBe 13
    }
    "With the example the result is 45" {
        Times(Plus(Leaf(3),Leaf(2)),
              Plus(Leaf(4),Leaf(5))).evaluate() shouldBe 45
    }
})