package com.wh498574932.algorithm.lc073;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 *
 * Example 1:
 *
 * Input:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * Output:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 *
 * Example 2:
 *
 * Input:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * Output:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 *
 * Follow up:
 *
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 *
 * Time:        1 ms        99.77%      O(M*N)
 * Space:       48.8 MB     32.82%      O(1)
 *
 * https://leetcode.com/problems/set-matrix-zeroes/
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        if( matrix == null || matrix.length < 1 || matrix[0].length < 1 ) { return; }
        boolean row = false, col = false;
        for(int i = 0; i < matrix.length; ++i) {
            if( matrix[i][0] == 0 ) {
                col = true;
                break;
            }
        }
        for(int i = 0; i < matrix[0].length; ++i) {
            if( matrix[0][i] == 0 ) {
                row = true;
                break;
            }
        }
        for(int i = 1; i < matrix.length; ++i) {
            for(int j = 1; j < matrix[0].length; ++j) {
                if( (matrix[i][0] != 0 || matrix[0][j] != 0) && matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1; i < matrix.length; ++i) {
            for(int j = 1; j < matrix[0].length; ++j) {
                if( matrix[i][0] == 0 || matrix[0][j] == 0 ) { matrix[i][j] = 0; }
            }
        }
        if(row) { for(int i = 0; i < matrix[0].length; ++i) { matrix[0][i] = 0; } }
        if(col) { for(int i = 0; i < matrix.length; ++i) { matrix[i][0] = 0; } }
    }
}
