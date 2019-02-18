package com.haowu.leetcode.lc560;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 *
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        map.put(0, list);
        int sum = 0;
        int ret = 0;
        for(int i = 1; i <= nums.length; ++i) {
            sum += nums[i-1];
            if(map.containsKey(sum-k)) {
                ret += map.get(sum-k).size();
            }
            List<Integer> value = map.getOrDefault( sum, new ArrayList<>() );
            value.add(i);
            map.put( sum, value );
        }
        return ret;
    }
}
