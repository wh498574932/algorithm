package com.wh498574932.algorithm.lc023;

import com.wh498574932.algorithm.model.ListNode;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 *
 * Time:        2 ms        99.83%      O(NlogK)
 * Space:       39 MB       58.04%      O(logK)
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if( lists == null || lists.length < 1 ) { return null; }
        return helper( lists, 0, lists.length - 1 );
    }

    private ListNode helper(ListNode[] lists, int l, int r) { // O(logK)
        if( l == r ) { return lists[l]; }
        int m = (l + r) / 2;
        return merge(
            helper( lists, l, m ),
            helper( lists, m + 1, r )
        );
    }

    private ListNode merge(ListNode l1, ListNode l2) { //O(N)
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
