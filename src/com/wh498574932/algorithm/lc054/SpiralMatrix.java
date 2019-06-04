package com.wh498574932.algorithm.lc054;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example 1:
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 * Example 2:
 *
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * Time:        0 ms        100.00%     O(M*N)
 * Space:       34.3 MB     99.90%      O(1)
 *
 * https://leetcode.com/problems/spiral-matrix/
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        if( matrix == null || matrix.length < 1 || matrix[0].length < 1 ) {
            return ret;
        }
        int lvl = Math.min( matrix.length, matrix[0].length ) / 2;
        for(int k = 0; k < lvl; ++k) {
            for(int i = k; i < matrix[0].length-1-k; ++i) {
                ret.add( matrix[k][i] );
            }
            for(int i = k; i < matrix.length-1-k; ++i) {
                ret.add( matrix[i][matrix[0].length-1-k] );
            }
            for(int i = matrix[0].length-1-k; i > k; --i) {
                ret.add( matrix[matrix.length-1-k][i] );
            }
            for(int i = matrix.length-1-k; i > k; --i) {
                ret.add( matrix[i][k] );
            }
        }
        if( Math.min( matrix.length, matrix[0].length ) % 2 != 0 ) {
            if( matrix.length == matrix[0].length ) {
                ret.add( matrix[lvl][lvl] );
            }
            else if( matrix.length < matrix[0].length ) {
                for(int i = lvl; i < matrix[0].length-lvl; ++i) {
                    ret.add( matrix[lvl][i] );
                }
            }
            else {
                for(int i = lvl; i < matrix.length-lvl; ++i) {
                    ret.add( matrix[i][lvl] );
                }
            }
        }
        return ret;
    }
}
