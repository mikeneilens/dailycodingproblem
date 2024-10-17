package october.october15

//We're given a hashmap associating each courseId key with a list of courseIds values, which represents that the
// prerequisites of courseId are courseIds. Return a sorted ordering of courses such that we can finish all courses.
//
//Return null if there is no such ordering.
//
//For example, given {'CSC300': ['CSC100', 'CSC200'], 'CSC200': ['CSC100'], 'CSC100': []}, should return ['CSC100', 'CSC200', 'CSCS300'].

fun Map<String, List<String>>.inverted():Map<String, List<String>> {
    return toList()
        .flatMap(::invertPair)
        .sortedBy { it.first }.fold<Pair<String, String>, List<Pair<String, List<String>>>>(listOf()) { result, p ->
        if (result.isEmpty()) listOf(Pair(p.first,listOf(p.second)))
        else if (result.last().first != p.first) result + Pair(p.first,listOf(p.second))
        else result.dropLast(1) + Pair(p.first, result.last().second + p.second)
    }.toMap()
}

private fun invertPair(p:Pair<String, List<String>>) =
    if (p.second.isNotEmpty()) p.second.map { v -> Pair(v, p.first) }
    else listOf(Pair("", p.first))

