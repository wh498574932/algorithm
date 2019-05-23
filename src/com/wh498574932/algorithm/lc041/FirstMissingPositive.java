package com.wh498574932.algorithm.lc041;

/**
 * Given an unsorted integer array, find the smallest missing positive integer.
 *
 * Example 1:
 *
 * Input: [1,2,0]
 * Output: 3
 *
 * Example 2:
 *
 * Input: [3,4,-1,1]
 * Output: 2
 *
 * Example 3:
 *
 * Input: [7,8,9,11,12]
 * Output: 1
 *
 * Note:
 *
 * Your algorithm should run in O(n) time and uses constant extra space.
 *
 * Time:        0 ms        100.00%     O(N)
 * Space:       33.8 MB     100.00%     O(1)
 *
 * https://leetcode.com/problems/first-missing-positive/
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if( nums == null || nums.length < 1 ) { return 1; }
        for(int i = 0; i < nums.length; ++i) {
            while( nums[i] - 1 >= 0 &&
                nums[i] - 1 < nums.length &&
                nums[nums[i] - 1] != nums[i])
            {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for(int i = 0; i < nums.length; ++i) {
            if( nums[i] != i + 1 ) { return i + 1; }
        }
        return nums.length + 1;
    }
}
