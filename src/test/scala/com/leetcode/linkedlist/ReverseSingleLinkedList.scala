package com.leetcode.linkedlist

import com.leetcode.linkedlists.SingleListNode

=> ListNode

class ReverseSingleLinkedList {
  object Solution {
    def reverseList(head: ListNode): ListNode = {
      var prev: ListNode = null
      var curr: ListNode = head
      while (curr.next != null) {
        val nextTemp: ListNode = curr.next
        curr.next = prev
        prev = curr
        curr = nextTemp
      }
      prev
    }
  }
}
