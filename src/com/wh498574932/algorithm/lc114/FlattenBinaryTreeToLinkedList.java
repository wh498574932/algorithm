package com.wh498574932.algorithm.lc114;

import com.wh498574932.algorithm.model.TreeNode;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example, given the following tree:
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 *
 * The flattened tree should look like:
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * Time:        0 ms        100.00%     O(N)
 * Space:       35.9 MB     100.00%     O(N)
 *
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root)
    {
        if( root == null ) { return; }
        helper(root);
    }

    private TreeNode helper(TreeNode n)
    {
        TreeNode next = n.right;
        TreeNode ret = n;
        if(n.left != null)
        {
            TreeNode left = helper(n.left);
            n.right = n.left;
            n.left = null;
            left.right = next;
            ret = left;
        }
        return next == null ? ret : helper(next);
    }
}
