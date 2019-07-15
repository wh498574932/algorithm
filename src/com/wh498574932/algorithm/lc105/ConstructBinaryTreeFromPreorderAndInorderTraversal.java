package com.wh498574932.algorithm.lc105;

import com.wh498574932.algorithm.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Time:        3 ms        73.99%      O(N)
 * Space:       39.1 MB     18.75%      O(N)
 *
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if( preorder == null || inorder == null || preorder.length < 1 || preorder.length != inorder.length ) {
            return null;
        }
        return helper(
            preorder,
            0,
            preorder.length - 1,
            inorder,
            0,
            inorder.length - 1,
            dic( inorder )
        );
    }

    private Map<Integer, Integer> dic(int[] in) {
        Map<Integer, Integer> dic = new HashMap<>();
        for(int i = 0; i < in.length; ++i) { dic.put( in[i], i ); }
        return dic;
    }

    private TreeNode helper(int[] pre, int lp, int rp, int[] in, int li, int ri, Map<Integer, Integer> dic) {
        if( lp > rp ) { return null; }
        TreeNode n = new TreeNode( pre[lp] );
        n.left = helper(
            pre,
            lp + 1,
            lp + dic.get( pre[lp] ) - li,
            in,
            li,
            dic.get( pre[lp] ) - 1,
            dic
        );
        n.right = helper(
            pre,
            lp + dic.get( pre[lp] ) - li + 1,
            rp,
            in,
            dic.get( pre[lp] ) + 1,
            ri,
            dic);
        return n;
    }
}
