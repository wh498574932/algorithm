package com.wh498574932.algorithm.lc018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that
 * a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 *
 * The solution set must not contain duplicate quadruplets.
 *
 * Example:
 *
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * Time:        15 ms       83.96%      O(N^3)
 * Space:       36.6 MB     97.23%      O(1)
 *
 * https://leetcode.com/problems/4sum/
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        if( nums == null || nums.length < 4 ) { return ret; }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; ++i) {
            if( i > 0 && nums[i] == nums[i-1] ) { continue; }
            for(int j = i + 1; j < nums.length - 2; ++j) {
                if( j > i + 1 && nums[j] == nums[j-1] ) { continue; }
                int val = target - nums[i] - nums[j];
                int l = j + 1, r = nums.length - 1;
                while( l < r ) {
                    if( nums[l] + nums[r] == val ) {
                        ret.add(
                            Arrays.asList( nums[i], nums[j], nums[l], nums[r] )
                        );
                        l++;
                        r--;
                        while( l < r && nums[l] == nums[l-1] ) { l++; }
                        while( l < r && nums[r] == nums[r+1] ) { r--; }
                    }
                    else if( nums[l] + nums[r] < val ) { l++; }
                    else { r--; }
                }
            }
        }
        return ret;
    }
}
