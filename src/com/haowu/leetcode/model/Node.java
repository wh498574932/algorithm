package com.haowu.leetcode.model;

public class Node {
    public int val;
    public Node left, right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
