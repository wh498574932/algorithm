package com.wh498574932.algorithm.lc086;

import com.wh498574932.algorithm.model.ListNode;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal
 * to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Example:
 *
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 *
 * Time:        0 ms        100.00%     O(N)
 * Space:       36 MB       100.00%     O(1)
 *
 * https://leetcode.com/problems/partition-list/
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head == null) { return null; }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, tail = dummy;
        while(pre.next != null) {
            if( pre.next.val < x ) {
                if( pre != tail ) {
                    ListNode next = pre.next.next;
                    pre.next.next = tail.next;
                    tail.next = pre.next;
                    pre.next = next;
                    tail = tail.next;
                } else {
                    tail = tail.next;
                    pre = pre.next;
                }
            } else {
                pre = pre.next;
            }
        }
        return dummy.next;
    }
}
