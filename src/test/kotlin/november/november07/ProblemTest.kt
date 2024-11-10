package november.november07

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec( {
    "string a maps to [a]" {
        "a".toListOfDelimitersAndWords() shouldBe listOf("a")
    }
    "string ab maps to [ab]" {
        "ab".toListOfDelimitersAndWords() shouldBe listOf("ab")
    }
    "string ab| maps to [ab,|]" {
        "ab|".toListOfDelimitersAndWords() shouldBe listOf("ab","|")
    }
    "string |ab| maps to [|,ab,|]" {
        "|ab|".toListOfDelimitersAndWords() shouldBe listOf("|","ab","|")
    }
    "string |ab||cd maps to [|,ab,||,cd]" {
        "|ab||cd".toListOfDelimitersAndWords() shouldBe listOf("|","ab","||","cd")
    }
    "index of first word after 0 with [['a','b']] is 0" {
        listOf("ab").indexOfFirstWordAfter(0) shouldBe 0
    }
    "index of first word after 0 with [['|','|']] is 1" {
        listOf("||").indexOfFirstWordAfter(0) shouldBe 1
    }
    "index of first word after 0 with [['|','|'],['a','b']] is 1" {
        listOf("||", "ab").indexOfFirstWordAfter(0) shouldBe 1
    }
    "index of last word before 0 with [['a','b']] is 0" {
        listOf("ab").indexOfFirstWordBefore(0) shouldBe 0
    }
    "index of first word before 0 with [['|','|']] is -1" {
        listOf("||").indexOfFirstWordBefore(0) shouldBe -1
    }
    "index of first word before 1 with [['|','|'],['a','b']] is 1" {
        listOf("||", "ab").indexOfFirstWordBefore(1) shouldBe 1
    }
    "index of first word before 1 with [['c','d'],['|','|'],['a','b']] is 0" {
        listOf("cd", "||", "ab").indexOfFirstWordBefore(1) shouldBe 0
    }
    "hello/world:here should give here/world:hello" {
        problem("hello/world:here") shouldBe "here/world:hello"
    }
    "hello/world:here/ should give here/world:hello/" {
        problem("hello/world:here/") shouldBe "here/world:hello/"
    }
    "hello//world:here should give here//world:hello" {
        problem("hello//world:here") shouldBe "here//world:hello"
    }
}
)