package com.wh498574932.algorithm.lc094;

import com.wh498574932.algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
 * Time:        1 ms        55.06%      O(N)
 * Space:       34.7 MB     99.98%      O(N)
 *
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class BinaryTreeInorderTraversal_Iter {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null) { return ret; }
        Stack<TreeNode> s = new Stack<>();
        while(!s.isEmpty() || root != null) {
            if( root != null ) { s.push(root); root = root.left; }
            else { TreeNode n = s.pop(); ret.add(n.val); root = n.right; }
        }
        return ret;
    }
}
