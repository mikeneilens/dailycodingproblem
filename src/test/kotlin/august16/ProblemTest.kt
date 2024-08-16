package august16

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe

class ProblemTest: WordSpec( {
    "when converting array to currency" should {
        "with one currency create one exchange which is one with rate set to zero" {
            val currencies = listOf("A")
            val exhanges = listOf(
                listOf(1.0)
            )
            exhanges.toExchanges(currencies) shouldBe listOf(Exchange("A", "A", 0.0))
        }
        "with two currencies create four exchanges with exchange rate of zero for same currency to same currency" {
            val currencies = listOf("A","B")
            val exhanges = listOf(
                listOf(1.0,2.0),
                listOf(0.5,1.0),
            )
            exhanges.toExchanges(currencies) shouldBe listOf(Exchange(currencyFrom="A", currencyTo="A", rate=0.0),
                Exchange(currencyFrom="A", currencyTo="B", rate=2.0),
                Exchange(currencyFrom="B", currencyTo="A", rate=0.5),
                Exchange(currencyFrom="B", currencyTo="B", rate=0.0))
        }
        "conversion of 10 from B to A when B to A has an exchange rate of 0.5 gives 5" {
            val exchanges = listOf(Exchange(currencyFrom="A", currencyTo="B", rate=2.0),
                Exchange(currencyFrom="B", currencyTo="A", rate=0.5))
            exchanges.conversion(value = 10.0, from = "B", to = "A") shouldBe 5
        }
    }
    "when finding the best route back to currency A" should  {
        "with one currency should be no routes " {
            val exchanges = listOf(Exchange("A", "A", 1.0))
            exchanges.bestRoutes("A") shouldBe listOf()
        }
        "with two currency there are no best routes" {
            val exchanges = listOf(
                Exchange(currencyFrom="A", currencyTo="A", rate=1.0),
                Exchange(currencyFrom="A", currencyTo="B", rate=2.0),
                Exchange(currencyFrom="B", currencyTo="A", rate=0.5),
                Exchange(currencyFrom="B", currencyTo="B", rate=1.0))
            exchanges.bestRoutes("A") shouldBe listOf()
        }
        "with two currency where the 2nd currency has a favourable rate back to A the best should be one route which is conversion A->B->A " {
            val exchanges = listOf(
                Exchange(currencyFrom="A", currencyTo="A", rate=1.0),
                Exchange(currencyFrom="A", currencyTo="B", rate=2.0),
                Exchange(currencyFrom="B", currencyTo="A", rate=0.6),
                Exchange(currencyFrom="B", currencyTo="B", rate=1.0))
            exchanges.bestRoutes("A") shouldBe listOf(
                listOf(Exchange(currencyFrom="A", currencyTo="B", rate=2.0), Exchange(currencyFrom="B", currencyTo="A", rate=0.6)))
        }
        "with three currency where the C-A has a favourable rate back to A the best should be one route which is conversion A->B->C " {
            val exchanges = listOf(
                Exchange(currencyFrom="A", currencyTo="A", rate=1.0),
                Exchange(currencyFrom="A", currencyTo="B", rate=1.0),
                Exchange(currencyFrom="A", currencyTo="C", rate=1.0),
                Exchange(currencyFrom="B", currencyTo="A", rate=1.0),
                Exchange(currencyFrom="B", currencyTo="B", rate=1.0),
                Exchange(currencyFrom="B", currencyTo="C", rate=1.0),
                Exchange(currencyFrom="C", currencyTo="A", rate=1.1),
                Exchange(currencyFrom="C", currencyTo="B", rate=1.0),
                Exchange(currencyFrom="C", currencyTo="C", rate=1.0)
            )
            exchanges.bestRoutes("A") shouldBe listOf(
                listOf(Exchange(currencyFrom="A", currencyTo="B", rate=1.0),Exchange(currencyFrom="B", currencyTo="C", rate=1.0),Exchange(currencyFrom="C", currencyTo="A", rate=1.1))
                )
        }
    }

})