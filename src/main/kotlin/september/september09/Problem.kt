package september.september09

//Given an undirected graph represented as an adjacency matrix and an integer k,
// write a function to determine whether each vertex in the graph can be colored such that no two adjacent vertices
// share the same color using at most k colors.

//Each row and column indicates a vertexNo and TRUE at [row][col] indicates vertex #row is a neighbour of vertex #col
typealias Vertexes = List<List<Boolean>>

fun problem(vertexes:Vertexes, colours:Set<String>):List<String> {
    return addColour(vertexes = vertexes, colours = colours ).firstOrNull() ?: listOf()
}

//Does a depth first search, not optimised, so it returns lots of results instead of stopping after the first
fun addColour(vertexNo:Int = 0, coloursForEachVertex:List<String> = listOf(), vertexes:Vertexes, colours:Set<String>):List<List<String>> =
    if (vertexNo >= vertexes.size)
        listOf(coloursForEachVertex)
    else
        candidateColours(vertexNo, coloursForEachVertex, vertexes,colours)
        .flatMap {colour ->  addColour(vertexNo + 1, coloursForEachVertex + colour, vertexes, colours) }

fun candidateColours(vertexNo:Int, coloursForEachVertex: List<String>, vertexes: Vertexes, colours: Set<String> ):Set<String> {
    val neighbourColours = vertexes[vertexNo].mapIndexed { index, isNeighbour ->
        if(isNeighbour && index < coloursForEachVertex.size ) coloursForEachVertex[index] else "" }.toSet()
    return colours - neighbourColours
}