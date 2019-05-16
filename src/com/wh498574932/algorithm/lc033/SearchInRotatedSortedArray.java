package com.wh498574932.algorithm.lc033;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 *
 * Time:        0 ms        100.00%     O(logN)
 * Space:       37.3 MB     81.50%      O(1)
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if( nums == null || nums.length < 1 ) { return -1; }
        int l = 0, r = nums.length - 1;
        while( l <= r ) {
            int m = (r - l) / 2 + l;
            if( nums[m] == target ) {
                return m;
            }
            else if( nums[l] <= nums[m] ) {
                if( nums[m] > target && nums[l] <= target ) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
            else {
                if( nums[m] < target && target <= nums[r] ) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;
    }
}
