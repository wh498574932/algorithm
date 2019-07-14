package com.wh498574932.algorithm.lc098;

import com.wh498574932.algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 *     2
 *    / \
 *   1   3
 *
 * Input: [2,1,3]
 * Output: true
 *
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 *
 * Time:        4 ms        6.91 %      O(N)
 * Space:       39.1 MB     75.85 %     O(N)
 *
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
public class ValidateBinarySearchTree_Iter {
    public boolean isValidBST(TreeNode root) {
        if( root == null ) { return true; }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        while(!s.isEmpty() || root != null) {
            if(root != null) {
                s.push(root);
                root = root.left;
            } else {
                TreeNode n = s.pop();
                if( !list.isEmpty() && n.val <= list.get(0) ) { return false; }
                if( !list.isEmpty() ) { list.set(0, n.val); }
                else { list.add(n.val); }
                root = n.right;
            }
        }
        return true;
    }
}
