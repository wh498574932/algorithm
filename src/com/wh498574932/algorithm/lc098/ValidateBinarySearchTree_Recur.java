package com.wh498574932.algorithm.lc098;

import com.wh498574932.algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
 * Time:        1 ms        39.08%      O(N)
 * Space:       38.8 MB     77.13%      O(N)
 *
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
public class ValidateBinarySearchTree_Recur {
    public boolean isValidBST(TreeNode root) {
        if( root == null ) { return true; }
        return helper(new ArrayList<>(), root);
    }

    private boolean helper(List<Integer> pre, TreeNode n) {
        if( n.left != null ) {
            if( !helper( pre, n.left ) ) { return false; }
        }
        if( !pre.isEmpty() && n.val <= pre.get(0) ) { return false; }
        if( pre.isEmpty() ) { pre.add(n.val); }
        else { pre.set(0, n.val); }
        if( n.right != null ) { return helper( pre, n.right ); }
        return true;
    }
}
