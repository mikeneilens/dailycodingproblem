package september.september19

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.doubles.shouldBeGreaterThan
import io.kotest.matchers.doubles.shouldBeLessThan
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    "test biased random numbers one or zero" {
        val onesOrZeros = (1..1000).map{biasedRandomOneOrZero()}
        val ratioOfZeros = 1.0 * onesOrZeros.count {it == 0} / onesOrZeros.size
        ratioOfZeros shouldBeGreaterThan 0.7
    }
    "unbiased random gives heads if random number sequence is always 1,0" {
        var n = 0
        val biasedRandom = { listOf(1,0).get(n++).also { n = n % 2 } }
        (1..1000).map{unBiasedCoin(biasedRandom)}.all{it == "heads"} shouldBe true
    }
    "unbiased random gives tails if random number sequence is always 0,1" {
        var n = 0
        val biasedRandom = { listOf(0,1).get(n++).also { n = n % 2 } }
        (1..1000).map{unBiasedCoin(biasedRandom)}.all{it == "tails"} shouldBe true
    }
    "test unbiased random coin" {
        val coins = (1..100000).map{ unBiasedCoin()}
        val ratioOfHeads = 1.0 * coins.count { it == "heads" } / coins.size
        println("ratio of heads is $ratioOfHeads")
        ratioOfHeads shouldBeGreaterThan 0.49
        ratioOfHeads shouldBeLessThan 0.51
    }

})