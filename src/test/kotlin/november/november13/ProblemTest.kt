package november.november13

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    "test every even call of getInstance(), return the first instance" {
        Singleton.set("1")
        Singleton.set("2")
        Singleton.set("3")
        Singleton.getInstance()
        Singleton.getInstance() shouldBe "3"
        Singleton.getInstance()
        Singleton.getInstance() shouldBe "3"
    }

    "test every odd call of getInstance(), return the second instance" {
        Singleton.set("1")
        Singleton.set("2")
        Singleton.set("3")
        Singleton.getInstance() shouldBe "2"
        Singleton.getInstance()
        Singleton.getInstance() shouldBe "2"
        Singleton.getInstance()
        Singleton.getInstance() shouldBe "2"
    }

})