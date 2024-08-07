package august07

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec( {

    val chartData = listOf(
        listOf(false, false, false, false),
        listOf(true, true, false, true),
        listOf(false, false, false, false),
        listOf(false, false, false, false))

    "parse [[true, false, true], [false, true, false]] should give set of [Position(1,0), Position(0,1),Position(2,1)]" {
        listOf(listOf(true, false, true), listOf(false, true, false)).toChart() shouldBe setOf(Position(
            0,
            1
        ),Position(1, 0), Position(1, 2))
    }
    "with start (0,3) and end (0,0) steps to end is 7" {
        problem(Position(3, 0), Position(0, 0), chartData) shouldBe 7
    }
})