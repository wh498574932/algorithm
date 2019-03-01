package com.wh498574932.algorithm.lc101;

import com.wh498574932.algorithm.model.TreeNode;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric.
 *
 * But the following [1,2,2,null,3,null,3] is not.
 *
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 *
 * https://leetcode.com/problems/symmetric-tree/
 *
 * Accepted	5 ms	39.8 MB
 *
 * Feb 19th, 2019
 */
public class SymmetricTree_Recur {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode n1, TreeNode n2) {
        if(n1 == null && n2 == null) {
            return true;
        }
        if(n1 == null || n2 == null) {
            return false;
        }
        return n1.val == n2.val && helper(n1.left, n2.right) && helper(n1.right, n2.left);
    }
}
