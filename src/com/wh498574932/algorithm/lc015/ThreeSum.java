package com.wh498574932.algorithm.lc015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique
 * triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * Time:        32 ms       85.09%      O(N^2)
 * Space:       48.6 MB     61.44%      O(1)
 *
 * https://leetcode.com/problems/3sum/
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if(nums == null || nums.length < 3) { return ret; }
        Arrays.sort(nums); // O(NlogN)
        for(int i = 0; i < nums.length-2; ++i) { // O(N^2)
            if(i > 0 && nums[i] == nums[i-1]) { continue; }
            int target = -nums[i],l = i+1, r = nums.length-1;
            while(l < r) { // O(N)
                if(nums[l] + nums[r] == target) {
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[l]);
                    res.add(nums[r]);
                    ret.add(res);
                    l++;
                    r--;
                    while(l < r && nums[l] == nums[l-1]) { l++; }
                    while(l < r && nums[r] == nums[r+1]) { r--; }
                }
                else if(nums[l] + nums[r] > target) {
                    r--;
                }
                else {
                    l++;
                }
            }
        }
        return ret;
    }
}
