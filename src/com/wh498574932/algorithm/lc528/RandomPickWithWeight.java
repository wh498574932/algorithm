package com.wh498574932.algorithm.lc528;

public class RandomPickWithWeight {
    private final int[] prefix;
    private final int total;

    public RandomPickWithWeight(int[] w) {
        prefix = new int[w.length];
        int sum = 0;
        for(int i = 0; i < w.length; ++i) {
            sum += w[i];
            prefix[i] = sum;
        }
        total = sum;
    }

    public int pickIndex() {
        double target = total * Math.random();
        int l = 0, r = prefix.length - 1;
        while(l <= r) {
            int m = (l + r) / 2;
            if(prefix[m] > target && (m == 0 || prefix[m-1] <= target)) {
                return m;
            } else if(prefix[m] <= target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }
}
