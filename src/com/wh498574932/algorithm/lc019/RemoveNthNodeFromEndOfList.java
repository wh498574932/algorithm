package com.wh498574932.algorithm.lc019;

import com.wh498574932.algorithm.model.ListNode;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 *
 * Given n will always be valid.
 *
 * Follow up:
 *
 * Could you do this in one pass?
 *
 * Time:        0 ms        100.00%     O(N)
 * Space:       34 MB       100.00%     O(1)
 *
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, tail = dummy;
        for(int i = 0; i < n; ++i) { tail = tail.next; }
        while( tail.next != null ) {
            pre = pre.next;
            tail = tail.next;
        }
        pre.next = pre.next.next;
        return dummy.next;
    }
}
