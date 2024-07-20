package july20

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec( {
    //Tests for my implementaton of the python code
    "cons(1,2) returns a function that gives 1 when given { a: Int, _: Int -> a } " {
        cons(a = 1, b = 2)(){ a: Int, _: Int -> a } shouldBe 1
    }
    "cons(1,2) returns a function that gives 1 when { _: Int, b: Int -> b } " {
        cons(a = 1,b = 2)(){ _: Int, b: Int -> b } shouldBe 2
    }

    //Tests for the actual problem
    "car(cons(1,2) returns 1" {
        car(cons(a = 1, b = "2")) shouldBe 1
    }
    "cdr(cons(1,2) returns 2" {
        cdr(cons(a = 1, b = "2")) shouldBe "2"
    }

})