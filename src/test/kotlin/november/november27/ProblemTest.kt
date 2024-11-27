package november.november27

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    val node20 = Node(20)
    val node8 = Node(8)
    val node4 = Node(4)
    val node22 = Node(22)
    val node12 = Node(12)
    val node10 = Node(10)
    val node14 = Node(14)
    node20.apply{left = node8; right = node22}
    node8.apply{left = node4; right = node12}
    node12.apply{left = node10; right = node14}

    "inord successor of 1 is 4" {
        node20.inOrder(1) shouldBe 4
    }
    "inord successor of 4 is 8" {
        node20.inOrder(4) shouldBe 8
    }
    "inord successor of 8 is 10" {
        node20.inOrder(8) shouldBe 10
    }
    "inord successor of 10 is 12" {
        node20.inOrder(10) shouldBe 12
    }
    "inord successor of 14 is 20" {
        node20.inOrder(14) shouldBe 20
    }
    "inord successor of 15 is 20" {
        node20.inOrder(15) shouldBe 20
    }
    "inord successor of 21 is 22" {
        node20.inOrder(21) shouldBe 22
    }
    "inord successor of 22 is null" {
        node20.inOrder(22) shouldBe null
    }
    "test inord using sample" {
        val root = Node(10, Node(5), Node(30, Node(22), Node(35)))
        root.inOrder(22) shouldBe 30
    }

})