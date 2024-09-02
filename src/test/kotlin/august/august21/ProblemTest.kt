package august.august21

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec( {
    "power set of an empty set is a set of an empty set" {
        setOf<Int>().powerSet() shouldBe setOf(setOf())
    }
    "power set of [1] is a set of [[],[1]]" {
        setOf(1).powerSet() shouldBe setOf(setOf(), setOf(1))
    }
    "power set of [2] when output already contains [[],[1]] is [[],[1],[2],[1,2]] as 2 is added as a subset and added to each existing subset" {
        setOf(2).powerSet(setOf(setOf(), setOf(1))) shouldBe setOf(setOf(),setOf(1),setOf(2),setOf(1,2))
    }
    "power set of [1,2] is a set of [[],[1],[2],[1,2]]" {
        setOf(1,2).powerSet() shouldBe setOf(setOf(), setOf(1), setOf(2), setOf(1, 2))
    }
    "power set of [1,2,3] is a set of [[],[1],[2],[3],[1,2],[1,3],[2,3],[1,2,3]]" {
        setOf(1,2,3).powerSet() shouldBe setOf(setOf(), setOf(1), setOf(2), setOf(3), setOf(1, 2), setOf(1, 3), setOf(2,3), setOf(1, 2, 3))
    }
    "power set of [A,B,C,D] is a set of 16 subsets" {
        val powerSet = setOf("A", "B", "C", "D").powerSet()
        powerSet.size shouldBe 16
        (powerSet.contains(setOf("A","B","C","D")) ) shouldBe true
        (powerSet.contains(setOf("A","B","C")) ) shouldBe true
        (powerSet.contains(setOf("A","B")) ) shouldBe true
        (powerSet.contains(setOf("A")) ) shouldBe true
        (powerSet.contains(setOf()) ) shouldBe true
    }
})
