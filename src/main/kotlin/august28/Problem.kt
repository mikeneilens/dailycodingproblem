package august28

//Implement a stack that has the following methods:
//
//push(val), which pushes an element onto the stack
//pop(), which pops off and returns the topmost element of the stack. If there are no elements in the stack, then it should throw an error or return null.
//max(), which returns the maximum value in the stack currently. If there are no elements in the stack, then it should throw an error or return null.
//Each method should run in constant time.


data class StackItem<E>(var previousItem:StackItem<E>?, val value:E) where E:Comparable<E> {

    fun max():E = previousItem?.max()?.let{maxChild -> if (value > maxChild) value else maxChild} ?: value

}


data class Stack<E>(var topItem:StackItem<E>? = null) where E:Comparable<E> {

    fun push(value:E):Stack<E> = apply { topItem = StackItem(topItem, value)}

    fun pop():E? {
        val poppedItem = topItem
        topItem = poppedItem?.previousItem
        return poppedItem?.apply { previousItem = null}?.value  //update previous item to null to free up memory
    }

    fun max() = topItem?.max()

    fun value():E? = topItem?.value
}