package com.wh498574932.algorithm.lc101;

import com.wh498574932.algorithm.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

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
 * Accepted	6 ms	40.2 MB
 *
 * Feb 19th, 2019
 */
public class SymmetricTree_Iter {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root.left);
        q.offer(root.right);
        while(!q.isEmpty()) {
            TreeNode n1 = q.poll();
            TreeNode n2 = q.poll();
            if(n1 == null && n2 == null) { continue; }
            if(n1 == null || n2 == null || n1.val != n2.val) { return false; }
            q.offer(n1.left);
            q.offer(n2.right);
            q.offer(n1.right);
            q.offer(n2.left);
        }
        return true;
    }
}
