package com.wh498574932.algorithm.lc146;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations:
 * get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it
 * should invalidate the least recently used item before inserting a new item.
 *
 * The cache is initialized with a positive capacity.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 *
 * LRUCache cache = new LRUCache( 2 );
 *
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // returns 1
 * cache.put(3,3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4,4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 *
 * Time:        15 ms       90.13%      O(1)
 * Space:       57.5 MB     61.35%      O(N)
 *
 * https://leetcode.com/problems/lru-cache/
 */
public class LRUCache {
    private int capacity;
    private Map<Integer, DoublyListNode> map;
    private DoublyListNode dummy, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.dummy = new DoublyListNode(-1, -1);
        this.tail = new DoublyListNode(-1, -1);
        dummy.next = tail;
        tail.pre = dummy;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            final DoublyListNode node = map.get(key);
            moveToHead(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        DoublyListNode node;
        if(map.containsKey(key)) {
            node = map.get(key);
            node.val = value;
            moveToHead(node);
        } else {
            node = new DoublyListNode(key, value);
            map.put(key, node);
            insertToHead(node);
        }
        if(map.keySet().size() > capacity) { removeTail(); }
    }

    private void moveToHead(DoublyListNode node) {
        if(node != dummy.next) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            insertToHead(node);
        }
    }

    private void insertToHead(DoublyListNode node) {
        node.next = dummy.next;
        dummy.next.pre = node;
        dummy.next = node;
        node.pre = dummy;
    }

    private void removeTail() {
        DoublyListNode remove = tail.pre;
        remove.pre.next = tail;
        tail.pre = remove.pre;
        map.remove(remove.key);
    }

    static class DoublyListNode {
        int key;
        int val;
        DoublyListNode pre, next;
        DoublyListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
