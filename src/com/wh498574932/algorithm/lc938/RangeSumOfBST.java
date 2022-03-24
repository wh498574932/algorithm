package com.wh498574932.algorithm.lc938;

import com.wh498574932.algorithm.model.TreeNode;

public class RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null) return 0;
        if(low>root.val) return rangeSumBST(root.right, low, high);
        if(high<root.val) return rangeSumBST(root.left, low, high);
        return root.val+  rangeSumBST(root.right, low, high)+rangeSumBST(root.left, low, high);
    }
}
