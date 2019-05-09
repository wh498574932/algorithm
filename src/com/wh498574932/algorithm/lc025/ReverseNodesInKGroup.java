package com.wh498574932.algorithm.lc025;

import com.wh498574932.algorithm.model.ListNode;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a
 * multiple of k then left-out nodes in the end should remain as it is.
 *
 * Example:
 *
 * Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return: 2->1->4->3->5
 *
 * For k = 3, you should return: 3->2->1->4->5
 *
 * Note:
 *
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 *
 * Time:        0 ms        100.00%     O(N)
 * Space:       35.2 MB     100.00%     O(1)
 *
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if( k < 2 ) { return head; }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while( pre != null ) {
            ListNode end = pre;
            for(int i = 0; i < k; ++i) {
                if( end.next != null ) { end = end.next; }
                else { return dummy.next; }
            }
            pre = reverse(pre, end);
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode pre, ListNode end) {
        ListNode next = pre.next, curr = pre.next;
        while( curr != end ) {
            pre.next = curr.next;
            curr.next = end.next;
            end.next = curr;
            curr = pre.next;
        }
        return next;
    }
}
