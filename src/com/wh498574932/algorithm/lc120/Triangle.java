package com.wh498574932.algorithm.lc120;

import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row
 * below.
 *
 * For example, given the following triangle
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * Note:
 *
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 *
 * Time:        2 ms        83.76%      O(N^2)
 * Space:       37.2 MB     98.78%      O(N)
 *
 * https://leetcode.com/problems/triangle/
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.get(triangle.size()-1).size()];
        for(int i = 0; i < dp.length; ++i ) { dp[i] = triangle.get(triangle.size()-1).get(i); }
        for(int i = triangle.size()-2; i >= 0; --i) {
            for(int j = 0; j < triangle.get(i).size(); ++j) {
                dp[j] = Math.min( dp[j], dp[j+1] ) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
