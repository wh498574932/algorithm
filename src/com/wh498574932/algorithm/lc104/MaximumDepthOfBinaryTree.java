package com.wh498574932.algorithm.lc104;

import com.wh498574932.algorithm.model.TreeNode;

/**
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its depth = 3.
 *
 * Time:        0 ms        100.00%     O(N)
 * Space:       38.6 MB     97.85%      O(N)
 *
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null) { return 0; }
        return Math.max( maxDepth(root.left), maxDepth(root.right) ) + 1;
    }
}
