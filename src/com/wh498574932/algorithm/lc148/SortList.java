package com.wh498574932.algorithm.lc148;

import com.wh498574932.algorithm.model.ListNode;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Example 1:
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 *
 * Example 2:
 *
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 *
 * Time:        3 ms        98.09%      O(NlogN)
 * Space:       40.3 MB     85.96%      O(NlogN)
 *
 * https://leetcode.com/problems/sort-list/
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null) { return null; }
        return helper(head);
    }

    private ListNode helper(ListNode head) {
        if(head.next == null) { return head; }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode walker = dummy, runner = dummy;
        while(runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;
        }
        ListNode newHead = walker.next;
        walker.next = null;
        return merge(helper(head), helper(newHead));
    }

    private ListNode merge(ListNode n1, ListNode n2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(n1 != null && n2 != null) {
            if( n1.val <= n2.val ) {
                tail.next = n1;
                tail = tail.next;
                n1 = n1.next;
            } else {
                tail.next = n2;
                tail = tail.next;
                n2 = n2.next;
            }
        }
        if(n1 != null) {
            tail.next = n1;
        }
        if(n2 != null) {
            tail.next = n2;
        }
        return dummy.next;
    }
}
