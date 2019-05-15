package com.wh498574932.algorithm.lc028;

/**
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr()
 * and Java's indexOf().
 *
 * Time:        2 ms        78.20%      O(N)
 * Space:       36.3 MB     98.54%      O(1)
 *
 * https://leetcode.com/problems/implement-strstr/
 */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if( haystack == null || needle == null ) { return -1; }
        else if( needle.length() < 1 ) { return 0; }
        else if( haystack.length() < 1 || haystack.length() < needle.length() ) {
            return -1;
        }
        for(int i = 0; i <= haystack.length() - needle.length(); ++i) {
            int j = 0;
            while(j < needle.length()) {
                if(haystack.charAt(i+j) != needle.charAt(j)) { break; }
                j++;
            }
            if(j == needle.length()) { return i; }
        }
        return -1;
    }
}
