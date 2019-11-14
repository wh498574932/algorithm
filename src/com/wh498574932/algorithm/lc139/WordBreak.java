package com.wh498574932.algorithm.lc139;

import java.util.List;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented
 * into a space-separated sequence of one or more dictionary words.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 *
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 *
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 *              Note that you are allowed to reuse a dictionary word.
 *
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 *
 * Time:        4 ms        79.71%      O(N^2)
 * Space:       36.1 MB     93.48%      O(N)
 *
 * https://leetcode.com/problems/word-break/
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 0; i < s.length(); ++i) {
            for(int j = 0; j < s.length(); ++j) {
                if(dp[j] && wordDict.contains(s.substring(j, i+1))) {
                    dp[i+1] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}