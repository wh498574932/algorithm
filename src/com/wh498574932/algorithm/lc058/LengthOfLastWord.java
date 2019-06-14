package com.wh498574932.algorithm.lc058;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last
 * word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * Example:
 *
 * Input: "Hello World"
 * Output: 5
 *
 * Time:        0 ms        100.00%     O(N)
 * Space:       35.9 MB     99.98%      O(1)
 *
 * https://leetcode.com/problems/length-of-last-word/
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if( s == null || s.length() < 1 ) { return 0; }
        int l = s.length() - 1, r = s.length() - 1;
        while( l >= 0 ) {
            if( s.charAt(l) == ' ' ) {
                if( r > l ) { return r - l; }
                r = l - 1;
            }
            l--;
        }
        return r - l;
    }
}
