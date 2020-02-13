package com.wh498574932.algorithm.lc154;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 *
 * Find the minimum element.
 *
 * The array may contain duplicates.
 *
 * Example 1:
 *
 * Input: [1,3,5]
 * Output: 1
 *
 * Example 2:
 *
 * Input: [2,2,2,0,1]
 * Output: 0
 * Note:
 *
 * This is a follow up problem to Find Minimum in Rotated Sorted Array.
 * Would allow duplicates affect the run-time complexity? How and why?
 *
 * Time:        0 ms        100.00%     O(logN)
 * Space:       39.3 MB     37.50%      O(1)
 *
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */
public class FindMinimumInRotatedSortedArrayII {
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
