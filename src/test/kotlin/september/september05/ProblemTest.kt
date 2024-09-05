package september.september05

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec( {
    "initialising oldest items with size 5 producing circular list of 5 items" {
        val items = createItems(5)
        items.itemkey shouldBe "5"
        items.next?.itemkey shouldBe "4"
        items.next?.next?.itemkey shouldBe "3"
        items.next?.next?.next?.itemkey shouldBe "2"
        items.next?.next?.next?.next?.itemkey shouldBe "1"
        items.next?.next?.next?.next?.next?.itemkey shouldBe "5"
    }

    "creating a cache of size 0 throws an illegal argument exception" {
        val exception = shouldThrow<IllegalArgumentException> {
            Cache(0)
        }
        exception.localizedMessage shouldBe  "cache size should be greater than zero"
    }
    "creating a cache of size 3 creates a cache with oldestItems of size 3" {
        val cache = Cache(3)
        cache.oldestItems.itemkey = "3"
        cache.oldestItems.next?.itemkey = "2"
        cache.oldestItems.next?.next?.itemkey = "1"
        cache.oldestItems.next?.next?.next?.itemkey = "3"
    }
    "create a cache of size 3 and add an item to it and retrieve it" {
        val cache = Cache(3)
        cache.set("item1", 1)
        cache.get("item1") shouldBe 1
    }
    "create a cache of size 3 and add 3 items to it and retrieve them" {
        val cache = Cache(3)
        cache.set("item1", 1)
        cache.set("item2", 2)
        cache.set("item3", 3)
        cache.get("item1") shouldBe 1
        cache.get("item2") shouldBe 2
        cache.get("item3") shouldBe 3
        cache.cacheMap.size shouldBe  3
    }
    "create a cache of size 3 and add 4 items to it and retrieve them" {
        val cache = Cache(3)
        cache.set("item1", 1)
        cache.set("item2", 2)
        cache.set("item3", 3)
        cache.set("item4", 4)
        cache.get("item1") shouldBe null
        cache.get("item2") shouldBe 2
        cache.get("item3") shouldBe 3
        cache.get("item4") shouldBe 4
        cache.cacheMap.size shouldBe  3
    }
    "create a cache of size 3 and add 4 items to it, including a duplicate and retrieve them" {
        val cache = Cache(3)
        cache.set("item1", 1)
        cache.set("item2", 2)
        cache.set("item2", 2)
        cache.set("item3", 3)
        cache.get("item1") shouldBe 1
        cache.get("item2") shouldBe 2
        cache.get("item3") shouldBe 3
        cache.cacheMap.size shouldBe  3
    }
})