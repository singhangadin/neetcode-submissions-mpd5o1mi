/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var first = head
        var second = head

        for (i in 0 until n) {
            first = first?.next
        }

        if (first == null) {
            return head?.next
        }

        while (first?.next != null) {
            first = first?.next
            second = second?.next
        }

        second?.next = second?.next?.next

        return head
    }
}
