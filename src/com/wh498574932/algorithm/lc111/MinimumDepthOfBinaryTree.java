package com.wh498574932.algorithm.lc111;

import com.wh498574932.algorithm.model.TreeNode;

/**
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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
 * return its minimum depth = 2.
 *
 * Time:        0 ms        100.00%     O(N)
 * Space:       38.2 MB     99.12%      O(N)
 *
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if( root == null ) { return 0; }
        if( root.left == null && root.right == null ) { return 1; }
        return Math.min(
            root.left == null ? Integer.MAX_VALUE : minDepth(root.left),
            root.right == null ? Integer.MAX_VALUE : minDepth(root.right)
        ) + 1;
    }
}
