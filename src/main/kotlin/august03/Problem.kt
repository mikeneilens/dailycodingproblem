package august03
//A builder is looking to build a row of N houses that can be of K different colors. He has a goal of minimizing cost while ensuring that no two neighboring houses are of the same color.
//
//Given an N by K matrix where the nth row and kth column represents the cost to build the nth house with kth color, return the minimum cost which achieves this goal.

typealias CostGrid = List<List<Int>>

val CostGrid.choiceOfColours get() = 0..first().lastIndex
val CostGrid.noOfHouses get() = lastIndex

data class House(val houseNo:Int, val colour:Int, val costToGetHere:Int, val previousHouses:List<House> = listOf(), val costGrid:CostGrid):Comparable<House> {
    fun isLastHouse() = houseNo == costGrid.noOfHouses

    //next house is one that is not the same colour and cheapest to build
    fun nextHouse() =
        costGrid.choiceOfColours
            .filter{it != colour}
            .map{House( houseNo + 1, it, costToGetHere + costGrid[houseNo + 1][it], previousHouses + this, costGrid )}.sorted().first()

    override fun compareTo(other: House) = costToGetHere  -  other.costToGetHere
}

fun problem(costGrid:CostGrid):House? {
    val houses = costGrid.choiceOfColours.map{House(0, it, costGrid[0][it], listOf(), costGrid)}
    return buildHouse(houses)
}

//Not sure if this is right or efficient but this does a uniform cost search
fun buildHouse(housesQueue:List<House> ):House? {
    if (housesQueue.isEmpty()) return null
    if (housesQueue.any(House::isLastHouse)) return housesQueue.first(House::isLastHouse)
    return buildHouse(housesQueue.addHouseToQueue())
}

fun List<House>.addHouseToQueue() = (drop(1) + first().nextHouse()).sorted()
