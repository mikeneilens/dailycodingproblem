package august.august05

import august.august05.ClassRooms
import august.august05.addToSchedule
import august.august05.problem
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    "When no classrooms adding a booking creates a classroom with a new booking" {
        val classRooms: ClassRooms = listOf()
        val booking = 8..9
        addToSchedule(classRooms, booking) shouldBe listOf(mutableListOf(8..9))
    }
    "When there is a classroom with a booking adding a booking at the same time adds a new classroom with a new booking" {
        val classRooms: ClassRooms = listOf(mutableListOf(8..9))
        val booking = 8..9
        addToSchedule(classRooms, booking) shouldBe listOf(mutableListOf(8..9),mutableListOf(8..9))
    }
    "When there is a classroom with a booking adding a booking that overlaps adds a new classroom with a new booking" {
        val classRooms: ClassRooms = listOf(mutableListOf(8..10))
        val booking = 9..11
        addToSchedule(classRooms, booking) shouldBe listOf(mutableListOf(8..10),mutableListOf(9..11))
    }
    "When there is a classroom with a booking adding a booking that starts after the first booking finishes adds a new booking to existing classroom" {
        val classRooms: ClassRooms = listOf(mutableListOf(8..10))
        val booking = 11..12
        addToSchedule(classRooms, booking) shouldBe listOf(mutableListOf(8..10,11..12))
    }
    "With one booking one classroom is needed" {
        val bookings = listOf(8..9)
        problem(bookings).size shouldBe 1
        problem(bookings) shouldBe listOf(mutableListOf(8..9))
    }
    "With bookings 8..9, 10..11 one classroom is needed" {
        val bookings = listOf(8..9, 10..11)
        problem(bookings).size shouldBe 1
        problem(bookings) shouldBe listOf(mutableListOf(8..9, 10..11))
    }
    "With bookings 8..10, 11..14, 9..10 two classrooms are needed" {
        val bookings = listOf(8..10,11..14, 9..10)
        problem(bookings).size shouldBe 2
        problem(bookings) shouldBe listOf(mutableListOf(8..10, 11..14), mutableListOf(9..10))
    }
    "With bookings 30..75, 0..50, 60..150 two classrooms are needed" {
        val bookings = listOf(30..75,0..50, 60..150)
        problem(bookings).size shouldBe 2
        problem(bookings) shouldBe listOf(mutableListOf(0..50, 60..150), mutableListOf(30..75))
    }
})