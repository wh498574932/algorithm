package com.wh498574932.algorithm.lc065;

/**
 * Validate if a given string can be interpreted as a decimal number.
 *
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * " -90e3   " => true
 * " 1e" => false
 * "e3" => false
 * " 6e-1" => true
 * " 99e2.5 " => false
 * "53.5e93" => true
 * " --6 " => false
 * "-+3" => false
 * "95a54e53" => false
 *
 * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before
 * implementing one. However, here is a list of characters that can be in a valid decimal number:
 *
 * Numbers 0-9
 * Exponent - "e"
 * Positive/negative sign - "+"/"-"
 * Decimal point - "."
 * Of course, the context of these characters also matters in the input.
 *
 * Time:        2 ms        78.03%      O(N)
 * Space:       36.2 MB     99.77%      O(1)
 *
 * https://leetcode.com/problems/valid-number/
 */
public class ValidNumber {
    public boolean isNumber(String s) {
        if( s == null ) { return false; }
        s = s.trim();
        if( s.length() < 1 ) { return false; }
        int i = 0;
        if( s.charAt(i) == '+' || s.charAt(i) == '-' ) { i++; }
        int first = isDecimal(s, i);
        if(first == -1) { return false; }
        if( first == s.length() ) { return true; }
        if( s.charAt(first) == 'e' ) {
            first++;
            if( first == s.length() ) { return false; }
            if(first < s.length() && (s.charAt(first) == '+' || s.charAt(first) == '-')) {
                first++;
            }
            if( first == s.length() ) { return false; }
            return isInt(s, first) == s.length();
        } else {
            return false;
        }
    }

    private int isDecimal(String s, int start) {
        if( start == s.length() ) { return -1; }
        int first = isInt(s, start);
        if( first == start && s.charAt(first) != '.' ) { return -1; }
        if( first == s.length() ) { return first; }
        if( s.charAt(first) == '.' ) {
            int second = isInt(s, first+1);
            if( first == start && second == first + 1 ) { return -1; }
            return second;
        }
        else { return first; }
    }

    private int isInt(String s, int start) {
        int i = start;
        while(i < s.length() && isNum(s, i)) { i++; }
        return i;
    }

    private boolean isNum(String s, int index) {
        return s.charAt(index) >= '0' && s.charAt(index) <= '9';
    }
}
