package september.september20

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    "size of a cache containing 1 item is 1" {
        val item = Item("",0,0)
        item.next = item
        LfuCache(item).size() shouldBe 1
    }
    "size of a cache containing 2 items is 2" {
        val item = Item("1",0,0, Item("2",0,0))
        item.next?.next = item
        LfuCache(item).size() shouldBe 2
    }
    "size of a cache containing 3 items is 3" {
        val item = Item("1",0,0, Item("2",0,0, Item("3",0,0)))
        item.next?.next?.next = item
        LfuCache(item).size() shouldBe 3
    }
    "initialising cache with 3 items creates a cache of size 3" {
        val cache = LfuCache.initialize(3)
        cache.size() shouldBe 3
        val item1 = cache.first
        val item2 = cache.first.next
        val item3 = cache.first.next?.next
        item1.next shouldBe item2
        item1?.prev shouldBe item3
        item2?.prev shouldBe item1
        item2?.next shouldBe item3
        item2?.prev shouldBe item1
        item3?.next shouldBe item1
        item3?.prev shouldBe item2
    }
    "item for key '2' should return an item with key '2'" {
        val item1 = Item("1", 0,0)
        val item2 = Item("2", 0,0).apply { item1.next = this }
        val item3 = Item("3", 0,0).apply { item2.next = this; this.next = item1 }
        LfuCache(item1).get("1") shouldBe item1
        LfuCache(item1).get("2") shouldBe item2
        LfuCache(item1).get("3") shouldBe item3
    }
    "item for key '4' should return null" {
        val item1 = Item("1", 0,0)
        val item2 = Item("2", 0,0).apply { item1.next = this }
        val item3 = Item("3", 0,0).apply { item2.next = this; this.next = item1 }
        LfuCache(item1).get("4") shouldBe null
    }
    "item to insert after for an item with 4 hits in cache with items with 4 items with 3,4,4,6 hits is last item with 4" {
        val item1 = Item("1", 0,3)
        val item2 = Item("2", 0,4).apply { item1.next = this }
        val item3 = Item("3", 0,4).apply { item2.next = this}
        val item4 = Item("4", 0,6).apply { item3.next = this; this.next = item1 }
        LfuCache(item1).itemToInsertAfter(Item("",0,4)) shouldBe item3
    }
    "item to insert after for an item with 7 hits in cache with items with 4 items with 3,4,4,6 hits is last item 6" {
        val item1 = Item("1", 0,3)
        val item2 = Item("2", 0,4).apply { item1.next = this }
        val item3 = Item("3", 0,4).apply { item2.next = this}
        val item4 = Item("4", 0,6).apply { item3.next = this; this.next = item1 }
        LfuCache(item1).itemToInsertAfter(Item("",0,7)) shouldBe item4
    }
    "item to insert after for an item with 2 hits in cache with items with 4 items with 3,4,4,6 hits is null" {
        val item1 = Item("1", 0,3)
        val item2 = Item("2", 0,4).apply { item1.next = this }
        val item3 = Item("3", 0,4).apply { item2.next = this}
        val item4 = Item("4", 0,6).apply { item3.next = this; this.next = item1 }
        LfuCache(item1).itemToInsertAfter(Item("",0,2)) shouldBe null
    }
    "insert an item after item 3 in a chain of 4 items" {
        val item1 = Item("1", 0,3)
        val item2 = Item("2", 0,4).apply { item1.next = this; prev = item1 }
        val item3 = Item("3", 0,4).apply { item2.next = this; prev = item2}
        val item4 = Item("4", 0,6).apply { item3.next = this; prev = item3; this.next = item1; item1.prev = this }
        val itemNew = Item("New", 0, 0)
        itemNew.insertAfter(item3)
        item3.next shouldBe  itemNew
        itemNew.prev shouldBe item3
        itemNew.next shouldBe item4
        item4.prev shouldBe itemNew
    }
    "insert an item2 after item 3 in a chain of 4 items" {
        val item1 = Item("1", 0,3)
        val item2 = Item("2", 0,4).apply { item1.next = this; prev = item1 }
        val item3 = Item("3", 0,4).apply { item2.next = this; prev = item2}
        val item4 = Item("4", 0,6).apply { item3.next = this; prev = item3; this.next = item1; item1.prev = this }
        item2.insertAfter(item3)
        item3.next shouldBe  item2
        item2.prev shouldBe item3
        item2.next shouldBe item4
        item4.prev shouldBe item2
        item1.next shouldBe item3
        item3.prev shouldBe item1
    }
})