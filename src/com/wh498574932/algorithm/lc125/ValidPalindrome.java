package com.wh498574932.algorithm.lc125;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 *
 * Example 2:
 *
 * Input: "race a car"
 * Output: false
 *
 * Time:        3 ms        95.98%      O(N)
 * Space:       37.8 MB     93.75%      O(1)
 *
 * https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if( s == null ) { return false; }
        if( s.length() < 1 ) { return true; }
        int l = 0, r = s.length() - 1;
        while(l < r) {
            while( l < r && !isAlphanumeric(s.charAt(l)) ) { l++; }
            if(l == r) { return true; }
            while( l < r && !isAlphanumeric(s.charAt(r)) ) { r--; }
            if(l == r) { return true; }
            if(!isUpperAndLowerCases(s.charAt(l), s.charAt(r)) && s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    private boolean isAlphanumeric(char c) {
        return isLetter(c) || isNumber(c);
    }

    private boolean isUpperAndLowerCases(char c1, char c2) {
        return isLetter(c1) && isLetter(c2) && Math.abs(c1 - c2) == 32;
    }

    private boolean isLetter(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }
}
