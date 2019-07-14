package com.wh498574932.algorithm.lc096;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * Example:
 *
 * Input: 3
 * Output: 5
 *
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * Time:        0 ms        100.00%     O(N^2)
 * Space:       33 MB       5.24%       O(N)
 *
 * https://leetcode.com/problems/unique-binary-search-trees/
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if( n == 0 ) { return 1; }
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i = 1; i <= n; ++i) {
            for(int j = 0; j < i; ++j) {
                dp[i] += (dp[j] * dp[i-j-1]);
            }
        }
        return dp[n];
    }
}
