package august.august08
//Implement locking in a binary tree. A binary tree node can be locked or unlocked only if all of its descendants or ancestors are not locked.
//
//Design a binary tree node class with the following methods:
//
//is_locked, which returns whether the node is locked
//lock, which attempts to lock the node. If it cannot be locked, then it should return false. Otherwise, it should lock it and return true.
//unlock, which unlocks the node. If it cannot be unlocked, then it should return false. Otherwise, it should unlock it and return true.
//
// You may augment the node to add parent pointers or any other property you would like.
// You may assume the class is used in a single-threaded program, so there is no need for actual locks or mutexes.
// Each method should run in O(h), where h is the height of the tree.

enum class Status {Locked, Unlocked}

data class Node(val id:Int, var status: Status = Status.Unlocked, val ancestor: Node? = null, val left: Node? = null, val right: Node? = null) {
    private fun isLocked() = status == Status.Locked

    fun lock() = changeStatus(Status.Locked)

    fun unlock() = changeStatus(Status.Unlocked)

    private fun changeStatus(newStatus: Status) = if (ancestorsAndDescendantsAreLocked())  {
        status = newStatus
        true
    } else false

    fun ancestorsAndDescendantsAreLocked() = ancestorsAreLocked() && descendantsAreLocked()

    fun ancestorsAreLocked():Boolean = relativesAreLocked(ancestor, Node::ancestorsAreLocked)

    private fun descendantsAreLocked() = leftIsLocked() && rightIsLocked()

    fun leftIsLocked():Boolean = relativesAreLocked(left, Node::descendantsAreLocked)

    fun rightIsLocked():Boolean = relativesAreLocked(right, Node::descendantsAreLocked)

    private fun relativesAreLocked(node: Node?, relativesChecker: Node.()->Boolean) =
        (node?.isLocked() ?: true) && (node?.relativesChecker() ?: true)

}