package august.august16

//Suppose you are given a table of currency exchange rates, represented as a 2D array.
// Determine whether there is a possible arbitrage: that is, whether there is some sequence of trades you can make,
// starting with some amount A of any currency, so that you can end up with some amount greater than A of that currency.
//
//There are no transaction costs and you can trade fractional quantities.

data class Exchange(val currencyFrom:String, val currencyTo:String, val rate:Double)

fun problem(exchangeRates:List<List<Double>>):List<List<Exchange>> {
    val exchanges = exchangeRates.toExchanges(('A'..'Z').take(exchangeRates.size).map(Char::toString))
    return  exchanges.bestRoutes("A")
}

fun List<Exchange>.product() =  map(Exchange::rate).fold(1.0, Double::times )

fun List<List<Double>>.toExchanges(currencies:List<String>) =
    currencies.flatMapIndexed { fromIndex, from ->
        currencies.mapIndexed { toIndex, to ->
             Exchange(from, to, if (from != to)  this[fromIndex][toIndex] else 0.0)
        }
    }

fun List<Exchange>.conversion(value:Double, from:String, to:String) = value * first{it.currencyFrom == from && it.currencyTo == to}.rate

//Does a depth first search
fun List<Exchange>.bestRoutes(originalCurrency:String, from:String = originalCurrency, value:Double = 1.0, bestValue:MutableMap<String, Double> = mutableMapOf(), result:List<Exchange> = listOf()):List<List<Exchange>> {
    if (result.isNotEmpty() && result.last().currencyTo == originalCurrency) {
        if (result.product() > 1.0) return listOf(result) else return listOf()
    }
    val options = filter{exchange ->  exchange.currencyFrom == from && exchangeIsFavourable(value, exchange, originalCurrency, bestValue) && exchange !in result }
    return options.flatMap { exchange ->
        val newValue = value * exchange.rate
        bestValue[exchange.currencyTo] = conversion(newValue, from = exchange.currencyTo, to = originalCurrency)
        this.bestRoutes(originalCurrency, exchange.currencyTo, newValue, bestValue, result + listOf(exchange))
    }
}

fun List<Exchange>.exchangeIsFavourable(value: Double, exchange: Exchange, originalCurrency: String, bestValue: MutableMap<String, Double>) =
    conversion(value * exchange.rate, from = exchange.currencyTo, to = originalCurrency) > bestValue.getOrDefault(exchange.currencyTo, 0.0)
