class LRUCache(capacity: Int) {
    private val capacity = capacity

    private val hashMap = mutableMapOf<Int, Node>()

    private var head: Node = Node(0)
    private var tail: Node = Node(0)

    init {
        head.next = tail
        tail.prev = head
    }

    private class Node constructor(val key: Int) {
        var value: Int = 0
        var next: Node? = null
        var prev: Node? = null
    }

    private fun remove(node: Node) {
        val prev = node?.prev
        val next = node?.next

        prev?.next = next
        next?.prev = prev
    }

    private fun add(node: Node) {
        val prev = tail?.prev
        prev?.next = node
        tail?.prev = node
        node?.prev = prev
        node?.next = tail
    }

    fun get(key: Int): Int {
        return hashMap[key]?.let { node ->
            remove(node)
            add(node)
            node.value
        } ?: -1
    }

    fun put(key: Int, value: Int) {
        hashMap[key]?.let { node ->
            remove(node)
            hashMap.remove(key)
        }

        val node = Node(key)
        node.value = value

        hashMap[key] = node
        add(node)

        if (hashMap.size > capacity) {
            head.next?.let { lru ->
                remove(lru)
                hashMap.remove(lru.key)
            }
        }
    }
}
