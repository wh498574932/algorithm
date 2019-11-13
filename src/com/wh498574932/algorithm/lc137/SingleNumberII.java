package com.wh498574932.algorithm.lc137;

/**
 * Given a non-empty array of integers, every element appears three times except for one, which appears exactly once.
 * Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,3,2]
 * Output: 3
 *
 * Example 2:
 *
 * Input: [0,1,0,1,0,1,99]
 * Output: 99
 *
 * Time:        3 ms        50.03%      O(N)
 * Space:       37 MB       100.00%     O(1)
 *
 * https://leetcode.com/problems/single-number-ii/
 */
public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int[] digits = new int[32];
        for(int num : nums) {
            for(int i = 0; i < 32; ++i) {
                digits[i] += ((num>>>i) & 1);
            }
        }
        int ret = 0;
        for(int i = 0; i < 32; ++i) {
            ret += ( (digits[i]%3) << i );
        }
        return ret;
    }
}
