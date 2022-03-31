package com.wh498574932.algorithm.lc543;

import com.wh498574932.algorithm.model.TreeNode;

public class DiameterOfBinaryTree {
    private int max;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode n) {
        if(n == null) {
            return 0;
        }
        int left = helper(n.left);
        int right = helper(n.right);
        max = Math.max(max, left+right);
        return Math.max(left, right) + 1;
    }
}
