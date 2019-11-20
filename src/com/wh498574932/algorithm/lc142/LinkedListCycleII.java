package com.wh498574932.algorithm.lc142;

import com.wh498574932.algorithm.model.ListNode;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the
 * linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 *
 * Note: Do not modify the linked list.
 *
 * Example 1:
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 * Example 2:
 *
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 * Example 3:
 *
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 *
 * Follow-up:
 * Can you solve it without using extra space?
 *
 * Time:        0 ms        100.00%     O(N)
 * Space:       34.4 MB     95.79%      O(1)
 *
 * https://leetcode.com/problems/linked-list-cycle-ii/
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) { return null; }
        ListNode walker = head.next, runner = head.next.next;
        while(runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if(runner == walker) {
                walker = head;
                while(walker != runner) {
                    walker = walker.next;
                    runner = runner.next;
                }
                return walker;
            }
        }
        return null;
    }
}
