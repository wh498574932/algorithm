package com.wh498574932.algorithm.lc061;

import com.wh498574932.algorithm.model.ListNode;

/**
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 *
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 *
 * Example 2:
 *
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 *
 * Time:        0 ms        100.00%     O(N)
 * Space:       35.8 MB     100.00%     O(1)
 *
 * https://leetcode.com/problems/rotate-list/
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if( head == null || k == 0 ) { return head; }
        ListNode walk = head;
        int len = 1;
        while( walk.next != null ) {
            walk = walk.next;
            len++;
        }
        k %= len;
        if( k == 0 ) { return head; }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode run = walk = dummy;
        for(int i = 0; i < k; ++i) { run = run.next; }
        while( run.next != null ) { run = run.next; walk = walk.next; }
        run.next = dummy.next;
        dummy.next = walk.next;
        walk.next = null;
        return dummy.next;
    }
}
