package com.wh498574932.algorithm.lc045;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * Example:
 *
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 *     Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Note:
 *
 * You can assume that you can always reach the last index.
 *
 * Time:        2 ms        70.66%      O(N)
 * Space:       36 MB       100.00%     O(1)
 *
 * https://leetcode.com/problems/jump-game-ii/
 */
public class JumpGameII {
    public int jump(int[] nums) {
        if( nums == null || nums.length < 2 ) { return 0; }
        int lastReach = 0, reach = 0, step = 0, i = 0;
        while(i < nums.length && i <= lastReach) {
            reach = Math.max( reach, nums[i] + i );
            if(i == lastReach) {
                lastReach = reach;
                reach = i;
                if( i == nums.length - 1 ) { return step; }
                step++;
            }
            i++;
        }
        return step;
    }
}
