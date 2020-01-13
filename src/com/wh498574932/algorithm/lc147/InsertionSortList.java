package com.wh498574932.algorithm.lc147;

import com.wh498574932.algorithm.model.ListNode;

/**
 * Sort a linked list using insertion sort.
 *
 * A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
 * With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list
 *
 * Algorithm of Insertion Sort:
 *
 * Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
 * At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted
 * list, and inserts it there.
 * It repeats until no input elements remain.
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
 * Time:        31 ms       48.68%      O(N^2)
 * Space:       36.8 MB     100.00%     O(1)
 *
 * https://leetcode.com/problems/insertion-sort-list/
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head == null) { return null; }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head;
        while(curr.next != null) {
            ListNode insert = dummy;
            while(insert != curr && curr.next.val >= insert.next.val) {
                insert = insert.next;
            }
            if( insert == curr ) {
                curr = curr.next;
            } else {
                ListNode currNext = curr.next.next;
                curr.next.next = insert.next;
                insert.next = curr.next;
                curr.next = currNext;
            }
        }
        return dummy.next;
    }
}
