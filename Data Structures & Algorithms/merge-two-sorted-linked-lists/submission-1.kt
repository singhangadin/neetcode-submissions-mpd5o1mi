/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var start: ListNode? = null
        var node: ListNode? = null

        var start1 = list1
        var start2 = list2

        while (start1 != null || start2 != null) {
            if (start == null) {
                if (start1 != null && start2 != null) {
                    if (start1.`val` <= start2.`val`) {
                        start = ListNode(start1.`val`)
                        start1 = start1.next
                    } else {
                        start = ListNode(start2.`val`)
                        start2 = start2.next
                    }
                } else if (start1 != null) {
                    start = ListNode(start1.`val`)
                    start1 = start1.next
                } else {
                    start = ListNode(start2!!.`val`)
                    start2 = start2.next
                }
                node = start
            } else {
                var tempNode: ListNode? = null
                if (start1 != null && start2 != null) {
                    if (start1.`val` <= start2.`val`) {
                        tempNode = ListNode(start1.`val`)
                        start1 = start1.next
                    } else {
                        tempNode = ListNode(start2.`val`)
                        start2 = start2.next
                    }
                } else if (start1 != null) {
                    tempNode = ListNode(start1.`val`)
                    start1 = start1.next
                } else {
                    tempNode = ListNode(start2!!.`val`)
                    start2 = start2.next
                }
                node!!.next = tempNode
                node = node!!.next
            }
        }

        return start
    }
}
