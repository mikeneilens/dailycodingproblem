package august03

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec( {
    val costGrid = listOf(
        listOf( 1,  2,  3),
        listOf( 8,  6,  3),
        listOf( 4,  4,  7),
        listOf( 5,  4,  8),
    )
    "with three colours and three houses, the house build will have colour 2 and cost of (1 + 3) " {
        val houses = listOf(
            House(houseNo = 0, colour = 0, costToGetHere = 1, costGrid = costGrid),
            House(houseNo = 0, colour = 1, costToGetHere = 2, costGrid = costGrid),
            House(houseNo = 0, colour = 2, costToGetHere = 3, costGrid = costGrid)
        )
        houses.addHouseToQueue() shouldBe listOf(
            House(houseNo = 0, colour = 1, costToGetHere = 2, costGrid = costGrid),
            House(houseNo = 0, colour = 2, costToGetHere = 3, costGrid = costGrid),
            House(houseNo = 1, colour = 2, costToGetHere = 4, costGrid = costGrid, previousHouses = listOf(houses[0])),
        )
    }
    "After the above, the next house to be built will have colour 2 and cost of (2 + 3" {
        val houses = listOf(
            House(houseNo = 0, colour = 1, costToGetHere = 2, costGrid = costGrid),
            House(houseNo = 0, colour = 2, costToGetHere = 3, costGrid = costGrid),
            House(houseNo = 1, colour = 2, costToGetHere = 4, costGrid = costGrid),
        )
        houses.addHouseToQueue() shouldBe listOf(
            House(houseNo = 0, colour = 2, costToGetHere = 3, costGrid = costGrid),
            House(houseNo = 1, colour = 2, costToGetHere = 4, costGrid = costGrid),
            House(houseNo = 1, colour = 2, costToGetHere = 5, costGrid = costGrid, previousHouses = listOf(houses[0])),
        )
    }
    "find result with test costGrid" {
        val result = problem(costGrid)
        result?.costToGetHere shouldBe 12
        result?.colour shouldBe 1
        result?.previousHouses?.size shouldBe 3
        result?.previousHouses?.get(0)?.colour shouldBe 0
        result?.previousHouses?.get(1)?.colour shouldBe 2
        result?.previousHouses?.get(2)?.colour shouldBe 0
    }
})