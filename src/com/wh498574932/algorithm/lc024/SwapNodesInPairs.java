package com.wh498574932.algorithm.lc024;

import com.wh498574932.algorithm.model.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * Time:        0 ms        100.00%     O(N)
 * Space:       33.6 MB     100.00%     O(1)
 *
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, end = dummy;
        while( pre.next != null && pre.next.next != null ) {
            end = pre.next.next;
            pre.next.next = end.next;
            end.next = pre.next;
            pre.next = end;
            pre = pre.next.next;
        }
        return dummy.next;
    }
}
