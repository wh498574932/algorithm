package com.wh498574932.algorithm.lc238;

/**
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product
 * of all the elements of nums except nums[i].
 *
 * Note: Please solve it without division and in O(n).
 *
 * Follow up:
 * Could you solve it with constant space complexity?
 * (The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] ret = new int[nums.length];
        for(int i = 0; i < nums.length; ++i) {
            ret[i] = (i > 0 ? ret[i-1] : 1) * nums[i];
        }
        int right = 1;
        for(int i = nums.length-1; i >= 0; --i) {
            ret[i] = right * (i > 0 ? ret[i-1] : 1);
            right *= nums[i];
        }
        return ret;
    }
}
