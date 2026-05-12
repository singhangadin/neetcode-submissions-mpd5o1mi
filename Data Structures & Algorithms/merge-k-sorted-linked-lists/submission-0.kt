/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) {
            return null
        }

        for (i in 1 until lists.size) {
            lists[i] = mergeLists(lists[i-1], lists[i])
        }

        return lists.last()
    }

    fun mergeLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var dummy: ListNode? = ListNode(0)
        var first = list1
        var second = list2
        var tail = dummy

        while (first != null && second != null) {
            if (first.`val` > second.`val`) {
                tail?.next = second
                second = second?.next
            } else {
                tail?.next = first
                first = first?.next
            }
            tail = tail?.next
        }

        if (first != null) {
            tail?.next = first
        }

        if (second != null) {
            tail?.next = second
        }

        return dummy?.next
    }
}
