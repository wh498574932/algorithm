package com.wh498574932.algorithm.lc149;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 *
 * Example 1:
 *
 * Input: [[1,1],[2,2],[3,3]]
 * Output: 3
 * Explanation:
 * ^
 * |
 * |        o
 * |     o
 * |  o
 * +------------->
 * 0  1  2  3  4
 *
 * Example 2:
 *
 * Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 * Explanation:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 *
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 *
 * Time:        53 ms       10.05%      O(N^2)
 * Space:       38.6 MB     22.86%      O(N)
 *
 * https://leetcode.com/problems/max-points-on-a-line/
 */
public class MaxPointsOnALine {
    public int maxPoints(int[][] points) {
        if(points == null || points.length < 1 || points[0].length < 1) { return 0; }
        int ret = 0;
        for(int[] currPoint : points) {
            int same = 0, infinite = 0;
            Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();
            for(int[] point : points) {
                if(point[0] == currPoint[0] && point[1] == currPoint[1]) {
                    same++;
                }
                else if(point[0] == currPoint[0]) {
                    infinite++;
                }
                else {
                    int ydiff = currPoint[1] - point[1];
                    int xdiff = currPoint[0] - point[0];
                    int gcd = gcd(ydiff, xdiff);
                    Pair<Integer, Integer> key = new Pair<>(ydiff/gcd, xdiff/gcd);
                    map.put(key, map.getOrDefault(key, 0) + 1);
                }
                int max = infinite;
                for(int value : map.values()) {
                    max = Math.max(value, max);
                }
                ret = Math.max(ret, max + same);
            }
        }
        return ret;
    }

    private int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
}
