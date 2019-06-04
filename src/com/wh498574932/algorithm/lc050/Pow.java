package com.wh498574932.algorithm.lc050;

/**
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 *
 * Example 1:
 *
 * Input: 2.00000, 10
 * Output: 1024.00000
 *
 * Example 2:
 *
 * Input: 2.10000, 3
 * Output: 9.26100
 *
 * Example 3:
 *
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 *
 * Note:
 *
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−2^31, 2^31 − 1]
 *
 * Time:        0 ms        100.00%     O(logN)
 * Space:       32.8 MB     51.57%      O(logN)
 *
 * https://leetcode.com/problems/powx-n/
 */
public class Pow {
    public double myPow(double x, int n) {
        if( n == 0 ) { return 1; }
        double half = myPow( x, n / 2 );
        return half * half * ( n % 2 != 0 ? ( n > 0 ? x : 1 / x ) : 1 );
    }
}
