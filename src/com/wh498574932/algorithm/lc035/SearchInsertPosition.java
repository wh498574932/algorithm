package com.wh498574932.algorithm.lc035;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it
 * would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Example 1:
 *
 * Input: [1,3,5,6], 5
 * Output: 2
 *
 * Example 2:
 *
 * Input: [1,3,5,6], 2
 * Output: 1
 *
 * Example 3:
 *
 * Input: [1,3,5,6], 7
 * Output: 4
 *
 * Example 4:
 *
 * Input: [1,3,5,6], 0
 * Output: 0
 *
 * Time:        0 ms        100.00%     O(logN)
 * Space:       38.2 MB     97.76%      O(1)
 *
 * https://leetcode.com/problems/search-insert-position/
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if( nums == null || nums.length < 1 ) { return 0; }
        int l = 0, r = nums.length - 1;
        while( l <= r ) {
            int m = (r - l) / 2 + l;
            if(nums[m] == target) { return m; }
            else if(nums[m] < target) { l = m + 1; }
            else { r = m - 1; }
        }
        return l;
    }
}
