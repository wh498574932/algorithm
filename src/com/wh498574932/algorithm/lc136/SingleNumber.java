package com.wh498574932.algorithm.lc136;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,1]
 * Output: 1
 *
 * Example 2:
 *
 * Input: [4,1,2,1,2]
 * Output: 4
 *
 * Time:        0 ms        100.00%     O(N)
 * Space:       39 MB       97.04%      O(1)
 *
 * https://leetcode.com/problems/single-number/
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int ret = nums[0];
        for(int i = 1; i < nums.length; ++i) { ret ^= nums[i]; }
        return ret;
    }
}
