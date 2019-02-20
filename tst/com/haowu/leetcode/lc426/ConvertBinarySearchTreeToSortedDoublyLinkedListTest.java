package com.haowu.leetcode.lc426;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.haowu.leetcode.model.Node;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class ConvertBinarySearchTreeToSortedDoublyLinkedListTest {
    @Test
    public void test() {
        Node head = new ConvertBinarySearchTreeToSortedDoublyLinkedList().treeToDoublyList(buildTree());
        List<Integer> first = new ArrayList<>();
        Node firstNode = head;
        Node secondNode = head;
        List<Integer> second = new ArrayList<>();
        for(int i = 0; i < 6; ++i) {
            first.add(firstNode.val);
            second.add(secondNode.val);
            firstNode = firstNode.right;
            secondNode = secondNode.left;
        }
        for(int i = 0; i < 6; ++i) {
            assertEquals(first.get(i), second.get(5-i));
        }
    }

    @Test
    public void nullTest() {
        assertNull(new ConvertBinarySearchTreeToSortedDoublyLinkedList().treeToDoublyList(null));
    }

    private Node buildTree() {
        Node one = new Node(1, null, null);
        Node three = new Node(3, null, null);
        Node two = new Node(2, one, three);
        Node five = new Node(5, null, null);
        return new Node(4, two, five);
    }
}
