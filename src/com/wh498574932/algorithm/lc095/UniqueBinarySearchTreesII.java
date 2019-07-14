package com.wh498574932.algorithm.lc095;

import com.wh498574932.algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 *
 * Example:
 *
 * Input: 3
 * Output:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 *
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * Time:        2 ms        73.33%      Exponential
 * Space:       39.5 MB     57.90%      Exponential
 *
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ret = new ArrayList<>();
        if( n == 0 ) { return ret; }
        return helper(1, n);
    }

    private List<TreeNode> helper(int l, int r) {
        List<TreeNode> ret = new ArrayList<>();
        if( l > r ) { ret.add( null ); return ret; }
        for(int i = l; i <= r; ++i) {
            for( TreeNode left : helper( l, i - 1 ) ) {
                for( TreeNode right : helper( i + 1, r ) ) {
                    TreeNode n = new TreeNode(i);
                    n.left = left;
                    n.right = right;
                    ret.add(n);
                }
            }
        }
        return ret;
    }
}
