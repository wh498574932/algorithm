package com.wh498574932.algorithm.lc075;

/**
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are
 * adjacent, with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: You are not suppose to use the library's sort function for this problem.
 *
 * Example:
 *
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 *
 * Follow up:
 *
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then
 * 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 *
 * Time:        0 ms        100.00%     O(N)
 * Space:       35.4 MB     95.05%      O(1)
 *
 * https://leetcode.com/problems/sort-colors/
 */
public class SortColors {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length < 1) { return; }
        int zero = 0, one = 0;
        for(int i = 0; i < nums.length; ++i) {
            if( nums[i] == 0 ) {
                nums[i] = 2;
                nums[one++] = 1;
                nums[zero++] = 0;
            }
            else if( nums[i] == 1 ) {
                nums[i] = 2;
                nums[one++] = 1;
            }
        }
    }
}
