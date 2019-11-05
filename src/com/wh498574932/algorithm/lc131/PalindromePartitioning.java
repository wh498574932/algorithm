package com.wh498574932.algorithm.lc131;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * Example:
 *
 * Input: "aab"
 * Output:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 * Time:        2 ms        96.78%      O(N^2)
 * Space:       38.1 MB     100.00%     O(N^2)
 *
 * https://leetcode.com/problems/palindrome-partitioning/
 */
public class PalindromePartitioning
{
    public List<List<String>> partition(String s)
    {
        List<List<String>> ret = new ArrayList<>();
        if( s == null || s.length() < 1 ) { return ret; }
        helper( ret, new ArrayList<>(), 0, s, palDic(s) );
        return ret;
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

    private void helper(
        List<List<String>> ret,
        List<String> res,
        int start,
        String s,
        boolean[][] dp)
    {
        if( start == s.length() )
        {
            ret.add( new ArrayList<>(res) );
            return;
        }
        for(int i = start; i < s.length(); ++i)
        {
            if(dp[start][i])
            {
                res.add( s.substring(start, i+1) );
                helper(ret, res, i+1, s, dp);
                res.remove( res.size()-1 );
            }
        }
    }
}