package august09

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec( {
    "when string contains x it parses into a regexitem.char('x')" {
        "x".parse() shouldBe listOf(RegexItem.Character('x'))
    }
    "when string contains . it parses into a regexitem.wildcard" {
        ".".parse() shouldBe listOf(RegexItem.Wildcard)
    }
    "when string contains x* it parses into a regexitem.repeat(regexitem.character('x'))" {
        "x*".parse() shouldBe listOf(RegexItem.Repeat(RegexItem.Character('x')))
    }
    "when string contains .* it parses into a regexitem.repeat(regexitem.wildcard)" {
        ".*".parse() shouldBe listOf(RegexItem.Repeat(RegexItem.Wildcard))
    }
    //not sure what this case should do
    "when string contains * it parses into an empty list" {
        "*".parse() shouldBe listOf()
    }
    //not sure what this case should do
    "when string contains ** it parses into a regexitem.repeat(regexitem.character('*'))" {
        "**".parse() shouldBe listOf(RegexItem.Repeat(RegexItem.Character('*')))
    }

    "when string contains abc and regex is abc then return true" {
        val regex = "abc".parse()
        problem("abc", regex) shouldBe true
    }
    "when string contains abc and regex is abcd then return false" {
        val regex = "abcd".parse()
        problem("abc", regex) shouldBe false
    }
    "when string contains abc and regex is ab then return false" {
        val regex = "ab".parse()
        problem("abc", regex) shouldBe false
    }
    "when string contains abc or adc and regex is a.c then return true" {
        val regex = "a.c".parse()
        problem("abc", regex) shouldBe true
        problem("adc", regex) shouldBe true
    }
    "when string contains abc and regex is ab*c then return true" {
        val regex = "ab*c".parse()
        problem("abc", regex) shouldBe true
    }
    "when string contains abbc and regex is ab*c then return true" {
        val regex = "ab*c".parse()
        problem("abbc", regex) shouldBe true
    }
    "when string contains abb and regex is ab* then return true" {
        val regex = "ab*".parse()
        problem("abb", regex) shouldBe true
    }
    "when string contains a and regex is ab* then return true" {
        val regex = "ab*".parse()
        problem("a", regex) shouldBe true
    }
    "when string contains anything and regex is .* then return true" {
        val regex = ".*".parse()
        problem("anything", regex) shouldBe true
    }
})