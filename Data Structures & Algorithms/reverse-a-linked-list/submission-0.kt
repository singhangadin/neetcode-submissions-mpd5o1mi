/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        var newHead: ListNode? = null
        var lastHead = head
        while (lastHead != null) {
            val tempHead = ListNode(lastHead.`val`)
            tempHead.next = newHead
            newHead = tempHead

            lastHead = lastHead.next
        }

        return newHead
    }
}
