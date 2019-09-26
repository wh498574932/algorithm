package com.wh498574932.algorithm.lc124;

import com.wh498574932.algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the
 * parent-child connections. The path must contain at least one node and does not need to go through the root.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * Output: 6
 *
 * Example 2:
 *
 * Input: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Output: 42
 *
 * Time:        1 ms        100.00%     O(N)
 * Space:       40.3 MB     95.24%      O(N)
 *
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        if(root == null) { return 0; }
        List<Integer> list = new ArrayList<>();
        list.add(Integer.MIN_VALUE);
        helper(list, root);
        return list.get(0);
    }

    private int helper(List<Integer> list, TreeNode node) {
        int max = node.val;
        int left = node.left != null ? Math.max(0, helper(list, node.left)) : 0;
        int right = node.right != null ? Math.max(0, helper(list, node.right)) : 0;
        max += (left + right);
        if( max > list.get(0) ) { list.set(0, max); }
        return node.val + Math.max(left, right);
    }
}
