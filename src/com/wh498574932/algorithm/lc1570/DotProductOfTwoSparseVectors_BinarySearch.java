package com.wh498574932.algorithm.lc1570;

import java.util.ArrayList;
import java.util.List;

public class DotProductOfTwoSparseVectors_BinarySearch {
    List<int[]> list = new ArrayList<>();

    DotProductOfTwoSparseVectors_BinarySearch(int[] nums) {
        for(int i = 0; i < nums.length; ++i) {
            if(nums[i] != 0) {
                this.list.add(new int[]{i, nums[i]});
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(DotProductOfTwoSparseVectors_BinarySearch vec) {
        int ret = 0;
        for(int i = 0; i < list.size(); ++i) {
            int index = list.get(i)[0];
            int l = 0, r = vec.list.size()-1;
            while(l <= r) {
                int m = (l + r) / 2;
                if(vec.list.get(m)[0] == index) {
                    ret += (vec.list.get(m)[1] * list.get(i)[1]);
                    break;
                } else if(vec.list.get(m)[0] > index) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
        return ret;
    }
}
