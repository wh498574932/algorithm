package com.wh498574932.algorithm.lc119;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 *
 * Note that the row index starts from 0.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 3
 * Output: [1,3,3,1]
 * Follow up:
 *
 * Could you optimize your algorithm to use only O(k) extra space?
 *
 * Time:        1 ms        88.95%      O(N^2)
 * Space:       33.7 MB     5.06%       O(N^2)
 *
 * https://leetcode.com/problems/pascals-triangle-ii/
 */
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new ArrayList<>();
        if( rowIndex < 0 ) { return ret; }
        ret.add(1);
        if( rowIndex == 0 ) { return ret; }
        List<Integer> last = getRow(rowIndex - 1);
        for(int i = 1; i < rowIndex; ++i) {
            ret.add( last.get(i-1) + last.get(i) );
        }
        ret.add(1);
        return ret;
    }
}
