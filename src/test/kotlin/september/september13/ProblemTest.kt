package september.september13

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    "an empty set has no permutations" {
        permutations(setOf()) shouldBe setOf()
    }
    "permutations of a set of {1} gives [{1}] " {
        permutations(setOf(Num(1))).toInts() shouldBe setOf(setOf(1))
    }
    "permutations of a set of {1,2} gives [{1},{2},{1,2}]" {
        permutations(setOf(Num(1),Num(2))).toInts() shouldBe setOf(setOf(1),setOf(2),setOf(1,2))
    }
    "permutations of a set of {1,2,3} gives [{1},{2},{3},{1,2},{1,3},{2,3},{1,2,3}]" {
        permutations(setOf(Num(1),Num(2),Num(3))).toInts() shouldBe setOf(
            setOf(1), setOf(2),setOf(3),
            setOf(1,2),setOf(1,3), setOf(2,3),
            setOf(1,2,3)
        )
    }

    "Combining {{1,2},{2,3}} gives {{{1,2},{2,3}} " {
        val sets = setOf(setOf(Num(1),Num(2)), setOf(Num(2),Num(3)))
        sets.combineIntoPairs().map{it.toInts()} shouldBe setOf(setOf(setOf(1,2),setOf(2,3)))
    }
    "set {15, 5, 20, 10, 35, 15, 10} has subset permutations of {} " {
        val set = setOf(Num(15), Num(5), Num(20), Num(10), Num(35), Num(15),Num(10))
        val subSets = permutations(set )
        val combinations = permutationsContainingTwo(subSets, set.size )
        combinations.size shouldBe 63
    }
    "set {15, 5, 20, 10, 35, 15, 10} has two subsets that sum up to the same value" {
        val set = setOf(Num(15), Num(5), Num(20), Num(10), Num(35), Num(15),Num(10))
        problem(set) shouldBe true
    }
    "set {15, 5, 20, 35 10} does not have two subsets that sum up to the same value" {
        val set = setOf(Num(15), Num(5), Num(20), Num(35), Num(10))
        problem(set) shouldBe false
    }
})

fun Set<Set<Num>>.toInts() = map{ it.map{num -> num.value}.toSet()}.toSet()