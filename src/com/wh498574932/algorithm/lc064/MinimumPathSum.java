package com.wh498574932.algorithm.lc064;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the
 * sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 *
 * Time:        2 ms        91.30%      O(M*N)
 * Space:       42.5 MB     78.55%      O(N)
 *
 * https://leetcode.com/problems/minimum-path-sum/
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if( grid == null || grid.length < 1 || grid[0].length < 1 ) {
            return 0;
        }
        int[] dp = new int[grid[0].length];
        for(int i = 0; i < grid.length; ++i) {
            for(int j = 0; j < grid[0].length; ++j) {
                dp[j] = grid[i][j] + (
                    i > 0 || j > 0 ?
                        Math.min(
                            i > 0 ? dp[j] : Integer.MAX_VALUE,
                            j > 0 ? dp[j-1] : Integer.MAX_VALUE
                        ) :
                        0
                );
            }
        }
        return dp[grid[0].length-1];
    }
}
