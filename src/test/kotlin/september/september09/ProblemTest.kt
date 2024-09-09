package september.september09

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    "if three vertexes and three colours and processing first vertex there are three candidate colours" {
        val vertexes = listOf(
            listOf(false, true, true),
            listOf(true, false, true),
            listOf(true, true, false)
        )
        val colours = setOf("red","green","blue")

        candidateColours(0, listOf(),vertexes, colours) shouldBe setOf("red","green","blue")
    }
    "if three vertexes and three colours and processing second vertex there are two candidate colours" {
        val vertexes = listOf(
            listOf(false, true, true),
            listOf(true, false, true),
            listOf(true, true, false)
        )
        val colours = setOf("red","green","blue")

        candidateColours(1, listOf("red"),vertexes, colours) shouldBe setOf("green","blue")
    }

    "if three vertexes and three colours and processing third vertex there is one candidate colour" {
        val vertexes = listOf(
            listOf(false, true, true),
            listOf(true, false, true),
            listOf(true, true, false)
        )
        val colours = setOf("red","green","blue")

        candidateColours(2, listOf("red","blue"),vertexes, colours) shouldBe setOf("green")
    }
    "if three vertexes and three colours there is a possible combination of colours" {
        val vertexes = listOf(
            listOf(false, true, true),
            listOf(true, false, true),
            listOf(true, true, false)
        )
        val colours = setOf("red","green","blue")

        addColour(0, listOf(),vertexes, colours).map{it.toSet()}.distinct() shouldBe
                listOf( setOf("red","green","blue") )
    }
    "if three vertexes and two colours there is no possible combination of colours" {
        val vertexes = listOf(
            listOf(false, true, true),
            listOf(true, false, true),
            listOf(true, true, false)
        )
        val colours = setOf("red","green")

        addColour(0, listOf(),vertexes, colours).map{it.toSet()}.distinct() shouldBe listOf()
    }
    "with four vertexes and three colours there is at least one possible combination of colours" {
        val vertexes = listOf(
            listOf(false, true, true, true),
            listOf(true, false, true, false),
            listOf(true, true, false, true),
            listOf(true, false, true, false)
        )
        val colours = setOf("red","green","blue")

        addColour(0, listOf(),vertexes, colours).first() shouldBe listOf("red", "green", "blue", "green")
    }
    "if three vertexes from the question and three colours there is a possible combination of colours" {
        val vertexes = listOf(
            listOf(false, true, true, true),
            listOf(true, false, true, false),
            listOf(true, true, false, true),
            listOf(true, false, true, false)
        )
        val colours = setOf("red","green","blue")

        problem(vertexes, colours) shouldBe listOf("red","green","blue","green")
    }

})