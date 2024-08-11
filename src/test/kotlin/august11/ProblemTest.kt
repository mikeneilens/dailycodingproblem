package august11

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest:StringSpec({
    "removing brackets from an empty string gives an empty string" {
        "".removeMatchedBrackets() shouldBe ""
    }
    "removing brackets from '[]' gives an empty string" {
        "[]".removeMatchedBrackets() shouldBe ""
    }
    "removing brackets from '[{}]' gives an empty string" {
        "[{}]".removeMatchedBrackets() shouldBe ""
    }
    "removing brackets from '[' gives '['" {
        "[".removeMatchedBrackets() shouldBe "["
    }
    "removing brackets from '[(])' gives '[(])'" {
        "[(])".removeMatchedBrackets() shouldBe "[(])"
    }
    "removing brackets from '((()' gives '(('" {
        "((()".removeMatchedBrackets() shouldBe "(("
    }
    "remove brackets from '([])[]({})' gives an empty string" {
        "([])[]({})".removeMatchedBrackets() shouldBe ""
    }
    "empty string should return true" {
        problem("") shouldBe true
    }
    "([])[]({}) should return true" {
        problem("([])[]({})") shouldBe true
    }
    "[(]) should return false" {
        problem("[(])") shouldBe false
    }
    "((() should return false" {
        problem("((()") shouldBe false
    }

})