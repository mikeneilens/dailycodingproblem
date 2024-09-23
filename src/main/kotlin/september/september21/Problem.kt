package september.september21

//On our special chessboard, two bishops attack each other if they share the same diagonal.
// This includes bishops that have another bishop located between them, i.e. bishops can attack through pieces.
//
//You are given N bishops, represented as (row, column) tuples on a M by M chessboard.
// Write a function to count the number of pairs of bishops that attack each other.
// The ordering of the pair doesn't matter: (1, 2) is considered the same as (2, 1).
//
//For example, given M = 5 and the list of bishops:
//
//(0, 0)
//(1, 2)
//(2, 2)
//(4, 0)
//The board would look like this:
//
//[b 0 0 0 0]
//[0 0 b 0 0]
//[0 0 b 0 0]
//[0 0 0 0 0]
//[b 0 0 0 0]
//You should return 2, since bishops 1 and 3 attack each other, as well as bishops 3 and 4.

data class Square(val row:Int, val col:Int)

fun problem(m:Int, bishops:Set<Square>) =
    diagnols(m).map{ diagonal -> diagonal.count { it in bishops }.noOfCollisions()}.filter{it > 0 }

fun diagnols(m:Int):Set<Set<Square>> =
   leftSideDiagonal(m) + topSideDiagonal(m) + rightSideDiagonal(m) + bottomSideDiagonal(m)

fun leftSideDiagonal(m:Int) = (0..(m - 2)).map{ n -> (1..(m-n)).map{ row -> Square( row, row + n)}.toSet()}.toSet()
fun topSideDiagonal(m:Int) = (1..(m - 2)).map{ n -> ((1 + n)..m).map{ row -> Square( row, row - n)}.toSet()}.toSet()
fun rightSideDiagonal(m:Int) = (0..(m - 2)).map{ n -> (1..(m-n)).map{ col -> Square( (m + 1 - n) - col, col)}.toSet()}.toSet()
fun bottomSideDiagonal(m:Int) = (2..(m - 1)).map{ n -> (n..m).map{ col -> Square( m + n - col, col)}.toSet()}.toSet()

fun Int.noOfCollisions(n:Int = 0, total:Int = 0):Int =
    if (n >= this) total else noOfCollisions(  n+ 1, total + n )

