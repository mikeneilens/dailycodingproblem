package july26

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest:StringSpec( {
    val dictionary = createDictionary(listOfAnimals)
    "with an empty list of animals the dictionary is empty" {
        createDictionary(listOf()) shouldBe mapOf()
    }
    "with a list of ['a'] the dictionary is ('a' to ['a'])" {
        createDictionary(listOf("a")) shouldBe mapOf("a" to setOf("a"))
    }
    "with a list of ['ab'] the dictionary is ('a' to ['ab'],'ab to [ab]')" {
        createDictionary(listOf("ab")) shouldBe mapOf("a" to setOf("ab"),"ab" to setOf("ab"))
    }
    "with a list of ['ab','a'] the dictionary is ('a' to ['a','ab'],'ab' to ['ab'])" {
        createDictionary(listOf("ab","a")) shouldBe mapOf("a" to setOf("ab","a"),"ab" to setOf("ab"))
    }
    "with a list of ['Ab','ac'] the dictionary is ('a' to ['ac','Ab'],'ab' to ['Ab'],'ac' to ['ac'])" {
        createDictionary(listOf("Ab","ac")) shouldBe mapOf("a" to setOf("Ab","ac"),"ab" to setOf("Ab"),"ac" to setOf("ac"))
    }
    "autocomplete 'Do' with the long list of animals gives [Dodo, Dog, Dolphin, Donkey, Dory, Dove]  " {
        println(dictionary["Do"])
        autocomplete("do", dictionary) shouldBe listOf("Dodo", "Dog", "Dolphin", "Donkey", "Dory", "Dove")
    }
    "autocomplete 'Don' with the long list of animals gives Donkey" {
        println(dictionary["Don"])
        autocomplete("don", dictionary) shouldBe listOf("Donkey")
    }
})