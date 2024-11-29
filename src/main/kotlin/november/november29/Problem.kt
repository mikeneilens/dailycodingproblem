package november.november29

//Given an N by M matrix consisting only of 1's and 0's, find the largest rectangle containing only 1's and return its area.
//
//For example, given the following matrix:
//
//[[1, 0, 0, 0],
// [1, 0, 1, 1],
// [1, 0, 1, 1],
// [0, 1, 0, 0]]

typealias Matrix = List<List<Int>>

fun problem(matrix:Matrix) =
    matrix.indices.flatMap{row -> matrix.first().indices.map{col -> matrix.maxAt(row, col)}}.maxBy { it.area()}

fun Matrix.maxAt(row:Int, col:Int):Pair<IntRange, IntRange> =
    rangesFor(row, col)
        .fold(Pair(0..0, 0..0)){ bestRanges, ranges ->
            if (containsOnlyOnes(ranges.first, ranges.second) && ranges.area() > bestRanges.area())
                ranges
            else bestRanges
        }

fun Matrix.rangesFor(row:Int, col:Int) =
    (col until (col + width(row, col) )).flatMap { dc ->
        (row until (row + depth(row, col))).map { dr ->
            Pair(row..dr, col..dc) } }

fun Matrix.containsOnlyOnes(rowRange:IntRange, colRange:IntRange) =
    rowRange.flatMap { row ->  colRange.map{col -> this[row][col] }}.all{it == 1}

fun Matrix.width(row:Int, col:Int) =
    this[row].drop(col).takeWhile { it == 1 }.size

fun Matrix.depth(row:Int, col:Int) =
    drop(row).map{it[col]}.takeWhile { it == 1 }.size

fun Pair<IntRange, IntRange>.area() = (first.last - first.first + 1) * (second.last - second.first + 1)