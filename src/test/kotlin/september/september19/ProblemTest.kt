package september.september19

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.doubles.shouldBeGreaterThan
import io.kotest.matchers.doubles.shouldBeLessThan

class ProblemTest: StringSpec({
    "test biased random numbers one or zero" {
        val onesOrZeros = (1..1000).map{biasedRandomOneOrZero()}
        val ratioOfZeros = 1.0 * onesOrZeros.count {it == 0} / onesOrZeros.size
        ratioOfZeros shouldBeGreaterThan 0.7
    }

    "test unbiased random coin" {
        val coins = (1..100000).map{ unBiasedCoin()}
        val ratioOfHeads = 1.0 * coins.count { it == "heads" } / coins.size
        println("ratio of heads is $ratioOfHeads")
        ratioOfHeads shouldBeGreaterThan 0.49
        ratioOfHeads shouldBeLessThan 0.51
    }

})