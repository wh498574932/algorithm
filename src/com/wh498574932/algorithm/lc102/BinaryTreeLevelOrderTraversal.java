package com.wh498574932.algorithm.lc102;

import com.wh498574932.algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * Time:        1 ms        85.04%      O(N)
 * Space:       36.5 MB     99.98%      O(N)
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) { return ret; }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while( !q.isEmpty() ) {
            int size = q.size();
            List<Integer> res = new ArrayList<>();
            for(int i = 0; i < size; ++i) {
                TreeNode n = q.poll();
                res.add(n.val);
                if( n.left != null ) { q.offer( n.left ); }
                if( n.right != null ) { q.offer( n.right ); }
            }
            ret.add(res);
        }
        return ret;
    }
}
