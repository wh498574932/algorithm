package com.wh498574932.algorithm.lc138;

import com.wh498574932.algorithm.model.list.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the
 * list or null.
 *
 * Return a deep copy of the list.
 *
 * Example 1:
 *
 * Input:
 * {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
 *
 * Explanation:
 * Node 1's value is 1, both of its next and random pointer points to Node 2.
 * Node 2's value is 2, its next pointer points to null and its random pointer points to itself.
 *
 * Note:
 *
 * You must return the copy of the given head as a reference to the cloned list.
 *
 * Time:        1 ms        74.53%      O(N)
 * Space:       34.3 MB     86.92%      O(N)
 *
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 */
public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if( head == null ) { return null; }
        Map<Node, Node> map = new HashMap<>();
        Node dummy = new Node();
        Node tail = dummy;
        Node curr = head;
        while(curr != null) {
            Node newCurr = new Node();
            newCurr.val = curr.val;
            tail.next = newCurr;
            map.put(curr, newCurr);
            curr = curr.next;
            tail = tail.next;
        }
        curr = head;
        while(curr != null) {
            if(curr.random != null) {
                map.get(curr).random = map.get(curr.random);
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
