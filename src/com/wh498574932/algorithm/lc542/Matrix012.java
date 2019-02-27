package com.wh498574932.algorithm.lc542;

/**
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 *
 * The distance between two adjacent cells is 1.
 *
 * Note:
 * The number of elements of the given matrix will not exceed 10,000.
 * There are at least one 0 in the given matrix.
 * The cells are adjacent in only four directions: up, down, left and right.
 *
 * Feb 1st, 2019
 */
public class Matrix012 {
    public int[][] updateMatrix(int[][] matrix) {
        int[][] ret = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix[0].length; ++j) {
                if(matrix[i][j] == 0) {
                    ret[i][j] = 0;
                } else {
                    ret[i][j] = Integer.MAX_VALUE - 1;
                    if(i > 0) {
                        ret[i][j] = Math.min(ret[i][j], ret[i-1][j]+1);
                    }
                    if(j > 0) {
                        ret[i][j] = Math.min(ret[i][j], ret[i][j-1]+1);
                    }
                }
            }
        }
        for(int i = matrix.length-1; i >= 0; i--) {
            for(int j = matrix[0].length-1; j >=0; j--) {
                if(i < matrix.length-1) {
                    ret[i][j] = Math.min(ret[i][j], ret[i+1][j]+1);
                }
                if(j < matrix[0].length-1) {
                    ret[i][j] = Math.min(ret[i][j], ret[i][j+1]+1);
                }
            }
        }
        return ret;
    }
}
