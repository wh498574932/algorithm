package com.wh498574932.algorithm.lc1570;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class DotProductOfTwoSparseVectors_Map {
    Map<Integer, Integer> map = new HashMap<>();

    DotProductOfTwoSparseVectors_Map(int[] nums) {
        for(int i = 0; i < nums.length; ++i) {
            if(nums[i] != 0) {
                this.map.put(i, nums[i]);
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(DotProductOfTwoSparseVectors_Map vec) {
        return this.map.keySet()
            .stream()
            .filter(i -> vec.map.containsKey(i))
            .collect(Collectors.summingInt(i -> map.get(i)*vec.map.get(i)));
    }
}
