package october.october25

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    "leading sublist with total of 10 in (1,2,3,4,5,6,7) is (1,2,3,4)" {
        listOf(1,2,3,4,5,6,7).leadingSubListWithTotalEqualTo(10) shouldBe listOf(listOf(1,2,3,4))
    }
    "leading sublist with total of 10 in (1,2,3,4,-2,1,1,3,4) is (1,2,3,4,-2,1,1)" {
        listOf(1,2,3,4,-2,1,1,3,4).leadingSubListWithTotalEqualTo(10) shouldBe listOf(listOf(1,2,3,4),listOf(1,2,3,4,-2,1,1))
    }
    "leading sublist with total of 10 in (1,2,3,3,4) is empty list" {
        listOf(1,2,3,3,4).leadingSubListWithTotalEqualTo(10) shouldBe listOf()
    }

    "list of (1,2,3) as sublists is ((1,2,3), (2,3), (3))" {
        listOf(1,2,3).createListOfSubLists() shouldBe listOf(listOf(1,2,3), listOf(2,3), listOf(3))
    }
    "if list is (1, 2, 3, 4, 5) and target is 9 should return (2,3,4) and (4,5)" {
        problem(listOf(1,2,3,4,5), 9) shouldBe listOf(listOf(2,3,4), listOf(4,5))
    }
})
