package com.wh498574932.algorithm.lc072;

/**
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 *
 * You have the following 3 operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 *
 * Example 1:
 *
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 *
 * Example 2:
 *
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 *
 * Time:        5 ms        83.18%      O(M*N)
 * Space:       36.3 MB     91.22%      O(M*N)
 *
 * https://leetcode.com/problems/edit-distance/
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null) { return -1; }
        if(word1.length() < 1) { return word2.length(); }
        if(word2.length() < 1) { return word1.length(); }
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i = 0; i < word1.length(); ++i) { dp[i+1][0] = i + 1; }
        for(int i = 0; i < word2.length(); ++i) { dp[0][i+1] = i + 1; }
        for(int i = 0; i < word1.length(); ++i) {
            for(int j = 0; j < word2.length(); ++j) {
                dp[i+1][j+1] = Math.min(
                    dp[i][j] + ( word1.charAt(i) == word2.charAt(j) ? 0 : 1 ),
                    Math.min( dp[i][j+1], dp[i+1][j] ) + 1
                );
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
