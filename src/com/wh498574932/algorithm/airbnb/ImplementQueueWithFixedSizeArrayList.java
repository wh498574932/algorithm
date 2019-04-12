package com.wh498574932.algorithm.airbnb;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement a queue with a number of arrays, in which each array has fixed size.
 */
public class ImplementQueueWithFixedSizeArrayList {
    private int arraySize;
    private int size;
    private ListNode head;
    private ListNode tail;

    public ImplementQueueWithFixedSizeArrayList(int arraySize) {
        this.arraySize = arraySize;
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public void offer(int val) {
        if(isEmpty()) {
            head = tail = new ListNode(new ArrayList<>());
        }
        if(tail.list.size() == arraySize) {
            tail.next = new ListNode( new ArrayList<>() );
            tail.next.list.add(val);
            tail = tail.next;
        } else {
            tail.list.add(val);
        }
        size++;
    }

    public int poll() {
        if(isEmpty()) {
            throw new RuntimeException("Queue is Empty!");
        }
        int val = head.list.get(0);
        head.list.remove(0);
        if(head.list.size() == 0) {
            head = head.next;
        }
        size--;
        if(isEmpty()) {
            tail = null;
        }
        return val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    class ListNode {
        List<Integer> list;
        ListNode next;
        ListNode(List<Integer> list) {
            this.list = list;
            this.next = null;
        }
    }

    void print() {
        if(isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.println("Printing queue...");
        ListNode curr = head;
        while(curr != null) {
            curr.list.forEach(System.out::print);
            System.out.print(" -> ");
            curr = curr.next;
            System.out.println();
        }
    }
}
