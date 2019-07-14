package com.wh498574932.algorithm.lc094;

import com.wh498574932.algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
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
 * Output: [1,3,2]
 *
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 *
 * Time:        0 ms        100.00%     O(N)
 * Space:       34.7 MB     99.98%      O(N)
 *
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class BinaryTreeInorderTraversal_Recur {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if( root == null ) { return ret; }
        helper(ret, root);
        return ret;
    }

    private void helper(List<Integer> ret, TreeNode node) {
        if( node == null ) { return; }
        helper(ret, node.left);
        ret.add(node.val);
        helper(ret, node.right);
    }
}
