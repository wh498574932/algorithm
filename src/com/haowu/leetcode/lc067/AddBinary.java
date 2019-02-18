package com.haowu.leetcode.lc067;

/**
 * Given two binary strings, return their sum (also a binary string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        int carry = 0;
        int i = a.length()-1;
        int j = b.length()-1;
        String ret = "";
        while(i >= 0 || j >= 0 || carry > 0) {
            if(i >= 0) {
                carry += a.charAt(i) - '0';
                i--;
            }
            if(j >= 0) {
                carry += b.charAt(j) - '0';
                j--;
            }
            ret = (carry % 2 == 1 ? '1' : '0') + ret;
            carry /= 2;
        }
        return ret;
    }
}
