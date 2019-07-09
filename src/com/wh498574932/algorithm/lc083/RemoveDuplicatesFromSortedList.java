package com.wh498574932.algorithm.lc083;

import com.wh498574932.algorithm.model.ListNode;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 *
 * Input: 1->1->2
 * Output: 1->2
 *
 * Example 2:
 *
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 *
 * Time:        1 ms        38.92%      O(N)
 * Space:       36.9 MB     99.88%      O(1)
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if( head == null ) { return null; }
        ListNode pre = head;
        while( pre != null ) {
            ListNode curr = pre;
            while( curr.next != null && curr.val == curr.next.val ) { curr = curr.next; }
            pre.next = curr.next;
            pre = pre.next;
        }
        return head;
    }
}
