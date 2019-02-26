package com.wh498574932.algorithm.lc621;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters
 * represent different tasks. Tasks could be done without original order. Each task could be done in one interval.
 * For each interval, CPU could finish one task or just be idle.
 *
 * However, there is a non-negative cooling interval n that means between two same tasks, there must be at least
 * n intervals that CPU are doing different tasks or just be idle.
 *
 * You need to return the least number of intervals the CPU will take to finish all the given tasks.
 *
 * https://leetcode.com/problems/task-scheduler/
 */
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i2 - i1);
        Map<Character, Integer> dict = new HashMap<>();
        for(char c : tasks) {
            dict.put( c, dict.getOrDefault(c, 0) + 1 );
        }
        for(int val : dict.values()) {
            pq.offer(val);
        }
        int ret = 0;
        int cycle = n + 1;
        while(!pq.isEmpty()) {
            int cnt = 0;
            List<Integer> res = new ArrayList<>();
            for(int i = 0; i < cycle; ++i) {
                if(!pq.isEmpty()) {
                    res.add( pq.poll() );
                    cnt++;
                }
            }
            for(int i = 0; i < res.size(); ++i) {
                if(res.get(i) > 1) {
                    pq.offer(res.get(i)-1);
                }
            }
            ret += pq.isEmpty() ? cnt : cycle;
        }
        return ret;
    }
}
