package august12

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    "if list is [fox] and k is 16 then list of rows if [[fox]]" {
        listOf("fox").createRows(16) shouldBe listOf(listOf("fox"))
    }
    "if list is [the, quick, brown] and k is 16 then list of rows if [[the, _quick, _brown]]" {
        listOf("the", "quick", "brown").createRows(16) shouldBe listOf(listOf("the", " quick", " brown"))
    }
    "if list is [the, quick, brown, fox] and k is 16 then list of rows if [[the, _quick, _brown],[fox]]" {
        listOf("the", "quick", "brown","fox").createRows(16) shouldBe listOf(listOf("the", " quick", " brown"), listOf("fox"))
    }
    "if list is [the _quick _brown] adding padding to word 0 gives [the _quick _brown]" {
        listOf("the", " quick", " brown").addPadding(0) shouldBe listOf("the", " quick", " brown")
    }
    "if list is [the _quick _brown] adding padding to word 1 gives [the __quick _brown]" {
        listOf("the", " quick", " brown").addPadding(1) shouldBe listOf("the", "  quick", " brown")
    }
    "if list is [the _quick _brown] adding padding to word 2 gives [the _quick __brown]" {
        listOf("the", " quick", " brown").addPadding(2) shouldBe listOf("the", " quick", "  brown")
    }
    "if list is [the _quick _brown] adding padding to word 3 gives [the _quick _brown]" {
        listOf("the", " quick", " brown").addPadding(3) shouldBe listOf("the", " quick", " brown")
    }
    "if list is [the _quick _brown] adding padding to word 4 gives [the __quick _brown]" {
        listOf("the", " quick", " brown").addPadding(4) shouldBe listOf("the", "  quick", " brown")
    }
    "if row is [the _quick _brown] adding padding to the row for size 15 gives [the _quick _brown]" {
        listOf("the", " quick", " brown").padRow(15) shouldBe listOf("the", " quick", " brown")
    }
    "if row is [the _quick _brown] adding padding to the row for size 16 gives [the __quick _brown]" {
        listOf("the", " quick", " brown").padRow(16) shouldBe listOf("the", "  quick", " brown")
    }
    "if row is [the _quick _brown] adding padding to the row for size 17 gives [the __quick __brown]" {
        listOf("the", " quick", " brown").padRow(17) shouldBe listOf("the", "  quick", "  brown")
    }
    "given the list of words [the, quick, brown, fox, jumps, over, the, lazy, dog] and k = 16 the answer should match the comments" {
        val words = listOf("the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog")
        problem(words, 16) shouldBe listOf(
            "the  quick brown",
            "fox  jumps  over",
            "the   lazy   dog"
        )
    }
})