package com.wh498574932.algorithm.lc016;

import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to
 * target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * Example:
 *
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * Time:        4 ms        98.74%      O(N^2)
 * Space:       37.8 MB     70.54%      O(N)
 *
 * https://leetcode.com/problems/3sum-closest/
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if( nums == null || nums.length < 3 ) { return -1; }
        int min = Integer.MAX_VALUE, ret = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; ++i) {
            if( i > 0 && nums[i] == nums[i-1] ) { continue; }
            int l = i + 1, r = nums.length - 1;
            while( l < r ) {
                int diff = Math.abs( nums[i] + nums[l] + nums[r] - target );
                if( diff == 0 ) { return target; }
                if( diff < min ) {
                    min = diff;
                    ret = nums[i] + nums[l] + nums[r];
                }
                if( nums[i] + nums[l] + nums[r] > target ) { r--; }
                else { l++; }
            }
        }
        return ret;
    }
}
