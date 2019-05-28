package com.wh498574932.algorithm.lc044;

/**
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 *
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like ? or *.
 *
 * Example 1:
 *
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 *
 * Example 2:
 *
 * Input:
 * s = "aa"
 * p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 *
 * Example 3:
 *
 * Input:
 * s = "cb"
 * p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 *
 * Example 4:
 *
 * Input:
 * s = "adceb"
 * p = "*a*b"
 * Output: true
 * Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
 *
 * Example 5:
 *
 * Input:
 * s = "acdcb"
 * p = "a*c?b"
 * Output: false
 *
 * Time:        13 ms       66.33%      O(M*N)
 * Space:       37.7 MB     97.65%      O(M*N)
 *
 * https://leetcode.com/problems/wildcard-matching/
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        if( s == null || p == null ) { return false; }
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for(int i = 0; i < p.length(); ++i) {
            if(p.charAt(i) == '*') { dp[0][i+1] = true; }
            else { break; }
        }
        for(int i = 0; i < s.length(); ++i) {
            for(int j = 0; j < p.length(); ++j) {
                if(p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)) { dp[i+1][j+1] = dp[i][j]; }
                else if(p.charAt(j) == '*') { dp[i+1][j+1] = dp[i+1][j] || dp[i][j+1]; }
            }
        }
        return dp[s.length()][p.length()];
    }
}
