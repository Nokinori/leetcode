package org.nokinori.problems

/**
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
object AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummyHead = ListNode(-1)
        var carry = 0
        var current: ListNode = dummyHead

        var node1: ListNode? = l1
        var node2: ListNode? = l2


        while (node1 != null || node2 != null) {
            val x = node1?.`val` ?: 0
            val y = node2?.`val` ?: 0

            val sum = carry + x + y
            carry = sum / 10
            current.next = ListNode(sum % 10)
            current = current.next!!

            node1 = node1?.next
            node2 = node2?.next
        }

        if (carry > 0) {
            current.next = ListNode(carry)
        }

        return dummyHead.next
    }
}

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}