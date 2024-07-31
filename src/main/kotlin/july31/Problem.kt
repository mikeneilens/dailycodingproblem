package july31

//You run an e-commerce website and want to record the last N order ids in a log. Implement a data structure to accomplish this, with the following API:
//
//record(order_id): adds the order_id to the log
//get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.
//You should be as efficient with time and space as possible.


@JvmInline
value class Order(val id:Int)

data class ECommerceLog(val n:Int, val logs:MutableList<Order> = mutableListOf(), private var index:Int = -1) {

    fun record(order:Order):ECommerceLog {
        if ((++index) < n) {
            logs.add(order)
        } else {
            logs[index % n] = order
        }
        return this
    }

    fun getLast(i:Int) = if ((index + 1 - i) % n in logs.indices) logs[(index + 1 - i) % n] else null
}