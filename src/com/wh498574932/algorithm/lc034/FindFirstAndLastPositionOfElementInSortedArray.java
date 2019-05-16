package com.wh498574932.algorithm.lc034;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target
 * value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 * Time:        0 ms        100.00%     O(logN)
 * Space:       38.8 MB     99.83%      O(1)
 *
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if( nums == null || nums.length < 1 ) { return new int[]{-1, -1}; }
        int l1 = 0, r1 = nums.length-1;
        while(l1 <= r1) {
            int m = (r1 - l1) / 2 + l1;
            if(nums[m] >= target) { r1 = m - 1; }
            else { l1 = m + 1; }
        }
        int l2 = 0, r2 = nums.length-1;
        while(l2 <= r2) {
            int m = (r2 - l2) / 2 + l2;
            if(nums[m] <= target) { l2 = m + 1; }
            else { r2 = m - 1; }
        }
        return l1 <= r2 ? new int[]{l1, r2} : new int[]{-1, -1};
    }
}
