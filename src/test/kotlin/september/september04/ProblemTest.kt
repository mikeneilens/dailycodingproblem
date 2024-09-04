package september.september04

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    "swap(1,4) applied to [1,2,3,4,5,6] results in [1,5,3,4,2,6]" {
        val list = mutableListOf(1,2,3,4,5,6)
        list.swap(1,4)
        list shouldBe mutableListOf(1,5,3,4,2,6)
    }
    "random swap position 2 with [1,2,3,4,5,6] with random number 4 results in [1,2,5,4,3,6] " {
        val list = mutableListOf(1,2,3,4,5,6)
        list.randomSwap(2, {4})
        list shouldBe mutableListOf(1,2,5,4,3,6)
    }
    "deck generator generates a deck of cards in sequence" {
        val deck = deckGenerator()
        deck.size shouldBe 52
        deck.joinToString(" ") shouldBe "AS 2S 3S 4S 5S 6S 7S 8S 9S TS JS QS KS AC 2C 3C 4C 5C 6C 7C 8C 9C TC JC QC KC AD 2D 3D 4D 5D 6D 7D 8D 9D TD JD QD KD AH 2H 3H 4H 5H 6H 7H 8H 9H TH JH QH KH"
    }
    "suffle a deck of cards " {
        val deck = problem()
        println(deck)
        (deck[0] == "AS") shouldBe false
    }

})