package com.wh498574932.algorithm.lc199;

import com.wh498574932.algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null) {
            return ret;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; ++i) {
                TreeNode n = q.poll();
                if(i == 0) {
                    ret.add(n.val);
                }
                if(n.right != null) {
                    q.offer(n.right);
                }
                if(n.left != null) {
                    q.offer(n.left);
                }
            }
        }
        return ret;
    }
}
