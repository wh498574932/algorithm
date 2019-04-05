package com.wh498574932.algorithm.lc005;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Time:    16 ms       62.96%      O(N^2)
 * Space:   38.2 MB     52.22%      O(1)
 *
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring_pivot {
    public String longestPalindrome(String s) {
        String ret = "";
        int l = 0, r = 0, cnt = 0;
        while(r < s.length()) {
            String max = helper(s, l, r);
            ret = max.length() > ret.length() ? max : ret;
            if( cnt % 2 == 0 ) {
                r++;
            } else {
                l++;
            }
            cnt++;
        }
        return ret;
    }

    private String helper(String s, int l, int r) {
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        l++;
        r--;
        return r < l ? "" : s.substring(l, r+1);
    }
}
