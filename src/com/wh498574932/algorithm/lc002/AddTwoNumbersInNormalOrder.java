package com.wh498574932.algorithm.lc002;

import com.wh498574932.algorithm.model.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in normal
 * order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class AddTwoNumbersInNormalOrder {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) { return null; }
        if(l1 == null) { return l2; }
        if(l2 == null) { return l1; }
        ListNode counter = l1;
        int cnt1 = 0;
        while(counter != null) {
            cnt1++;
            counter = counter.next;
        }
        counter = l2;
        int cnt2 = 0;
        while(counter != null) {
            cnt2++;
            counter = counter.next;
        }
        ListNode longer = cnt1 > cnt2 ? l1 : l2;
        ListNode shorter = cnt1 > cnt2 ? l2 : l1;
        List<Integer> carry = new ArrayList<>();
        carry.add(0);
        ListNode node = helper(longer, shorter, Math.abs(cnt1-cnt2), carry);
        if(carry.get(0) > 0) {
            ListNode head = new ListNode(carry.get(0));
            head.next = node;
            return head;
        }
        return node;
    }

    private ListNode helper(ListNode longer, ListNode shorter, int diff, List<Integer> carry) {
        ListNode next = null;
        if(longer.next != null && shorter.next != null) {
            next = helper(
                longer.next,
                diff <= 0 ? shorter.next : shorter,
                diff-1,
                carry
            );
        }
        int val = carry.get(0) + longer.val + (diff <= 0 ? shorter.val : 0);
        carry.set(0, val/10);
        ListNode node = new ListNode(val % 10);
        node.next = next;
        return node;
    }
}
