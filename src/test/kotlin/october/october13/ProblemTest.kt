package october.october13

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    "for n = 5 and l of [3,2,8] creating a set of range excluding l gives set of {0,1,4}" {
        rangeExcludingList(5, listOf(3,2,8)) shouldBe setOf(0,1,4)
    }
    "for n = 5 and l of [] and random that picks 3,2,1,0 then results first 3 results should be 3,2,1" {
        var i = 0
        val entries = listOf(3,2,1,0)
        fun List<Int>.testRandom() = get(entries[i++])

        problem(5, emptyList(),List<Int>::testRandom) shouldBe 3
        problem(5, emptyList(),List<Int>::testRandom) shouldBe 2
        problem(5, emptyList(),List<Int>::testRandom) shouldBe 1
        problem(5, emptyList(),List<Int>::testRandom) shouldBe 0
    }
    "for n = 5 and l of [3,2,8] and random that picks 2,1,0,2 then first 4 results should be 4,1,0,4" {
        var i = 0
        val entries = listOf(2,1,0,2)
        fun List<Int>.testRandom() = get(entries[i++])

        problem(5, listOf(3,2,8),List<Int>::testRandom) shouldBe 4
        problem(5, listOf(3,2,8),List<Int>::testRandom) shouldBe 1
        problem(5, listOf(3,2,8),List<Int>::testRandom) shouldBe 0
        problem(5, listOf(3,2,8),List<Int>::testRandom) shouldBe 4
    }
    "volume test n = 5 and l of [3,2,8]" {
        val results = (1..100000).map{problem(5, listOf(3,2,8))}
        results.count { it == 0 } shouldBeInRange 33000..34000
        results.count { it == 1 } shouldBeInRange 33000..34000
        results.count { it == 2 } shouldBe 0
        results.count { it == 3 } shouldBe 0
        results.count { it == 4 } shouldBeInRange 33000..34000
    }
})