package com.wh498574932.algorithm.lc057;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 *
 * Example 2:
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 *
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method
 * signature.
 *
 * Time:        1 ms        99.86%      O(N)
 * Space:       40.6 MB     54.78%      O(N)
 *
 * https://leetcode.com/problems/insert-interval/
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if( intervals == null || newInterval == null ) { return null; }
        if( intervals.length < 1 ) { return new int[][]{ newInterval }; }
        List<int[]> res = new ArrayList<>();
        int i = 0;
        while( i < intervals.length && intervals[i][1] < newInterval[0] ) {
            res.add(intervals[i]);
            i++;
        }
        if( i < intervals.length ) {
            newInterval[0] = Math.min( newInterval[0], intervals[i][0] );
        }
        res.add( newInterval );
        while( i < intervals.length && intervals[i][0] <= newInterval[1] ) {
            newInterval[1] = Math.max( newInterval[1], intervals[i][1] );
            i++;
        }
        while( i < intervals.length ) {
            res.add( intervals[i] );
            i++;
        }
        int[][] ret = new int[res.size()][2];
        ret = res.toArray(ret);
        return ret;
    }
}