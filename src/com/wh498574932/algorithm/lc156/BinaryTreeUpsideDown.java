package com.wh498574932.algorithm.lc156;

import com.wh498574932.algorithm.model.TreeNode;

/**
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same
 * parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf
 * nodes. Return the new root.
 *
 * Example:
 *
 * Input: [1,2,3,4,5]
 *
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 *
 * Output: return the root of the binary tree [4,5,2,#,#,3,1]
 *
 *    4
 *   / \
 *  5   2
 *     / \
 *    3   1
 * Clarification:
 *
 * Confused what [4,5,2,#,#,3,1] means? Read more below on how binary tree is serialized on OJ.
 *
 * The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node
 * exists below.
 *
 * Here's an example:
 *
 *    1
 *   / \
 *  2   3
 *     /
 *    4
 *     \
 *      5
 * The above binary tree is serialized as [1,2,3,#,#,4,#,#,5].
 *
 * https://leetcode.com/problems/binary-tree-upside-down/
 */
public class BinaryTreeUpsideDown {
    public TreeNode upsideDownBinaryTree(final TreeNode root) {
        if(root == null) { return null; }
        if(root.left == null) { return root; }
        TreeNode ret = upsideDownBinaryTree(root.left);
        TreeNode left = root.right;
        TreeNode head = root.left;
        head.left = left;
        head.right = root;
        root.left = null;
        root.right = null;
        return ret;
    }
}
