package com.wh498574932.algorithm.lc007;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output: 321
 *
 * Example 2:
 *
 * Input: -123
 * Output: -321
 *
 * Example 3:
 *
 * Input: 120
 * Output: 21
 *
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range:
 * [−2^31,  2^31 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer
 * overflows.
 *
 * Time:        1 ms        100.00%     O(N)
 * Space:       32.5 MB     100.00%     O(1)
 *
 * https://leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger {
    public int reverse(int x) {
        int res = 0;
        while(x != 0) {
            if( Math.abs(res) > Integer.MAX_VALUE/10 ) {
                return 0;
            }
            res = res*10 + x%10;
            x /= 10;
        }
        return res;
    }
}
