package com.wh498574932.algorithm.lc005;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Time:    50 ms       38.27%      O(N^2)
 * Space:   40.6 MB     8.68%       O(N^2)
 *
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring_dp {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max = 0;
        String ret = "";
        for(int i = s.length()-1; i >= 0; --i) {
            for(int j = i; j < s.length(); ++j) {
                if( s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i+1][j-1]) ) {
                    dp[i][j] = true;
                    if( j - i + 1 > max ) {
                        max = j - i + 1;
                        ret = s.substring( i, j + 1 );
                    }
                }
            }
        }
        return ret;
    }
}
