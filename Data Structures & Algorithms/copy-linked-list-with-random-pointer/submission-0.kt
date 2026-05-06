/*
// Definition for a Node.
class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}
*/

class Solution {
    val nodeMap = hashMapOf<Node, Node>()

    fun copyRandomList(head: Node?): Node? {
        if (head == null) {
            return head
        } else {
            var node = head

            while (node != null) {
                val newNode = Node(node.`val`)
                nodeMap[node] = newNode

                node = node?.next
            }

            for (node in nodeMap.keys) {
                nodeMap[node]?.next = nodeMap[node?.next]
                nodeMap[node]?.random = nodeMap[node?.random]
            }

            return nodeMap[head]
        }
    }
}
