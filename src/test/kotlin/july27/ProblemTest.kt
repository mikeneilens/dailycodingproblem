package july27

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    "UniqueSteps when staircase has 1 step is [1]" {
        uniqueSteps(stairCaseSteps = 1) shouldBe setOf(listOf(1))
    }
    "given [[1]] and target steps of 2 nextSteps are [[1,1],[1,2]]" {
        listOf(listOf(1)).nextSteps(2, allowedSteps = listOf(1,2)) shouldBe listOf(listOf(1,1),listOf(1,2))
    }
    "given [[1,1],[1,2]] and target steps of 3 nextSteps are [[1,1,1],[1,1,2],[1,2]]" {
        listOf(listOf(1,1),listOf(1,2)).nextSteps(3, allowedSteps = listOf(1,2)) shouldBe listOf(listOf(1,1,1),listOf(1,1,2),listOf(1,2))
    }
    "given [[1,1,1],[1,1,2],[1,2]] and target steps of 3 nextSteps are [[1,1,1],[1,1,2],[1,2]]" {
        listOf(listOf(1,1,1),listOf(1,1,2),listOf(1,2)).nextSteps(3, allowedSteps = listOf(1,2)) shouldBe listOf(listOf(1,1,1),listOf(1,1,2),listOf(1,2))
    }
    "UniqueSteps when staircase has 2 steps is [[1,1],[2]]" {
        uniqueSteps(stairCaseSteps = 2).toSet() shouldBe setOf(listOf(1,1),listOf(2))
    }
    "UniqueSteps when staircase has 3 steps is [[1,2],[1,1,1],[2,1]]" {
        uniqueSteps(stairCaseSteps = 3).toSet() shouldBe setOf(listOf(1,2),listOf(1,1,1),listOf(2,1))
    }
    "UniqueSteps when staircase has 4 steps is [[1,1,1,1],[2,1,1],[1,2,1],[1,1,2],[2,2]]" {
        uniqueSteps(stairCaseSteps = 4).toSet() shouldBe setOf(listOf(1, 1, 1, 1),listOf(1, 1, 2),listOf(1, 2, 1),listOf(2, 1, 1),listOf(2, 2))
    }
    "UniqueSteps when staircase has 3 steps and allowed steps are [1,2,3] is [[1,1,1],[1,2],[2,1],[3]]" {
        uniqueSteps(stairCaseSteps = 3, allowedSteps = listOf(1,2,3)).toSet() shouldBe setOf(listOf(1,1,1),listOf(1,2),listOf(2,1),listOf(3))
    }
    "UniqueSteps when staircase has 1 steps and allowed steps are [2,3] is []" {
        uniqueSteps(stairCaseSteps = 1, allowedSteps = listOf(2,3)) shouldBe listOf()
    }
})