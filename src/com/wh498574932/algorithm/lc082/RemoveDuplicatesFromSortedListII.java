package com.wh498574932.algorithm.lc082;

import com.wh498574932.algorithm.model.ListNode;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the
 * original list.
 *
 * Example 1:
 *
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 *
 * Example 2:
 *
 * Input: 1->1->1->2->3
 * Output: 2->3
 *
 * Time:        1 ms        81.80%      O(N)
 * Space:       36.1 MB     100.00%     O(1)
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) { return null; }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while( pre != null && pre.next != null ) {
            ListNode curr = pre.next;
            while( curr.next != null && curr.val == curr.next.val ) { curr = curr.next; }
            if( curr != pre.next ) { pre.next = curr.next; }
            else { pre = pre.next; }
        }
        return dummy.next;
    }
}
