package october.october24

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    "check for primes" {
        isPrime(2) shouldBe true
        isPrime(3) shouldBe true
        isPrime(4) shouldBe false
        isPrime(5) shouldBe true
        isPrime(6) shouldBe false
        isPrime(7) shouldBe true
        isPrime(8) shouldBe false
        isPrime(9) shouldBe false
        isPrime(10) shouldBe false
        isPrime(11) shouldBe true
        isPrime(12) shouldBe false
        isPrime(13) shouldBe true
        isPrime(29) shouldBe true
        isPrime(35) shouldBe false
    }
    "prime sequence creator" {
        val nextPrime = NextPrime()
        nextPrime() shouldBe 2
        nextPrime() shouldBe 3
        nextPrime() shouldBe 5
        nextPrime() shouldBe 7
        nextPrime() shouldBe 11
        nextPrime() shouldBe 13
    }
    "primes for 4 is (2,2)" {
        problem(4) shouldBe Pair(2, 2)
    }
    "primes for 6 is (3,3)" {
        problem(6) shouldBe Pair(3, 3)
    }
    "primes for 8 is (3, 5)" {
        problem(8) shouldBe Pair(3, 5)
    }
    "primes for 10 is (3, 7)" {
        problem(10) shouldBe Pair(3, 7)
    }
    "primes for 12 is (5, 7)" {
        problem(12) shouldBe Pair(5, 7)
    }
})