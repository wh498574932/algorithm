package com.wh498574932.algorithm.utilities;

import com.wh498574932.algorithm.model.ListNode;

/**
 * Utility Class for LinkedList
 */
public class LinkedList {

    /**
     * Utility Method for Creating LinkedList for given array of integers.
     * @param nums array of {@code Integer}s.
     * @return head {@code ListNode} for the LinkedList created.
     */
    public static ListNode createLinkedList(int[] nums) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for(int val : nums) {
            tail.next = new ListNode(val);
            tail = tail.next;
        }
        return dummy.next;
    }

    /**
     * Validate Two LinkedList are equal to each other or not.
     * @param n1 head {@code ListNode} of the first LinkedList.
     * @param n2 head {@code ListNode} of the second LinkedList.
     * @return whether the two LinkedList are equal to each other or not.
     */
    public static boolean validateTwoLinkedList(ListNode n1, ListNode n2) {
        while(n1 != null || n2 != null) {
            if(n1 == null || n2 == null || n1.val != n2.val) { return false; }
            n1 = n1.next;
            n2 = n2.next;
        }
        return true;
    }
}
