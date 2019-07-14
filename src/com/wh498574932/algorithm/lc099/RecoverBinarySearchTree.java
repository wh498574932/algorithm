package com.wh498574932.algorithm.lc099;

import com.wh498574932.algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 *
 * Recover the tree without changing its structure.
 *
 * Example 1:
 *
 * Input: [1,3,null,null,2]
 *
 *    1
 *   /
 *  3
 *   \
 *    2
 *
 * Output: [3,1,null,null,2]
 *
 *    3
 *   /
 *  1
 *   \
 *    2
 *
 * Example 2:
 *
 * Input: [3,1,4,null,null,2]
 *
 *   3
 *  / \
 * 1   4
 *    /
 *   2
 *
 * Output: [2,1,4,null,null,3]
 *
 *   2
 *  / \
 * 1   4
 *    /
 *   3
 *
 * Follow up:
 *
 * A solution using O(n) space is pretty straight forward.
 * Could you devise a constant space solution?
 *
 * Time:        3 ms        28.15%      O(N)
 * Space:       44.1 MB     50.31%      O(logN)
 *
 * https://leetcode.com/problems/recover-binary-search-tree/
 */
public class RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        if( root == null ) { return; }
        List<TreeNode> err = new ArrayList<>();
        helper(err, new ArrayList<>(), root);
        if( err.size() == 4 ) { swap( err.get(0), err.get(3) ); }
        else { swap( err.get(0), err.get(1) ); }
    }

    private void helper(List<TreeNode> err, List<TreeNode> pre, TreeNode n) {
        if( n.left != null ) {
            helper( err, pre, n.left );
        }
        if( !pre.isEmpty() && pre.get(0).val >= n.val ) {
            err.add( pre.get(0) );
            err.add( n );
        }
        if( pre.isEmpty() ) { pre.add(n); }
        else { pre.set(0, n); }
        if( n.right != null ) {
            helper( err, pre, n.right );
        }
    }

    private void swap(TreeNode n1, TreeNode n2) {
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }
}
