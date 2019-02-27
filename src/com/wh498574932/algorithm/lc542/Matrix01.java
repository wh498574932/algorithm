package com.wh498574932.algorithm.lc542;

import java.util.LinkedList;
import java.util.Queue;

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
public class Matrix01 {
    public int[][] updateMatrix(int[][] matrix) {
        int[][] ret = new int[matrix.length][matrix[0].length];
        Queue<Integer> q = new LinkedList<>();
        int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix[0].length; ++j) {
                if(matrix[i][j] == 0) {
                    ret[i][j] = 0;
                    q.offer(i * matrix[0].length + j);
                } else {
                    ret[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while(!q.isEmpty()) {
            int val = q.poll();
            int r0 = val / matrix[0].length;
            int c0 = val % matrix[0].length;
            for (int j = 0; j < direction.length; ++j) {
                int row = r0 + direction[j][0];
                int col = c0 + direction[j][1];
                if (row >= 0 &&
                    row < matrix.length &&
                    col >= 0 &&
                    col < matrix[0].length &&
                    matrix[row][col] == 1 &&
                    ret[row][col] > ret[r0][c0] + 1)
                {
                    ret[row][col] = ret[r0][c0] + 1;
                    q.offer(row * matrix[0].length + col);
                }
            }
        }
        return ret;
    }
}
