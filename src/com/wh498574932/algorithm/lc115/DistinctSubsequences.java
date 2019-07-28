package com.wh498574932.algorithm.lc115;

/**
 * Given a string S and a string T, count the number of distinct subsequences of S which equals T.
 *
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of
 * the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of
 * "ABCDE" while "AEC" is not).
 *
 * Example 1:
 *
 * Input: S = "rabbbit", T = "rabbit"
 * Output: 3
 *
 * Explanation:
 *
 * As shown below, there are 3 ways you can generate "rabbit" from S.
 * (The caret symbol ^ means the chosen letters)
 *
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 * Example 2:
 *
 * Input: S = "babgbag", T = "bag"
 * Output: 5
 *
 * Explanation:
 *
 * As shown below, there are 5 ways you can generate "bag" from S.
 * (The caret symbol ^ means the chosen letters)
 *
 * babgbag
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 * ^    ^^
 * babgbag
 *   ^  ^^
 * babgbag
 *     ^^^
 *
 * Time:        5 ms        73.66%      O(M*N)
 * Space:       35.9 MB     94.22%      O(M*N)
 *
 * https://leetcode.com/problems/distinct-subsequences/
 */
public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        if( s == null || t == null || s.length() < 1 || s.length() < t.length() ) { return 0; }
        int[][] dp = new int[s.length()+1][t.length()+1];
        dp[0][0] = 1;
        for(int i = 0; i < s.length(); ++i) {
            dp[i+1][0] = 1;
            for(int j = 0; j < t.length(); ++j) {
                dp[i+1][j+1] = (s.charAt(i) == t.charAt(j) ? dp[i][j] : 0) + dp[i][j+1];
            }
        }
        return dp[s.length()][t.length()];
    }
}
