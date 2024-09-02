package august.august31

//Given an array of numbers representing the stock prices of a company in chronological order,
// write a function that calculates the maximum profit you could have made from buying and selling that stock once.
// You must buy before you can sell it.
//
//For example, given [9, 11, 8, 5, 7, 10], you should return 5, since you could buy the stock at 5 dollars and sell it at 10 dollars.


fun problem(prices:List<Int>):Int = prices
    .mapIndexed{i, price -> prices.subList(i , prices.size ).maxProfit() }
    .maxOrNull() ?: 0

fun List<Int>.maxProfit() = when {
    isEmpty() -> 0
    size == 1 -> 0
    else ->  maxOf(0, drop(1).max() - first())
}