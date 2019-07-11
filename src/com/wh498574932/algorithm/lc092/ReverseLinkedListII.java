package com.wh498574932.algorithm.lc092;

import com.wh498574932.algorithm.model.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 *
 * Note: 1 ≤ m ≤ n ≤ length of list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 *
 * Time:        0 ms        100.00%     O(N)
 * Space:       34.2 MB     100.00%     O(1)
 *
 * https://leetcode.com/problems/reverse-linked-list-ii/
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if( head == null ) { return null; }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = dummy, pre = dummy;
        for(int i = 0; i <= n - m + 1; ++i) { tail = tail.next; }
        for(int i = 1; i < m; ++i) { tail = tail.next; pre = pre.next; }
        ListNode first = pre.next, curr = first.next;
        while( curr != tail ) {
            ListNode next = curr.next;
            curr.next = pre.next;
            pre.next = curr;
            curr = next;
        }
        first.next = tail;
        return dummy.next;
    }
}
