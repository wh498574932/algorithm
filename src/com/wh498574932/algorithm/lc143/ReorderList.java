package com.wh498574932.algorithm.lc143;

import com.wh498574932.algorithm.model.ListNode;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example 1:
 *
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 *
 * Example 2:
 *
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 *
 * Time:        2 ms        39.36%      O(N)
 * Space:       39.7 MB     93.18%      O(1)
 *
 * https://leetcode.com/problems/reorder-list/
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) { return; }
        ListNode walker = head.next, runner = head.next.next;
        while(runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
        }
        ListNode newHead = walker.next;
        walker.next = null;
        newHead = reverse(newHead);
        merge(head, newHead);
    }

    private ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = head, curr = head;
        while(curr.next != null) {
            ListNode next = curr.next.next;
            curr.next.next = pre;
            pre = curr.next;
            dummy.next = pre;
            curr.next = next;
        }
        return dummy.next;
    }

    private void merge(ListNode head1, ListNode head2) {
        ListNode curr1 = head1, curr2 = head2;
        while(curr1 != null && curr2 != null) {
            ListNode next = curr2.next;
            curr2.next = curr1.next;
            curr1.next = curr2;
            curr1 = curr2.next;
            curr2 = next;
        }
    }
}
