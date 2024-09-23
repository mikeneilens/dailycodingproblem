package september.september20

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class ProblemTest: StringSpec({
    "size of a cache containing 1 item is 1" {
        val item = Item("",0,0)
        item.next = item
        LfuCache(item).size() shouldBe 1
    }
    "size of a cache containing 2 items is 2" {
        val item1 = Item("1", 0,0)
        val item2 = Item("3", 0,0).apply { item1?.next = this; prev = item1; next = item1; item1.prev = this }
        val cache = LfuCache(item1).apply { map[item1.key] = item1; map[item2.key] = item2}
        cache.size() shouldBe 2
    }
    "size of a cache containing 3 items is 3" {
        val item1 = Item("1", 0,0)
        val item2 = Item("2", 0,0).apply { item1.next = this; prev = item1 }
        val item3 = Item("3", 0,0).apply { item2.next = this; prev = item2; next = item1; item1.prev = this }
        val cache = LfuCache(item1).apply { map[item1.key] = item1; map[item2.key] = item2;map[item3.key] = item3}
        cache.size() shouldBe 3
    }
    "initialising cache with 3 items creates a cache of size 3" {
        val cache = LfuCache.initialize(3)
        cache.size() shouldBe 3
        val item1 = cache.first
        val item2 = cache.first.next
        val item3 = cache.first.next?.next
        item1.next shouldBe item2
        item1.prev shouldBe item3
        item2?.prev shouldBe item1
        item2?.next shouldBe item3
        item2?.prev shouldBe item1
        item3?.next shouldBe item1
        item3?.prev shouldBe item2
    }
    "item for key '2' should return an item with key '2'" {
        val item1 = Item("1", 0,0)
        val item2 = Item("2", 0,0).apply { item1.next = this; prev = item1 }
        val item3 = Item("3", 0,0).apply { item2.next = this; prev = item2; next = item1; item1.prev = this }
        val cache = LfuCache(item1).apply { map[item1.key] = item1; map[item2.key] = item2;map[item3.key] = item3}
        cache.get("1") shouldBe item1
        cache.get("2") shouldBe item2
        cache.get("3") shouldBe item3
    }
    "item for key '4' should return null" {
        val item1 = Item("1", 0,0)
        val item2 = Item("2", 0,0).apply { item1.next = this; prev = item1 }
        val item3 = Item("3", 0,0).apply { item2.next = this; prev = item2; next = item1; item1.prev = this }
        val cache = LfuCache(item1).apply { map[item1.key] = item1; map[item2.key] = item2;map[item3.key] = item3}
        cache.get("4") shouldBe null
    }
    "item to insert after for an item with 4 hits in cache with items with 4 items with 3,4,4,6 hits is last item with 4" {
        val item1 = Item("1", 0,3)
        val item2 = Item("2", 0,4).apply { item1.next = this; prev = item1 }
        val item3 = Item("3", 0,4).apply { item2.next = this; prev = item2 }
        val item4 = Item("4", 0,6).apply { item3.next = this; prev = item3; next = item1; item1.prev = this }
        val cache = LfuCache(item1).apply { map[item1.key] = item1;map[item2.key] = item2;map[item3.key] = item3;map[item4.key] = item4; }
        cache.itemToInsertAfter(Item("",0,4)) shouldBe item3
    }
    "item to insert after for an item with 7 hits in cache with items with 4 items with 3,4,4,6 hits is last item 6" {
        val item1 = Item("1", 0,3)
        val item2 = Item("2", 0,4).apply { item1.next = this; prev = item1 }
        val item3 = Item("3", 0,4).apply { item2.next = this; prev = item2 }
        val item4 = Item("4", 0,6).apply { item3.next = this; prev = item3; next = item1; item1.prev = this }
        val cache = LfuCache(item1).apply { map[item1.key] = item1;map[item2.key] = item2;map[item3.key] = item3;map[item4.key] = item4; }
        cache.itemToInsertAfter(Item("",0,7)) shouldBe item4
    }
    "item to insert after for an item with 2 hits in cache with items with 4 items with 3,4,4,6 hits is null" {
        val item1 = Item("1", 0,3)
        val item2 = Item("2", 0,4).apply { item1.next = this; prev = item1 }
        val item3 = Item("3", 0,4).apply { item2.next = this; prev = item2 }
        val item4 = Item("4", 0,6).apply { item3.next = this; prev = item3; next = item1; item1.prev = this }
        val cache = LfuCache(item1).apply { map[item1.key] = item1;map[item2.key] = item2;map[item3.key] = item3;map[item4.key] = item4; }
        cache.itemToInsertAfter(Item("",0,2)) shouldBe null
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
        val item4 = Item("4", 0,6).apply { item3.next = this; prev = item3; next = item1; item1.prev = this }
        item2.insertAfter(item3)
        item3.next shouldBe  item2
        item2.prev shouldBe item3
        item2.next shouldBe item4
        item4.prev shouldBe item2
        item1.next shouldBe item3
        item3.prev shouldBe item1
    }
    "item for key '2' should return an item with key '2' and update hits of item 2 and move item2 ahead of item3" {
        val item1 = Item("1", 0,1)
        val item2 = Item("2", 0,1).apply { item1.next = this; prev = item1 }
        val item3 = Item("3", 0,1).apply { item2.next = this; prev = item2; next = item1; item1.prev = this }
        val cache = LfuCache(item1).apply { map[item1.key] = item1; map[item2.key] = item2; map[item3.key] = item3}
        cache.get("2") shouldBe item2
        item2.hits shouldBe 2
        item2.prev shouldBe item3
        item2.next shouldBe item1
        item3.next shouldBe item2
    }
    "item for key '1' should return an item with key '1' and update hits of item1 and move item1 ahead of item3" {
        val item1 = Item("1", 0,1)
        val item2 = Item("2", 0,1).apply { item1.next = this; prev = item1 }
        val item3 = Item("3", 0,1).apply { item2.next = this; prev = item2; next = item1; item1.prev = this }
        val cache = LfuCache(item1).apply { map[item1.key] = item1; map[item2.key] = item2;map[item3.key] = item3}
        cache.get("1") shouldBe item1
        item1.hits shouldBe 2
        item1.prev shouldBe item3
        item1.next shouldBe item2
        item3.next shouldBe item1
        cache.first shouldBe item2
        println(cache.output())
    }
    "item for key '1' should return an item with key '1' and update hits of item1 and not move item1" {
        val item1 = Item("1", 0,1)
        val item2 = Item("2", 0,3).apply { item1.next = this; prev = item1 }
        val item3 = Item("3", 0,3).apply { item2.next = this; prev = item2; next = item1; item1.prev = this }
        val cache = LfuCache(item1).apply { map[item1.key] = item1; map[item2.key] = item2;map[item3.key] = item3}
        cache.get("1") shouldBe item1
        item1.hits shouldBe 2
        item1.prev shouldBe item3
        item1.next shouldBe item2
        item3.next shouldBe item1
        cache.first shouldBe item1
        println(cache.output())
    }
    "set a value for for key '4' should update the first item to a newItem if existing items have more than 1 hit" {
        val item1 = Item("1", 0,2)
        val item2 = Item("2", 0,3).apply { item1.next = this; prev = item1 }
        val item3 = Item("3", 0,3).apply { item2.next = this; prev = item2; next = item1; item1.prev = this }
        val cache = LfuCache(item1).apply { map[item1.key] = item1; map[item2.key] = item2;map[item3.key] = item3}
        cache.set("4", 4)
        cache.first.key shouldBe "4"
        cache.first.value shouldBe 4
        cache.first.hits shouldBe 1
        cache.first.prev shouldBe item3
        cache.first.next shouldBe item2
        item3.next shouldBe cache.first
        cache.first shouldNotBe item1
        println(cache.output())
    }
    "set a value for for key '4' when existing items have 1 hit should remove the first item  and insert new item after last item with one hit" {
        val item1 = Item("1", 0,1)
        val item2 = Item("2", 0,1).apply { item1.next = this; prev = item1 }
        val item3 = Item("3", 0,3).apply { item2.next = this; prev = item2; next = item1; item1.prev = this }
        val cache = LfuCache(item1).apply { map[item1.key] = item1; map[item2.key] = item2;map[item3.key] = item3}
        cache.set("4", 4)
        cache.first shouldBe item2
        item2.next?.key shouldBe "4"
        item2.next?.value shouldBe 4
        item2.next?.hits shouldBe 1
        item2.prev shouldBe item3
        item3.next shouldBe item2
        cache.first shouldNotBe item1
        cache.map["1"] shouldBe null
        println(cache.output())
        println(cache.map)
    }
    "do some random sets and gets on a 26 character cache" {
        val cache = LfuCache.initialize(26)
        val randomKey = {  ('A'..'Z').random().toString() }
        val randomFunction = {if ((1..2).random() == 1) cache.set(randomKey(),1) else cache.get(randomKey())}
        repeat(20, { randomFunction()})
        println(cache.output())
    }

})