package com.wh498574932.algorithm.lc973;

import java.util.ArrayList;
import java.util.List;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        double dist[] = new double[points.length];
        double low = Double.MAX_VALUE, high = 0;
        List<Integer> remaining = new ArrayList<>();
        for(int i = 0; i < points.length; ++i) {
            double distance = distance(points[i]);
            low = Math.min(low, distance);
            high = Math.max(high, distance);
            dist[i] = distance;
            remaining.add(i);
        }
        List<Integer> ret = new ArrayList<>();
        while(k > 0) {
            double mid = (low + high) / 2;
            List<List<Integer>> split = split(remaining, dist, mid);
            List<Integer> close = split.get(0), far = split.get(1);
            if(close.size() > k) {
                remaining = close;
                high = mid;
            } else {
                k -= close.size();
                remaining = far;
                ret.addAll(close);
                low = mid;
            }
        }
        k = ret.size();
        int[][] ans = new int[k][2];
        for(int i = 0; i < k; ++i) {
            ans[i] = points[ret.get(i)];
        }
        return ans;
    }

    private List<List<Integer>> split(List<Integer> remaining, double[] dist, double mDist) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> less = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        for(int i = 0; i < remaining.size(); ++i) {
            if(dist[remaining.get(i)] <= mDist) {
                less.add(remaining.get(i));
            } else {
                greater.add(remaining.get(i));
            }
        }
        ret.add(less);
        ret.add(greater);
        return ret;
    }

    private double distance(int[] point) {
        return (double)(point[0]*point[0]) + (double)(point[1]*point[1]);
    }
}
