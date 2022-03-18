package com.wh498574932.algorithm.lc236;

import com.wh498574932.algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list = new ArrayList<>();
        helper(root, p, q, list);
        return list.get(0);
    }

    private int helper(final TreeNode node, final TreeNode p, final TreeNode q, final List<TreeNode> found) {
        int cnt = 0;
        if(node.left != null) {
            cnt += helper(node.left, p, q, found);
        }
        if(!found.isEmpty()) {
            return -1;
        } else if(cnt == 1 && (p == node || q == node)) {
            found.add(node);
            return -1;
        }
        if(node.right != null) {
            cnt += helper(node.right, p, q, found);
        }
        if(!found.isEmpty()) {
            return -1;
        } else if(cnt == 1 && (p == node || q == node)) {
            found.add(node);
            return -1;
        }
        if(cnt == 2) {
            found.add(node);
            return -1;
        } else {
            return p == node || q == node ? 1 : cnt;
        }
    }
}
