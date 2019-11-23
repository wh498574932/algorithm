package com.wh498574932.algorithm.lc144;

import com.wh498574932.algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,2,3]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 *
 * Time:        0 ms        100.00%     O(N)
 * Space:       34.7 MB     100.00%     O(N)
 *
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 */
public class BinaryTreePreorderTraversal_recur {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        preorder(root, ret);
        return ret;
    }

    private void preorder(TreeNode node, List<Integer> ret) {
        if(node == null) { return; }
        ret.add( node.val );
        preorder(node.left, ret);
        preorder(node.right, ret);
    }
}
