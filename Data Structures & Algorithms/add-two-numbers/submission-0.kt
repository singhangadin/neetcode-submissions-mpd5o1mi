/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var num1 = l1
        var num2 = l2

        var carry = 0
        val start: ListNode ?= ListNode(0)
        var current = start

        while (num1 != null || num2 != null || carry != 0) {
            val a = num1?.`val` ?: 0
            val b = num2?.`val` ?: 0
            val num = a + b + carry
            val digit = num % 10
            carry = num / 10

            current?.next = ListNode(digit)
            current = current?.next
            num1 = num1?.next
            num2 = num2?.next
        }

        return start?.next
    }
}
