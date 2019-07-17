package com.wh498574932.algorithm.lc108;

import com.wh498574932.algorithm.model.TreeNode;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of
 * every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * Time:        0 ms        100.00%     O(N)
 * Space:       36.7 MB     100.00%     O(N)
 *
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums)
    {
        if( nums == null ) { return null; }
        return build( nums, 0, nums.length - 1 );
    }

    private TreeNode build( int[] nums, int l, int r )
    {
        if( l > r ) { return null; }
        int m = l + ( r - l ) / 2;
        TreeNode n = new TreeNode( nums[m] );
        n.left = build( nums, l, m - 1 );
        n.right = build( nums, m + 1, r );
        return n;
    }
}
