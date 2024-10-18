package october.october15

//We're given a hashmap associating each courseId key with a list of courseIds values, which represents that the
// prerequisites of courseId are courseIds. Return a sorted ordering of courses such that we can finish all courses.
//
//Return null if there is no such ordering.
//
//For example, given {'CSC300': ['CSC100', 'CSC200'], 'CSC200': ['CSC100'], 'CSC100': []}, should return ['CSC100', 'CSC200', 'CSC300'].

fun problem(map:Map<String, List<String>>):List<String> =
    map.inverted("")
        .getPossibleCourses()
        .maxByOrNull(List<String>::size)?.drop(1).orEmpty()

//use a depth first search
fun Map<String,List<String>>.getPossibleCourses(attended:List<String> = listOf("")):List<List<String>> =
    get(attended.last())?.filter{it !in attended}.let{ options ->
        if (options.isNullOrEmpty()) listOf(attended)
        else options.flatMap{getPossibleCourses(attended + it)}
    }

//this swaps the keys and the values of a map when the values type is a list of the same type as the key
fun <E>Map<E, List<E>>.inverted(root:E):Map<E, List<E>> where E: Comparable<E> =
    toList()
        .flatMap{invertAndFlattenPair(it, root)}
        .sortedBy { it.first }.fold(listOf(), ::aggregateValues)
        .toMap()

fun <E>invertAndFlattenPair(p:Pair<E, List<E>>, root:E) =
    if (p.second.isNotEmpty()) p.second.map { v -> Pair(v, p.first) }
    else listOf(Pair(root, p.first))

fun <E>aggregateValues(result: List<Pair<E, List<E>>>, p: Pair<E, E>) = when {
        result.isEmpty() -> listOf(Pair(p.first, listOf(p.second)))
        result.last().first != p.first -> result + Pair(p.first, listOf(p.second))
        else -> result.dropLast(1) + Pair(p.first, result.last().second + p.second)
    }

