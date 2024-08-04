package august03
//A builder is looking to build a row of N houses that can be of K different colors. He has a goal of minimizing cost while ensuring that no two neighboring houses are of the same color.
//
//Given an N by K matrix where the nth row and kth column represents the cost to build the nth house with kth color, return the minimum cost which achieves this goal.

data class Rules(val noOfHouses:Int, val choiceOfColours:IntRange, val costGrid:List<List<Int>> )

typealias CostGrid = List<List<Int>>

val CostGrid.choiceOfColours get() = 0..first().lastIndex
val CostGrid.noOfHouses get() = lastIndex

data class House(val houseNo:Int, val colour:Int, val costToGetHere:Int, val previousHouses:List<House> = listOf(), val costGrid:CostGrid):Comparable<House> {
    fun isLastHouse() = houseNo == costGrid.noOfHouses

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
fun buildHouse(houses:List<House> ):House? {
    if (houses.isEmpty()) return null
    if (houses.any(House::isLastHouse)) return houses.first(House::isLastHouse)
    return buildHouse(houses.addHouseToQueue())
}

fun List<House>.addHouseToQueue() = (drop(1) + first().nextHouse()).sorted()
