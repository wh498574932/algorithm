package com.wh498574932.algorithm.lc091;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * Example 1:
 *
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 *
 * Example 2:
 *
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 *
 * Time:        1 ms        99.10%      O(N)
 * Space:       34.4 MB     100.00%     O(N)
 *
 * https://leetcode.com/problems/decode-ways/
 */
public class DecodeWays {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        if( s.charAt(0) == '0' ) { return 0; }
        dp[1] = 1;
        for(int i = 1; i < s.length(); ++i) {
            if(s.charAt(i) == '0') {
                if( s.charAt(i-1) == '0' || s.charAt(i-1) > '2' ) { return 0; }
                dp[i+1] = dp[i-1];
            }
            else if(s.charAt(i) > '6') {
                dp[i+1] = dp[i] + (s.charAt(i-1) == '1' ? dp[i-1] : 0);
            }
            else {
                dp[i+1] = dp[i] + (s.charAt(i-1) == '1' || s.charAt(i-1) == '2' ? dp[i-1] : 0);
            }
        }
        return dp[s.length()];
    }
}
