package com.haowu.leetcode.lc253;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...]
 * find the minimum number of conference rooms required.
 */
public class MeetingRoomsII {
    public int minMeetingRooms(Interval[] intervals) {
        PriorityQueue<Interval> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(i -> i.end));
        Arrays.sort(intervals, Comparator.comparingInt(i -> i.start));
        priorityQueue.offer(intervals[0]);
        for(int i = 1; i < intervals.length; ++i) {
            Interval interval = intervals[i];
            if(interval.start >= priorityQueue.peek().end) {
                priorityQueue.poll();
            }
            priorityQueue.offer(interval);
        }
        return priorityQueue.size();
    }

    /**
     * Utility Class For Compiling Purpose
     */
    static class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
