package august.august25

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec( {
    "if last flights taken are [(a,b),(b,c)] and possible flights are [(a,b),(b,c),(c,d),(c,e),(d,c)] possible flights are [(c,d),(c,e)]" {
        val flightsTaken = listOf(Flight("a","b"), Flight("b","c"))
        val allFlights = listOf(Flight("a","b"), Flight("b","c"), Flight("c","d"), Flight("c","e"), Flight("d","c"))
        allFlights.possibleNextFlights(flightsTaken,"c") shouldBe listOf(Flight("c","d"), Flight("c","e"))
    }

    "given possible flights ('A', 'B'), ('A', 'C'), ('B', 'C'), ('C', 'A') and starting location 'A' " +
            "possible flights are [('A', 'B'), ('B','C'), ('C','A'), ('A','C')] " +
            "and [('A','C'), ('C','A'), ('A','B'), ('B', 'C')]" {

                val flightsTaken = listOf<Flight>()
                val allFlights = listOf(Flight("A", "B"), Flight("A", "C"), Flight("B", "C"), Flight("C", "A"))
                findFlight(allFlights, flightsTaken,"A") shouldBe listOf(
                    listOf(Flight("A","B"), Flight("B","C"), Flight("C","A"), Flight("A","C")),
                    listOf(Flight("A","C"), Flight("C","A"), Flight("A","B"), Flight("B","C")),
                )
            }
    "Flights ('A', 'B'), ('B','C'), ('C','A'), ('A','C') as destinations is ['A','B','C','A','C']" {
        listOf(Flight("A","B"), Flight("B","C"), Flight("C","A"), Flight("A","C")).toLocations() shouldBe
                listOf("A","B","C","A","C")
    }

    "given possible flights ('A', 'B'), ('A', 'C'), ('B', 'C'), ('C', 'A') and starting location of 'A' " +
            "flights are ['A', 'B', 'C', 'A', 'C'] " {
                val allFlights = listOf(Flight("A", "B"), Flight("A", "C"), Flight("B", "C"), Flight("C", "A"))
                problem(allFlights,"A") shouldBe listOf("A","B","C","A","C")
            }
    "given possible flights ('SFO', 'HKO'), ('YYZ', 'SFO'), ('YUL', 'YYZ'), ('HKO', 'ORD') and starting location of 'YUL' " +
            "flights are ['YUL', 'YYZ', 'SFO', 'HKO', 'ORD'] " {
                val allFlights = listOf(
                    Flight("SFO", "HKO"),
                    Flight("YYZ", "SFO"), Flight("YUL", "YYZ"), Flight("HKO", "ORD")
                )
                problem(allFlights,"YUL") shouldBe listOf("YUL","YYZ","SFO","HKO","ORD")
            }
    "given possible flights ('SFO', 'COM'), ('COM', 'YYZ') and starting location of 'COM' " +
            "flights are null " {
                val allFlights = listOf(Flight("SFO", "COM"), Flight("COM", "YYZ"))
                problem(allFlights,"COM") shouldBe null
            }
})