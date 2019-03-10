package com.wh498574932.algorithm.lc001;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Time:    3 ms    99.55%  O(N)
 *
 * Space:   39 MB   28.07%  O(N)
 *
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) { // O(N)
        if(nums == null || nums.length < 1) { return null; }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; ++i) { // O(N)
            if(map.containsKey(target-nums[i])) {
                return new int[]{map.get(target-nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
