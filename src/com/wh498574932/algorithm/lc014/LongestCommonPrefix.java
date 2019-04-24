package com.wh498574932.algorithm.lc014;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 * Note:
 *
 * All given inputs are in lowercase letters a-z.
 *
 * Time:        1 ms        91.42%      O(N)
 * Space:       37.5 MB     77.27%      O(1)
 *
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length < 1) { return ""; }
        if(strs.length == 1) { return strs[0]; }
        int size = Integer.MAX_VALUE;
        for(String str : strs) { size = Math.min(size, str.length()); }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; ++i) {
            char c = strs[0].charAt(i);
            for(int j = 1; j < strs.length; ++j) {
                if( strs[j].charAt(i) != c ) { return sb.toString(); }
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
