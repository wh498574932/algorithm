package com.wh498574932.algorithm.lc087;

/**
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 *
 * Below is one possible representation of s1 = "great":
 *
 *     great
 *    /    \
 *   gr    eat
 *  / \    /  \
 * g   r  e   at
 *            / \
 *           a   t
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 *
 * For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
 *
 *     rgeat
 *    /    \
 *   rg    eat
 *  / \    /  \
 * r   g  e   at
 *            / \
 *           a   t
 * We say that "rgeat" is a scrambled string of "great".
 *
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
 *
 *     rgtae
 *    /    \
 *   rg    tae
 *  / \    /  \
 * r   g  ta  e
 *        / \
 *       t   a
 * We say that "rgtae" is a scrambled string of "great".
 *
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 *
 * Example 1:
 *
 * Input: s1 = "great", s2 = "rgeat"
 * Output: true
 *
 * Example 2:
 *
 * Input: s1 = "abcde", s2 = "caebd"
 * Output: false
 *
 * Time:        12 ms       16.25%      O(N^4)
 * Space:       36.3 MB     100.00%     O(N^3)
 *
 * https://leetcode.com/problems/scramble-string/
 */
public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if( s1 == null || s2 == null || s1.length() != s2.length() ) { return false; }
        boolean[][][] dp = new boolean[s1.length()][s2.length()][s1.length()+1];
        for(int i = 0; i < s1.length(); ++i) {
            for(int j = 0; j < s2.length(); ++j) {
                dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }
        for(int len = 2; len <= s1.length(); ++len) {
            for(int i = 0; i <= s1.length()-len; ++i) {
                for(int j = 0; j <= s2.length()-len; ++j) {
                    for(int k = 1; k <= len-1; ++k) {
                        dp[i][j][len] |= dp[i][j][k] && dp[i+k][j+k][len-k] || dp[i][j+len-k][k] && dp[i+k][j][len-k];
                    }
                }
            }
        }
        return dp[0][0][s1.length()];
    }
}
