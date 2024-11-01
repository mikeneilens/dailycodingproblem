package november.november01

//Given an unsigned 8-bit integer, swap its even and odd bits.
// The 1st and 2nd bit should be swapped, the 3rd and 4th bit should be swapped, and so on.
//
//For example, 10101010 should be 01010101. 11100010 should be 11010001.
//
//Bonus: Can you do this in one line?

fun problem(number:Int) =
    number.toString(2)
        .prefixWithZeroIfOddLength()
        .chunked(2)
        .joinToString("", transform = String::swapDigits)

fun String.prefixWithZeroIfOddLength() = if (length % 2 == 0) this else "0$this"

fun String.swapDigits() = if (length > 1) "${this[1]}${this[0]}" else ""