package september.september24

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec( {
    "if random number is 1 rand5 should return 1" {
        rand5{1} shouldBe 1
    }
    "if random number is 5 rand5 should return 5" {
        rand5{5} shouldBe 5
    }
    "if random number is 6 rand5 should return next number in the list less than 6"{
        var n = -1
        val rand7 = { n++; listOf(6,2)[n % 2] }
        rand5(rand7) shouldBe 2
    }
    "test 1000000 requests" {
        val result = (1..1000000).map{ august.august29.rand5()}
        (1000000.0/result.count{it == 1 } + 0.1).toInt() shouldBe 5
        (1000000.0/result.count{it == 2 } + 0.1).toInt() shouldBe 5
        (1000000.0/result.count{it == 3 } + 0.1).toInt() shouldBe 5
        (1000000.0/result.count{it == 4 } + 0.1).toInt() shouldBe 5
        (1000000.0/result.count{it == 5 } + 0.1).toInt() shouldBe 5
    }
})