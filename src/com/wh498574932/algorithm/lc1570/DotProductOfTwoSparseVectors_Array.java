package com.wh498574932.algorithm.lc1570;

public class DotProductOfTwoSparseVectors_Array {
    int[] nums;

    DotProductOfTwoSparseVectors_Array(int[] nums) {
        this.nums = nums;
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(DotProductOfTwoSparseVectors_Array vec) {
        int ret = 0;
        for(int i = 0; i < nums.length; ++i) {
            ret += (nums[i] * vec.nums[i]);
        }
        return ret;
    }
}
