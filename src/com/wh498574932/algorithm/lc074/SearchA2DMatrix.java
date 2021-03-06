package com.wh498574932.algorithm.lc074;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 * Example 1:
 *
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 *
 * Example 2:
 *
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 *
 * Time:        0 ms        100.00%     O(log(M*N))
 * Space:       43.1 MB     5.01%       O(1)
 *
 * https://leetcode.com/problems/search-a-2d-matrix/
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if( matrix == null || matrix.length < 1 || matrix[0].length < 1 ) { return false; }
        int l = 0, r = matrix.length * matrix[0].length - 1;
        while( l <= r ) {
            int m = l + (r - l) / 2;
            if( matrix[m/matrix[0].length][m%matrix[0].length] == target ) { return true; }
            else if( matrix[m/matrix[0].length][m%matrix[0].length] < target ) { l = m + 1; }
            else { r = m - 1; }
        }
        return false;
    }
}
