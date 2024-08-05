package august05

//Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), find the minimum number of rooms required.
//
//For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.

typealias Booking = IntRange
typealias Bookings = MutableList<Booking>
typealias ClassRooms = List<Bookings>

val Booking.startTime get() = this.first
val Booking.endTime get() = this.last

fun problem(bookings:List<Booking>):ClassRooms =
    bookings.sortedBy(Booking::startTime).fold(listOf(), ::addToSchedule)

fun addToSchedule(classRooms: ClassRooms, booking: Booking):ClassRooms {
    val bookings =  classRooms.sortedBy {it.last().endTime}.firstOrNull { booking.startTime > it.last().endTime }
    if (bookings != null) {
        bookings.add(booking)
        return classRooms
    } else {
        return classRooms + listOf(mutableListOf(booking))
    }
}
