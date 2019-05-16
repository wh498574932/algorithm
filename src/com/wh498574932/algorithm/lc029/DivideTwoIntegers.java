package com.wh498574932.algorithm.lc029;

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * The integer division should truncate toward zero.
 *
 * Example 1:
 *
 * Input: dividend = 10, divisor = 3
 * Output: 3
 *
 * Example 2:
 *
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Note:
 *
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range:
 * [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result
 * overflows.
 *
 * Time:        1 ms        100.00%     O(logN)
 * Space:       32.8 MB     62.33%      O(1)
 *
 * https://leetcode.com/problems/divide-two-integers/
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if(dividend == 0) { return 0; }
        if(divisor == Integer.MIN_VALUE) { return dividend == Integer.MIN_VALUE ? 1 : 0; }
        int ret = 0;
        if(dividend == Integer.MIN_VALUE) {
            if(divisor == -1) { return Integer.MAX_VALUE; }
            else { dividend += Math.abs(divisor); }
            ret++;
        }
        boolean isNeg = (dividend^divisor) >>> 31 == 1;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int digit = 0;
        while( (dividend >> 1) >= divisor ) {
            divisor <<= 1;
            digit++;
        }
        while( digit >= 0 ) {
            if(dividend >= divisor) {
                ret += (1 << digit);
                dividend -= divisor;
            }
            divisor >>= 1;
            digit--;
        }
        return isNeg ? -ret : ret;
    }
}
