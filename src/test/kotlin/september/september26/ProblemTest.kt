package september.september26

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    "node(1).reversed becomes node(1) " {
        Node("1").reversed() shouldBe Node("1")
    }
    "node(1, node(2)).reversed becomes node(2, node(1)) " {
        Node("1", Node("2")).reversed() shouldBe Node("2", Node("1"))
    }
    "node(1, node(2, node(3))).reversed becomes node(3, node(2, node(1))) " {
        Node("1", Node("2", Node("3"))).reversed() shouldBe Node("3", Node("2", Node("1")))
    }
})