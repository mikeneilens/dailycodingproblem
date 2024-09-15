package september.september14

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    "power(0,4) returns 0" {
        power(0,4) shouldBe 0
    }
    "power(4,0) returns 1" {
        power(4,0) shouldBe 1
    }
    "power(4,1) return 4" {
        power(4,1) shouldBe 4
    }
    "power(4,4) return 256" {
        power(4,4) shouldBe 256
    }
    "power(4, 6) return 4096, memoizing power(4,3)" {
        val memo = newMemo()
        power(4, 6, memo) shouldBe 4096
        memo.get(4,3) shouldBe 64
    }
    "power(4, 5) return 1024" {
        power(4, 5) shouldBe 1024
    }
    "power(2,10)  returns 1024 which is power(2,5) * power(2,5) and power(2,5) is power(2,2) * power(2,3)" {
        val memo = newMemo()
        power(2,10, memo) shouldBe 1024
        memo shouldBe mutableMapOf(Pair(2,2) to 4, Pair(2,3) to 8, Pair(2,5) to 32, Pair(2,10) to 1024)
    }
})