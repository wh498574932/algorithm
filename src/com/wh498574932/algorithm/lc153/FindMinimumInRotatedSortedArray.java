package com.wh498574932.algorithm.lc153;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 *
 * Find the minimum element.
 *
 * You may assume no duplicate exists in the array.
 *
 * Example 1:
 *
 * Input: [3,4,5,1,2]
 * Output: 1
 *
 * Example 2:
 *
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 *
 * Time:        0 ms        100.00%     O(logN)
 * Space:       38.2 MB     98.86%      O(1)
 *
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1, min = nums[0];
        while(l < r - 1) {
            int m = l + ( r - l ) / 2;
            if(nums[l] < nums[m]) {
                min = Math.min(min, nums[l]);
                l = m + 1;
            }
            else if(nums[l] > nums[m]) {
                min = Math.min(min, nums[m]);
                r = m - 1;
            }
            else {
                l++;
            }
        }
        min = Math.min(min, nums[l]);
        min = Math.min(min, nums[r]);
        return min;
    }
}
