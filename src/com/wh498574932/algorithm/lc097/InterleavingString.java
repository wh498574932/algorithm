package com.wh498574932.algorithm.lc097;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 *
 * Example 1:
 *
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 *
 * Example 2:
 *
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 *
 * Time:        2 ms        87.16%      O(M*N)
 * Space:       34.5 MB     100.00%     O(M*N)
 *
 * https://leetcode.com/problems/interleaving-string/
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null || s1.length() + s2.length() != s3.length()) { return false; }
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        for(int i = 0; i < s1.length(); ++i) {
            dp[i+1][0] = s1.charAt(i) == s3.charAt(i) && dp[i][0];
        }
        for(int i = 0; i < s2.length(); ++i) {
            dp[0][i+1] = s2.charAt(i) == s3.charAt(i) && dp[0][i];
        }
        for(int i = 0; i < s1.length(); ++i) {
            for(int j = 0; j < s2.length(); ++j) {
                dp[i+1][j+1] = dp[i][j+1] && s1.charAt(i) == s3.charAt(i+j+1) ||
                    dp[i+1][j] && s2.charAt(j) == s3.charAt(i+j+1);
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
