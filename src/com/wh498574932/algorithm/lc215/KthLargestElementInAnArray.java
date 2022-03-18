package com.wh498574932.algorithm.lc215;

import java.util.Random;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length-1, nums.length-k);
    }

    private int quickSelect(final int[] nums, final int l, final int r, final int kSmallestIndex) {
        if(l == r) {
            return nums[l];
        }
        int pivotIndex = new Random().nextInt(r - l) + l;
        int pivot = nums[pivotIndex];
        swap(nums, pivotIndex, r);
        pivotIndex = l;
        for(int i = l; i <= r; ++i) {
            if(nums[i] < pivot) {
                swap(nums, pivotIndex++, i);
            }
        }
        swap(nums, pivotIndex, r);
        if(pivotIndex == kSmallestIndex) {
            return nums[pivotIndex];
        } else if(pivotIndex > kSmallestIndex) {
            return quickSelect(nums, l, pivotIndex - 1, kSmallestIndex);
        } else {
            return quickSelect(nums, pivotIndex + 1, r, kSmallestIndex);
        }
    }

    private void swap(final int[] nums, final int l, final int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
