package com.wh498574932.algorithm.lc106;

import com.wh498574932.algorithm.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 *
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Time:        4 ms        48.29%      O(N)
 * Space:       36.4 MB     99.75%      O(N)
 *
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder)
    {
        if(inorder == null || postorder == null || inorder.length != postorder.length) { return null; }
        return build( inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, dic( inorder ) );
    }

    private Map<Integer, Integer> dic(int[] inorder)
    {
        Map<Integer, Integer> dic = new HashMap<>();
        for(int i = 0; i < inorder.length; ++i) { dic.put(inorder[i], i); }
        return dic;
    }

    private TreeNode build(
        int[] inorder,
        int li,
        int ri,
        int[] postorder,
        int lp,
        int rp,
        Map<Integer, Integer> dic)
    {
        if( li > ri ) { return null; }
        TreeNode n = new TreeNode( postorder[rp] );
        n.left = build(
            inorder,
            li,
            dic.get( postorder[rp] ) - 1,
            postorder,
            lp,
            lp + dic.get( postorder[rp] ) - li - 1,
            dic);
        n.right = build(
            inorder,
            dic.get( postorder[rp] ) + 1,
            ri,
            postorder,
            lp + dic.get( postorder[rp] ) - li,
            rp - 1,
            dic);
        return n;
    }
}
