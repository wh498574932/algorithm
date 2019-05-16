package com.wh498574932.algorithm.lc031;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place and use only constant extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 *
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * Time:        1 ms        99.50%      O(N)
 * Space:       37.7 MB     81.28%      O(1)
 *
 * https://leetcode.com/problems/next-permutation/
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if( nums == null || nums.length < 2 ) { return; }
        int i = nums.length - 2;
        while( i >= 0 ) {
            if( nums[i] < nums[i+1] ) { break; }
            i--;
        }
        if( i < 0 ) {
            reverse(nums, 0, nums.length-1);
        } else {
            int j = nums.length - 1;
            while( nums[j] <= nums[i] ) { j--; }
            swap(nums, i, j);
            reverse(nums, i+1, nums.length-1);
        }
    }

    private void reverse(int[] nums, int start, int end) {
        for(int l = start, r = end; l < r; l++, r--) { swap(nums, l, r); }
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
