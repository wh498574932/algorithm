package com.wh498574932.algorithm.lc110;

import com.wh498574932.algorithm.model.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example 1:
 *
 * Given the following tree [3,9,20,null,null,15,7]:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Return true.
 *
 * Example 2:
 *
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * Return false.
 *
 * Time:        1 ms        94.16%      O(N)
 * Space:       38.5 MB     89.03%      O(N)
 *
 * https://leetcode.com/problems/balanced-binary-tree/
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }

    private int depth(TreeNode n) {
        if( n == null ) { return 0; }
        int l = depth( n.left );
        int r = depth( n.right );
        if( l == -1 || r == -1 || Math.abs(l - r) > 1 ) { return -1; }
        return Math.max(l, r) + 1;
    }
}
