package com.wh498574932.algorithm.lc132;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 * Example:
 *
 * Input: "aab"
 * Output: 1
 *
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 *
 * Time:        11 ms       48.66%      O(N^2)
 * Space:       35.5 MB     70.83%      O(N^2)
 *
 * https://leetcode.com/problems/palindrome-partitioning-ii/
 */
public class PalindromePartitioningII
{
    public int minCut(String s)
    {
        if(s == null || s.length() < 1) { return 0; }
        boolean[][] palDic = palDic(s);
        int[] dp = new int[s.length() + 1];
        for(int i = 0; i < s.length(); ++i)
        {
            dp[i+1] = i+1;
            for(int j = 0; j <= i; ++j)
            {
                if(palDic[j][i])
                {
                    dp[i+1] = Math.min( dp[i+1], dp[j] + 1 );
                }
            }
        }
        return dp[s.length()]-1;
    }

    private boolean[][] palDic(String s)
    {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = s.length() - 1; i >= 0; i--)
        {
            for(int j = i; j < s.length(); ++j)
            {
                dp[i][j] = s.charAt(i) == s.charAt(j) && ( j - i <= 2 || dp[i+1][j-1] );
            }
        }
        return dp;
    }
}
