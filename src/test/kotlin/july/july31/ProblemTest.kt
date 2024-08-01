package july.july31

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import july.july31.ECommerceLog
import july.july31.Order

class ProblemTest: StringSpec( {
    "add one order to an ecommerceLog of size 4 results in a log with one item in it" {
        val ecommreceLog = ECommerceLog(4)
        ecommreceLog.record(Order(1)).logs[0] shouldBe  Order(1)
    }
    "adding two orders to ecommerceLog of size 4 results in a log with two items in it "{
        val ecommreceLog = ECommerceLog(4)
        ecommreceLog.record(Order(1)).record(Order(2))
        ecommreceLog.logs[0] shouldBe  Order(1)
        ecommreceLog.logs[1] shouldBe  Order(2)
    }
    "adding five orders to ecommerceLog of size 4 results in a log with the last four items in it "{
        val ecommreceLog = ECommerceLog(4)
        ecommreceLog.record(Order(1)).record(Order(2)).record(Order(3)).record(Order(4)).record(Order(5))
        ecommreceLog.logs[0] shouldBe  Order(5)
        ecommreceLog.logs[1] shouldBe  Order(2)
        ecommreceLog.logs[2] shouldBe  Order(3)
        ecommreceLog.logs[3] shouldBe  Order(4)
    }
    "get last(0) returns null for a log containing a one order" {
        val ecommreceLog = ECommerceLog(4).record(Order(1))
        ecommreceLog.getLast(0) shouldBe null
    }
    "get last(1) returns null for a log containing no orders" {
        val ecommreceLog = ECommerceLog(4)
        ecommreceLog.getLast(1) shouldBe null
    }
    "get last(1) returns last order added to a log containing a one order" {
        val ecommreceLog = ECommerceLog(4).record(Order(1))
        ecommreceLog.getLast(1) shouldBe Order(1)
    }
    "get last(1) returns last order added to a log containing two orders" {
        val ecommreceLog = ECommerceLog(4).record(Order(1)).record(Order(2))
        ecommreceLog.getLast(1) shouldBe Order(2)
    }
    "get last(2) returns first order added to a log containing two orders" {
        val ecommreceLog = ECommerceLog(4).record(Order(1)).record(Order(2))
        ecommreceLog.getLast(2) shouldBe Order(1)
    }
    "get last(1) returns last order added to a log containing five orders" {
        val ecommreceLog = ECommerceLog(4)
        ecommreceLog.record(Order(1)).record(Order(2)).record(Order(3)).record(Order(4)).record(Order(5))
        ecommreceLog.getLast(1) shouldBe Order(5)
    }
    "get last(2) returns fourth order added to a log containing five orders" {
        val ecommreceLog = ECommerceLog(4)
        ecommreceLog.record(Order(1)).record(Order(2)).record(Order(3)).record(Order(4)).record(Order(5))
        ecommreceLog.getLast(2) shouldBe Order(4)
    }
})