/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reorderList(head: ListNode?): Unit {
        if (head == null || head.next == null) return

        // Finding the middle the element
        var slow: ListNode? = head
        var fast: ListNode? = head?.next

        while (fast != null && fast?.next != null) {
            slow = slow?.next
            fast = fast?.next?.next
        }

        var second = slow?.next
        slow?.next = null

        // Reverse the second list
        var prev: ListNode? = null
        var current = second
        while (current != null) {
            val temp = current .next
            current?.next = prev
            prev = current
            current = temp
        }

        // Merging the lists
        var first = head
        var secondList = prev

        while (first != null && secondList != null) {
            val temp1 = first?.next
            val temp2 = secondList?.next

            first?.next = secondList
            secondList?.next = temp1
            first = temp1
            secondList = temp2
        }
    }
}
