package com.wh498574932.algorithm.airbnb;

import java.util.HashMap;
import java.util.Map;

/**
 * If a number is odd, the next transform is 3*n+1
 * If a number is even, the next transform is n/2
 * The number is finally transformed into 1.
 * The step is how many transforms needed for a number turned into 1.
 * Given an integer n, output the max steps of transform number in [1, n] into 1.
 *
 * Time:        O(N)
 * Space:       O(N)
 */
public class CollatzConjecture {
    public int maxSteps(int n) {
        int ret = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 1; i <= n; ++i) {
            ret = Math.max(ret, step(map, i));
        }
        return ret;
    }

    private int step(Map<Integer, Integer> map, int n) {
        if(n == 1) {
            return 0;
        }
        if(map.containsKey(n)) {
            return map.get(n);
        }
        int step = 1;
        if(n % 2 == 0) {
            step += step(map, n/2);
        } else {
            step += step(map, n*3+1);
        }
        map.put(n, step);
        return step;
    }
}
