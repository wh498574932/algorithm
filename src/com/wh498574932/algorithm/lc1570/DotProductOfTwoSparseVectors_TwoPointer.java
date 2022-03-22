package com.wh498574932.algorithm.lc1570;

import java.util.ArrayList;
import java.util.List;

public class DotProductOfTwoSparseVectors_TwoPointer {
    List<int[]> list = new ArrayList<>();

    DotProductOfTwoSparseVectors_TwoPointer(int[] nums) {
        for(int i = 0; i < nums.length; ++i) {
            if(nums[i] != 0) {
                this.list.add(new int[]{i, nums[i]});
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(DotProductOfTwoSparseVectors_TwoPointer vec) {
        int ret = 0, p = 0, q = 0;
        while(p < list.size() && q < vec.list.size()) {
            if(list.get(p)[0] == vec.list.get(q)[0]) {
                ret += (list.get(p++)[1] * vec.list.get(q++)[1]);
            } else if(list.get(p)[0] > vec.list.get(q)[0]) {
                q++;
            } else {
                p++;
            }
        }
        return ret;
    }
}
