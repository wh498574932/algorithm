package com.wh498574932.algorithm.lc059;

/**
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * Example:
 *
 * Input: 3
 * Output:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 * Time:        0 ms        100.00%     O(N^2)
 * Space:       34.1 MB     38.14%      O(1)
 *
 * https://leetcode.com/problems/spiral-matrix-ii/
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        int val = 1;
        for(int k = 0; k < n/2; ++k) {
            for(int i = k; i < n - k - 1; ++i) { ret[k][i] = val++; }
            for(int i = k; i < n - k - 1; ++i) { ret[i][n-k-1] = val++; }
            for(int i = n - k - 1; i > k; --i) { ret[n-k-1][i] = val++; }
            for(int i = n - k - 1; i > k; --i) { ret[i][k] = val++; }
        }
        if( n % 2 != 0 ) { ret[n/2][n/2] = val; }
        return ret;
    }
}
