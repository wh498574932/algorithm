package com.haowu.leetcode.lc253;

import com.haowu.leetcode.model.Interval;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...]
 * find the minimum number of conference rooms required.
 */
public class MeetingRoomsII2 {
    public int minMeetingRooms(Interval[] intervals) { // O(N) through bucket sort.
        List<EndPoint> list = new ArrayList<>();
        for(Interval interval : intervals) {
            list.add(new EndPoint(interval.start, true));
            list.add(new EndPoint(interval.end, false));
        }
        list.sort((o1, o2) -> {
            int diff = o1.val - o2.val;
            if(diff == 0 && (o1.isStart ^ o2.isStart)) {
                return o1.isStart ? 1 : -1;
            } else {
                return diff;
            }
        }); // O(NlogN) can be optimized to bucket sort O(N)
        Queue<Integer> q = new LinkedList<>();
        for(EndPoint endPoint : list) {
            if(endPoint.isStart) {
                if(!q.isEmpty() && endPoint.val >= q.peek()) {
                    q.poll();
                }
            } else {
                q.offer(endPoint.val);
            }
        }
        return q.size();
    }

    class EndPoint {
        int val;
        boolean isStart;
        EndPoint(int val, boolean isStart) {
            this.val = val;
            this.isStart = isStart;
        }
    }
}
