package com.wh498574932.algorithm.lc152;

/**
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has
 * the largest product.
 *
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 *
 * Example 2:
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 * Time:        1 ms        98.46%      O(N)
 * Space:       38.7 MB     9.76%       O(1)
 *
 * https://leetcode.com/problems/maximum-product-subarray/
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length < 1) { return 0; }
        int min_local = nums[0], max_local = nums[0], global = nums[0];
        for(int i = 1; i < nums.length; ++i) {
            int temp_local = max_local;
            max_local = Math.max(
                nums[i],
                Math.max( max_local*nums[i], min_local*nums[i]) );
            min_local = Math.min(
                nums[i],
                Math.min( temp_local*nums[i], min_local*nums[i]) );
            global = Math.max(max_local, global);
        }
        return global;
    }
}
