package com.wh498574932.algorithm.lc043;

/**
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also
 * represented as a string.
 *
 * Example 1:
 *
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 *
 * Example 2:
 *
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 *
 * Note:
 *
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 * Time:        6 ms        62.58%      O(M*N)
 * Space:       35.5 MB     100.00%     O(1)
 *
 * https://leetcode.com/problems/multiply-strings/
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if( num1 == null || num1.length() < 1 || num2 == null || num2.length() < 1 ) {
            return "";
        }
        if( num1.equals("0") || num2.equals("0") ) { return "0"; }
        String longer = num1.length() > num2.length() ? num1 : num2;
        String shorter = num1.length() > num2.length() ? num2 : num1;
        String ret = "";
        int carry = 0;
        for(int k = longer.length() + shorter.length() - 2; k >= 0; k--) {
            for(int s = shorter.length() - 1; s >= 0; s--) {
                int l = k - s;
                if( l >= 0 && l < longer.length() ) {
                    carry += (longer.charAt(l)-'0') * (shorter.charAt(s)-'0');
                }
            }
            ret = carry%10 + ret;
            carry /= 10;
        }
        if( carry > 0 ) { ret = carry + ret; }
        return ret;
    }
}
