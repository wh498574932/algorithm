package com.wh498574932.algorithm.lc347;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int n = map.keySet().size();
        int[] keys = new int[n];
        int i = 0;
        for(int key : map.keySet()) {
            keys[i++] = key;
        }
        quickSelect(keys, map, 0, n - 1, n - k);
        int[] ret = new int[k];
        for(int j = 0; j < k; ++j) {
            ret[j] = keys[n-k+j];
        }
        return ret;
    }

    private void quickSelect(int[] keys, Map<Integer, Integer> map, int l, int r, int k) {
        if(l == r) {
            return;
        }
        int pivot_index = l + new Random().nextInt(r - l);
        int pivot = keys[pivot_index];
        swap(keys, pivot_index, r);
        pivot_index = l;
        for(int i = l; i < r; ++i) {
            if(map.get(keys[i]) < map.get(pivot)) {
                swap(keys, pivot_index++, i);
            }
        }
        swap(keys, pivot_index, r);
        if(pivot_index == k) {
            return;
        } else if(pivot_index < k) {
            quickSelect(keys, map, pivot_index + 1, r, k);
        } else {
            quickSelect(keys, map, l, pivot_index - 1, k);
        }
    }

    private void swap(int[] keys, int l, int r) {
        int temp = keys[l];
        keys[l] = keys[r];
        keys[r] = temp;
    }
}
