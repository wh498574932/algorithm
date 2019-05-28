package com.wh498574932.algorithm.lc055;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 *
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Example 2:
 *
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 *              jump length is 0, which makes it impossible to reach the last index.
 *
 * Time:        1 ms        99.90%      O(N)
 * Space:       36.8 MB     99.96%      O(1)
 *
 * https://leetcode.com/problems/jump-game/
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        if( nums == null ) { return false; }
        if( nums.length < 2 ) { return true; }
        int lastReach = 0, reach = 0;
        int i = 0;
        for(; i < nums.length && i <= lastReach; ++i) {
            reach = Math.max( reach, nums[i] + i );
            if(i == lastReach) {
                lastReach = reach;
                reach = i;
            }
        }
        return i == nums.length;
    }
}
