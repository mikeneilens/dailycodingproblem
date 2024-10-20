package october.october19

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({

    "permutations for array [1,2,3], return [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]] " {
        val a = mutableListOf(1, 2, 3)
        a.permutations().toSet() shouldBe setOf(listOf(1,2,3),listOf(2,1,3), listOf(3,1,2), listOf(1,3,2),listOf(2,3,1),listOf(3,2,1))
    }
    "permutations for set {1,2,3}" {
        val a = setOf(1,2,3)
        permutation(a).toSet() shouldBe setOf(listOf(1,2,3),listOf(2,1,3), listOf(3,1,2), listOf(1,3,2),listOf(2,3,1),listOf(3,2,1))
    }
    "permutations for set {1,2,3,4} shouldhave size 24" {
        val a = setOf("1","2","3","4")
        permutation(a).size shouldBe 24
    }
})