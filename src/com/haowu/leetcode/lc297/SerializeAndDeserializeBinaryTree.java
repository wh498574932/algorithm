package com.haowu.leetcode.lc297;

import java.util.ArrayList;
import java.util.List;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be
 * stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in
 * the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your
 * serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized
 * to a string and this string can be deserialized to the original tree structure.
 */
public class SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        List<Integer> res = new ArrayList<>();
        res.add(0);
        return construct(strs, res);
    }

    private void preorder(TreeNode node, StringBuilder sb) {
        if(sb.length() != 0) {
            sb.append(',');
        }
        if(node == null) {
            sb.append('#');
        } else {
            sb.append(node.val);
            preorder(node.left, sb);
            preorder(node.right, sb);
        }
    }

    private TreeNode construct(String[] strs, List<Integer> res) {
        if(strs[res.get(0)].equals("#")) {
            res.set( 0, res.get(0) + 1 );
            return null;
        } else {
            TreeNode node = new TreeNode( Integer.parseInt(strs[res.get(0)]) );
            res.set( 0, res.get(0) + 1 );
            node.left = construct(strs, res);
            node.right = construct(strs, res);
            return node;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
