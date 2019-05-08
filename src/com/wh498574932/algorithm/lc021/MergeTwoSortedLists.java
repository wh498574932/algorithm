package com.wh498574932.algorithm.lc021;

import com.wh498574932.algorithm.model.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes
 * of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 *
 * Time:        1 ms        82.57%      O(N)
 * Space:       39.6 MB     73.01%      O(1)
 *
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while( l1 != null && l2 != null ) {
            if( l1.val < l2.val ) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if( l1 != null ) { tail.next = l1; }
        if( l2 != null ) { tail.next = l2; }
        return dummy.next;
    }
}
