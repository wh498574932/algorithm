package com.wh498574932.algorithm.lc145;

import com.wh498574932.algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal_recur {
    public List<Integer> postorderTraversal(TreeNode root) {
        final List<Integer> ret = new ArrayList<>();
        helper(ret, root);
        return ret;
    }

    private void helper(final List<Integer> ret, final TreeNode node) {
        if( node == null ) {
            return;
        }
        helper(ret, node.left);
        helper(ret, node.right);
        ret.add(node.val);
    }
}
