package com.wh498574932.algorithm.lc161;

/**
 * Given two strings s and t, determine if they are both one edit distance apart.
 *
 * Note:
 *
 * There are 3 possibilities to satisfy one edit distance apart:
 *
 * Insert a character into s to get t
 * Delete a character from s to get t
 * Replace a character of s to get t
 * Example 1:
 *
 * Input: s = "ab", t = "acb"
 * Output: true
 * Explanation: We can insert 'c' into s to get t.
 * Example 2:
 *
 * Input: s = "cab", t = "ad"
 * Output: false
 * Explanation: We cannot get t from s by only one step.
 * Example 3:
 *
 * Input: s = "1203", t = "1213"
 * Output: true
 * Explanation: We can replace '0' with '1' to get t.
 */
public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if(s == null || t == null || Math.abs(s.length() - t.length()) > 1) { return false; }
        boolean oneEditDistance = false;
        int i = 0, j = 0;
        String longer = s.length() > t.length() ? s : t;
        String shorter = s.length() > t.length() ? t : s;
        while(i < longer.length() && j < shorter.length()) {
            if(longer.charAt(i) != shorter.charAt(j)) {
                if( oneEditDistance || (s.length() != t.length() && longer.charAt(i+1) != shorter.charAt(j) )) {
                    return false;
                }
                if( s.length() != t.length() ) { i++; }
                oneEditDistance = true;
            }
            i++;
            j++;
        }
        return true;
    }
}
