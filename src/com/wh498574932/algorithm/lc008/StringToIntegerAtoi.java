package com.wh498574932.algorithm.lc008;

/**
 * Implement atoi which converts a string to an integer.
 *
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is
 * found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical
 * digits as possible, and interprets them as a numerical value.
 *
 * The string can contain additional characters after those that form the integral number, which are ignored and have no
 * effect on the behavior of this function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence
 * exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned.
 *
 * Note:
 *
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range:
 * [−2^31,  2^31 − 1]. If the numerical value is out of the range of representable values, INT_MAX (2^31 − 1) or INT_MIN
 * (−2^31) is returned.
 *
 * Example 1:
 * Input: "42"
 * Output: 42
 *
 * Example 2:
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 *              Then take as many numerical digits as possible, which gets 42.
 *
 * Example 3:
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 *
 * Example 4:
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical
 *              digit or a +/- sign. Therefore no valid conversion could be performed.
 *
 * Example 5:
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 *              Therefore INT_MIN (−231) is returned.
 *
 * Time:        1 ms        100.00%     O(N)
 * Space:       37.3 MB     23.47%      O(1)
 *
 * https://leetcode.com/problems/string-to-integer-atoi/
 */
public class StringToIntegerAtoi {
    public int myAtoi(String str) {
        if(str == null || str.length() < 1) { return 0; }
        int index = 0;
        while( index < str.length() && str.charAt(index) == ' ' ) { index++; }
        if( index == str.length() ) { return 0; }
        return number( str, index );
    }

    private int number(String s, int start) {
        boolean isNeg = false;
        if( s.charAt(start) == '-' || s.charAt(start) == '+' ) {
            isNeg = s.charAt(start) == '-';
            start++;
        }
        int val = 0;
        for( int i = start; i < s.length() && isNum(s.charAt(i)) != -1; ++i ) {
            int digit = isNum( s.charAt(i) );
            if( !isNeg && val > (Integer.MAX_VALUE - digit)/10 ) {
                return Integer.MAX_VALUE;
            }
            if( isNeg && -val < (Integer.MIN_VALUE + digit)/10 ) {
                return Integer.MIN_VALUE;
            }
            val = val*10 + digit;
        }
        return isNeg ? -val : val;
    }

    private int isNum(char c) {
        return c >= '0' && c <= '9' ? c - '0' : -1;
    }
}
