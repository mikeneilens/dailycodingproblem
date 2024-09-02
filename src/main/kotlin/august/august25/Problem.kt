package august.august25

//Given an unordered list of flights taken by someone, each represented as (origin, destination) pairs, and a starting
// airport, compute the person's itinerary. If no such itinerary exists, return null. If there are multiple possible
// itineraries, return the lexicographically smallest one. All flights must be used in the itinerary.
//
//For example, given the list of flights [('SFO', 'HKO'), ('YYZ', 'SFO'), ('YUL', 'YYZ'), ('HKO', 'ORD')]
// and starting airport 'YUL', you should return the list ['YUL', 'YYZ', 'SFO', 'HKO', 'ORD'].
//
//Given the list of flights [('SFO', 'COM'), ('COM', 'YYZ')] and starting airport 'COM', you should return null.
//
//Given the list of flights [('A', 'B'), ('A', 'C'), ('B', 'C'), ('C', 'A')] and starting airport 'A', you should return
// the list ['A', 'B', 'C', 'A', 'C'] even though ['A', 'C', 'A', 'B', 'C'] is also a valid itinerary.
// However, the first one is lexicographically smaller.

data class Flight(val from:String, val to:String)

fun problem(flights:List<Flight>, start:String) =
    findFlight(flights, listOf(), start)
        .map(List<Flight>::toLocations)
        .sorted().firstOrNull()

//depth first search
fun findFlight(possibleFlights:List<Flight>, flightsTaken:List<Flight>, currentLocation:String):List<List<Flight>> =
    if (flightsTaken.size == possibleFlights.size) listOf(flightsTaken)
    else possibleFlights.possibleNextFlights(flightsTaken, currentLocation)
        .flatMap { flight -> findFlight(possibleFlights,flightsTaken + flight, flight.to) }

fun List<Flight>.possibleNextFlights(flightsTaken:List<Flight>, currentLocation:String) =
    filter{flight -> flight.from == currentLocation && flight !in flightsTaken }

fun List<Flight>.toLocations() =  if(isNotEmpty()) map{it.from} + last().to else listOf()

fun List<List<String>>.sorted() = sortedBy { it.joinToString("")}