package com.wh498574932.algorithm.lc069;

/**
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 *
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is
 * returned.
 *
 * Example 1:
 *
 * Input: 4
 * Output: 2
 *
 * Example 2:
 *
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 *              the decimal part is truncated, 2 is returned.
 *
 * Time:        1 ms        100.00%     O(logN)
 * Space:       33.5 MB     17.17%      O(1)
 *
 * https://leetcode.com/problems/sqrtx/
 */
public class Sqrtx {
    public int mySqrt(int x) {
        int l = 1, r = x/2+1;
        while(l <= r) {
            int m = l + (r-l)/2;
            if( m <= x/m && m+1>x/(m+1) ) {
                return m;
            }
            else if(m > x/m) {
                r = m - 1;
            }
            else {
                l = m + 1;
            }
        }
        return 0;
    }
}
