package september.september05

//Implement an LRU (Least Recently Used) cache. It should be able to be initialized with a cache size n, and
// contain the following methods:
//
//set(key, value): sets key to value. If there are already n items in the cache and we are adding a new item,
// then it should also remove the least recently used item.
//get(key): gets the value at key. If no such key exists, return null.
//Each operation should run in O(1) time.

data class Item(var itemkey:String, var next:Item? = null)

fun createItems(n:Int, start:Item = Item("$n"), current:Item = start):Item {
    return if (n <= 1) {
        current.next = start
        start
    } else {
        Item("${n - 1}").let{ newItem ->
            current.next = newItem
            createItems(n - 1, start, newItem)
        }
    }
}

data class Cache(val n:Int) {
    var oldestItems:Item
    val cacheMap:MutableMap<String, Int> = mutableMapOf()

    fun set(key:String, value:Int) {
        if (cacheMap[key] != value) {
            cacheMap.remove(oldestItems.itemkey)
            cacheMap[key] = value
            oldestItems.itemkey = key
            oldestItems = oldestItems?.next ?: oldestItems
        }
    }
    fun get(key:String) = cacheMap[key]

    init {
        if (n < 1) throw IllegalArgumentException("cache size should be greater than zero")
        oldestItems = createItems(n)
    }
}