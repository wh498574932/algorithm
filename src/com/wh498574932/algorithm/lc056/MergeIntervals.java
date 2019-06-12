package com.wh498574932.algorithm.lc056;

import java.util.Arrays;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *
 * Example 2:
 *
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method
 * signature.
 *
 * Time:        36 ms       43.33       O(N)
 * Space:       40.7 MB     84.88%      O(1)
 *
 * https://leetcode.com/problems/merge-intervals/
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if( intervals == null ) { return null; }
        Arrays.sort(
            intervals,
            (i1, i2) -> i1[0] == i2[0] ? i1[1] - i2[1] : i1[0] - i2[0]
        );
        int start = 0, len = 0;
        while( start < intervals.length ) {
            int i = start + 1;
            for(int last = intervals[start][1]; i <= intervals.length; ++i) {
                if( i == intervals.length || intervals[i][0] > last ) {
                    intervals[len][0] = intervals[start][0];
                    intervals[len][1] = last;
                    len++;
                    start = i;
                    break;
                } else {
                    last = Math.max(last, intervals[i][1]);
                }
            }
        }
        int[][] ret = new int[len][2];
        System.arraycopy(intervals, 0, ret, 0, len);
        return ret;
    }
}