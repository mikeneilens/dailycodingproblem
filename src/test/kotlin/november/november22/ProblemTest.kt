package november.november22

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    "evaluating 3 as the square root of 9 returns Matches" {
        createChecker(9) { (it * it).toInt() }(3.0) shouldBe Result.Matches
    }
    "evaluating 2 as the square root of 9 returns TooSmall" {
        createChecker(9) { (it * it).toInt() }(2.0) shouldBe Result.TooSmall
    }
    "evaluating 4 as the square root of 9 returns TooBig" {
        createChecker(9) { (it * it).toInt() }(4.0) shouldBe Result.TooBig
    }
    "binary search for 13 in a range of 100 gives 13" {
        binarySearch(0.0,100.0, createChecker(13)) shouldBe 13
    }
    "binary search for 53 in a range of 100 gives 53" {
        binarySearch(0.0,100.0, createChecker(53)) shouldBe 53
    }
    "square root of 4 is 2" {
        problem(4) shouldBe 2
    }
    "square root of 9 is 3" {
        problem(9) shouldBe 3
    }
    "square root of 7 is 3" {
        problem(7) shouldBe 3
    }
    "square root of 10 is 3" {
        problem(10) shouldBe 3
    }
    "square root of 15 is 4" {
        problem(15) shouldBe 4
    }
})