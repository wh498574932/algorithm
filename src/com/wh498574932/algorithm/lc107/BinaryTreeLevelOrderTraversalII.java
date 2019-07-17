package com.wh498574932.algorithm.lc107;

import com.wh498574932.algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level
 * by level from leaf to root).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * Time:        1 ms        96.13%      O(N)
 * Space:       36.3 MB     99.94%      O(N)
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root)
    {
        List<List<Integer>> ret = new ArrayList<>();
        if( root == null ) { return ret; }
        Queue<TreeNode> q = new LinkedList<>();
        Stack<List<Integer>> res = new Stack<>();
        q.offer(root);
        while( !q.isEmpty() )
        {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; ++i) {
                TreeNode n = q.poll();
                list.add( n.val );
                if( n.left != null ) { q.offer( n.left ); }
                if( n.right != null ) { q.offer( n.right ); }
            }
            res.push(list);
        }
        while( !res.isEmpty() ) { ret.add( res.pop() ); }
        return ret;
    }
}
