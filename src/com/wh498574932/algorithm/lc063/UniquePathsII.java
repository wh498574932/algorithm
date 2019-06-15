package com.wh498574932.algorithm.lc063;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right
 * corner of the grid (marked 'Finish' in the diagram below).
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 *
 *
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * Note: m and n will be at most 100.
 *
 * Example 1:
 *
 * Input:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * Output: 2
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 *
 * Time:        0 ms        100.00 %    O(M*N)
 * Space:       38.7 MB     55.10 %     O(N)
 *
 * https://leetcode.com/problems/unique-paths-ii/
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if( obstacleGrid == null
            || obstacleGrid.length < 1
            || obstacleGrid[0].length < 1
            || obstacleGrid[0][0] == 1 )
        {
            return 0;
        }
        int[] dp = new int[obstacleGrid[0].length];
        dp[0] = 1;
        for(int i = 1; i < obstacleGrid[0].length; ++i) {
            if(obstacleGrid[0][i] == 1) { dp[i] = 0; break; }
            else { dp[i] = 1; }
        }
        for(int i = 1; i < obstacleGrid.length; ++i) {
            for(int j = 0; j < obstacleGrid[0].length; ++j) {
                if(obstacleGrid[i][j] == 1) { dp[j] = 0; }
                else { dp[j] += (j > 0 ? dp[j-1] : 0); }
            }
        }
        return dp[obstacleGrid[0].length-1];
    }
}
