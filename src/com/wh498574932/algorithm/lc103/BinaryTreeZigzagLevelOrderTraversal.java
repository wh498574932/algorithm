package com.wh498574932.algorithm.lc103;

import com.wh498574932.algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right
 * to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * Time:        1 ms        88.57%      O(N)
 * Space:       36.2 MB     99.93%      O(N)
 *
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if( root == null ) { return ret; }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        int lvl = 0;
        while( !s1.isEmpty() || !s2.isEmpty() ) {
            Stack<TreeNode> s = lvl % 2 == 0 ? s1 : s2;
            List<Integer> res = new ArrayList<>();
            while( !s.isEmpty() ) {
                TreeNode n = s.pop();
                res.add(n.val);
                if( lvl % 2 == 0 ) {
                    if( n.left != null ) { s2.push(n.left); }
                    if( n.right != null ) { s2.push(n.right); }
                } else {
                    if( n.right != null ) { s1.push(n.right); }
                    if( n.left != null ) { s1.push(n.left); }
                }
            }
            ret.add(res);
            lvl++;
        }
        return ret;
    }
}
