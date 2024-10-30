package october.october30

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    "node(value = 1) as text is '1'" {
        Node(value = 1).toText() shouldBe "1"
    }
    "node(value = 1, left = node(value = 2) as text is '1, 2'" {
        Node(value = 1, left = Node(value = 2)).toText() shouldBe "1, 2"
    }
    "node(value = 1, right = node(value = 3) as text is '1, 3'" {
        Node(value = 1, right = Node(value = 3)).toText() shouldBe "1, 3"
    }
    "node(value = 1, left = node(value = 2), right = node(value = 3) as text is '1, 2, 3'" {
        Node(value = 1, left = Node(value = 2), right = Node(value = 3)).toText() shouldBe "1, 2, 3"
    }
    "node(value = 1, left = node(value = 2), right = node(value = 3, left = node(4), right = node(5) as text is '1, 2, 3, 4, 5'" {
        val node2 = Node(value = 2)
        val node3 = Node(value = 3, left = Node(value = 4), right = Node(value = 5))
        Node(value = 1, left = node2, right = node3).toText() shouldBe "1, 2, 3, 4, 5"
    }
})