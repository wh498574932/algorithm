package com.wh498574932.algorithm.lc053;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum
 * and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which
 * is more subtle.
 *
 * Time:        1 ms        94.43%      O(N)
 * Space:       38.5 MB     78.52%      O(1)
 *
 * https://leetcode.com/problems/maximum-subarray/
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if( nums == null || nums.length < 1 ) { return 0; }
        int local = nums[0], global = nums[0];
        for(int i = 1; i < nums.length; ++i) {
            local = Math.max( local + nums[i], nums[i] );
            global = Math.max( global, local );
        }
        return global;
    }
}
