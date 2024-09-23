package september.september20

//Implement an LFU (Least Frequently Used) cache. It should be able to be initialized with a cache size n,
// and contain the following methods:
//
//set(key, value): sets key to value. If there are already n items in the cache, and we are adding a new item,
// then it should also remove the least frequently used item. If there is a tie, then the least recently used key should be removed.
//get(key): gets the value at key. If no such key exists, return null.
//Each operation should run in O(1) time.

data class Item(val key:String, val value:Int, var hits:Int, var prev:Item? = null, var next:Item? = null) {
    fun insertAfter(other:Item) {
        prev?.next = next
        next?.prev = prev
        next = other.next
        prev = other
        other.next?.prev = this
        other.next = this
    }
    override fun toString(): String = "Item( key = $key, value = $value, hits = $hits )"
}

data class LfuCache(var first:Item) {
    val map = mutableMapOf<String, Item>()
    companion object {
        fun initialize(size:Int, first:Item = Item("$size",0,0), last:Item = first):LfuCache {
            if (size <= 1){
                last.next = first
                first.prev = last
                return LfuCache(first)
            }
            val newItem = Item("${size - 1}",0,0, prev = last).apply{ last.next = this }
            return initialize(size - 1, first, newItem )
        }
    }
    fun get(key:String):Item? {
        val item = map[key]
        if (item == null) return null
        item.hits++
        itemToInsertAfter(item, item)?.let{
            if (it != first){
                if (item == first) item.next?.let{first = it}
                item.insertAfter(it)}
        }
        return item
    }

    fun set(key:String, value:Int, newItem:Item = Item(key, value, 1, first.prev, first.next)) {
        map.remove(first.key)
        map[key] = newItem
        newItem.prev?.next = newItem
        newItem.next?.prev = newItem
        first = newItem
        itemToInsertAfter(first, first)?.let{
            if (it != first){
                val newFirst = first.next
                first.insertAfter(it)
                newFirst?.let {first = it}
            }
        }
    }

    fun itemToInsertAfter(newItem:Item, item:Item? = first):Item? =
        if (newItem.hits < (item?.hits ?: Int.MAX_VALUE)) null
        else if (item?.next == first) item
        else if ((item?.next?.hits ?: 0 ) > newItem.hits) item
        else itemToInsertAfter(newItem, item?.next)

    fun size(count:Int = 1, item:Item? = first.next):Int =
        if (item == first)  count
        else size(count + 1, item?.next)

    fun output(output:String = " $first", item:Item? = first.next):String =
        if (item == first) output
        else output(output + "\n $item", item?.next)
}