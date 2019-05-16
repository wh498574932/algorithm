package com.wh498574932.algorithm.lc081;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 *
 * You are given a target value to search. If found in the array return true, otherwise return false.
 *
 * Example 1:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 *
 * Example 2:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 * Follow up:
 *
 * This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 *
 * Time:        0 ms        100.00%     O(logN)
 * Space:       38.8 MB     53.17%      O(1)
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if( nums == null || nums.length < 1 ) { return false; }
        int l = 0, r = nums.length - 1;
        while( l <= r ) {
            int m = (r - l) / 2 + l;
            if( nums[m] == target ) {
                return true;
            }
            else if( nums[m] > nums[r] ) {
                if( nums[m] > target && nums[l] <= target ) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
            else if( nums[m] < nums[r] ) {
                if( nums[m] < target && target <= nums[r] ) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            else {
                r--;
            }
        }
        return false;
    }
}
