package october.october23

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    "distance between (4,1) and (3,3) is 2" {
        Point(4,1).distanceTo(Point(3,3)) shouldBe 2
    }
    "distance between (3,3) and (4,1) is 2" {
        Point(3,3).distanceTo(Point(4,1)) shouldBe 2
    }
    "distance between (4,1) and (2,4) is 3" {
        Point(4,1).distanceTo(Point(2,4)) shouldBe 3
    }
    "distance between (4,1) and (4,5) is 4" {
        Point(4,1).distanceTo(Point(4,5)) shouldBe 4
    }
    "distance between (4,1) and (1,4) is 3" {
        Point(4,1).distanceTo(Point(1,4)) shouldBe 3
    }
    "steps for points (0, 0), (1, 1), (1, 2) is " {
        listOf(Point(0,0),Point(1,1),Point(1,2)).steps() shouldBe 2
    }
})
