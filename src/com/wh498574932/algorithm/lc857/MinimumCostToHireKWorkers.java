package com.wh498574932.algorithm.lc857;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import javafx.util.Pair;

public class MinimumCostToHireKWorkers {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        if(quality == null ||
            wage == null ||
            wage.length < 1 ||
            wage.length != quality.length ||
            K < 1) {
            return 0.0;
        }
        List<Pair<Double, Integer>> ratios = new ArrayList<>();
        for(int i = 0; i < wage.length; ++i) {
            ratios.add(new Pair<>((double)wage[i]/quality[i], quality[i]));
        }
        ratios.sort(Comparator.comparingDouble(Pair::getKey));
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> Integer.compare(i2, i1));
        double ret = Double.MAX_VALUE;
        double qsum = 0;
        for(Pair<Double, Integer> ratio : ratios) {
            qsum += ratio.getValue();
            pq.offer(ratio.getValue());
            if(pq.size() > K) {
                qsum -= pq.poll();
            }
            if(pq.size() == K) {
                ret = Math.min(ret, ratio.getKey()*qsum);
            }
        }
        return ret;
    }
}
