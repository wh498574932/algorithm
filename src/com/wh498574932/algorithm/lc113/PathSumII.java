package com.wh498574932.algorithm.lc113;

import com.wh498574932.algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * Return:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * Time:        1 ms        100.00%     O(N)
 * Space:       37.7 MB     100.00%     O(N)
 *
 * https://leetcode.com/problems/path-sum-ii/
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum)
    {
        List<List<Integer>> ret = new ArrayList<>();
        if( root == null ) { return ret; }
        helper( ret, new ArrayList<>(), root, sum );
        return ret;
    }

    private void helper(
        List<List<Integer>> ret,
        List<Integer> res,
        TreeNode n,
        int sum)
    {
        res.add( n.val );
        if( n.left == null && n.right == null )
        {
            if( n.val == sum ) { ret.add( new ArrayList<>(res) ); }
        }
        else
        {
            if( n.left != null ) { helper( ret, res, n.left, sum - n.val ); }
            if( n.right != null ) { helper( ret, res, n.right, sum - n.val ); }
        }
        res.remove( res.size() - 1 );
    }
}
