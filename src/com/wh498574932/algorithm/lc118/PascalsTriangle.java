package com.wh498574932.algorithm.lc118;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * Time:        0 ms        100.00%     O(N^2)
 * Space:       34 MB       5.06%       O(1)
 *
 * https://leetcode.com/problems/pascals-triangle/
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        if( numRows < 1 ) { return ret; }
        List<Integer> res = new ArrayList<>();
        res.add(1);
        ret.add(res);
        if( numRows == 1 ) { return ret; }
        for(int lvl = 2; lvl <= numRows; ++lvl) {
            List<Integer> newRes = new ArrayList<>();
            List<Integer> last = ret.get(lvl - 2);
            newRes.add(1);
            for(int i = 1; i < lvl - 1; ++i) {
                newRes.add( last.get(i-1) + last.get(i) );
            }
            newRes.add(1);
            ret.add( newRes );
        }
        return ret;
    }
}
