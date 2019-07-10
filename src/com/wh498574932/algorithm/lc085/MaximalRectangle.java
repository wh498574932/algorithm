package com.wh498574932.algorithm.lc085;

import java.util.Stack;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 * Output: 6
 *
 * Time:        25 ms       46.64%      O(M*N)
 * Space:       42.8 MB     93.52%      O(N)
 *
 * https://leetcode.com/problems/maximal-rectangle/
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if( matrix == null || matrix.length < 1 || matrix[0].length < 1 ) { return 0; }
        int max = 0;
        int[] h = new int[matrix[0].length];
        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix[0].length; ++j) {
                h[j] = matrix[i][j] == '1' ? h[j] + 1 : 0;
            }
            max = Math.max( max, largestRectangleArea(h) );
        }
        return max;
    }

    private int largestRectangleArea(int[] heights) {
        if( heights == null || heights.length < 1 ) { return 0; }
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for(int i = 0; i < heights.length; ++i) {
            while( !stack.isEmpty() && heights[stack.peek()] > heights[i] ) {
                int index = stack.pop();
                max = Math.max(
                    max,
                    stack.isEmpty() ?
                        i * heights[index] :
                        (i - stack.peek() - 1) * heights[index]
                );
            }
            stack.push(i);
        }
        while( !stack.isEmpty() ) {
            int index = stack.pop();
            max = Math.max(
                max,
                stack.isEmpty() ?
                    heights.length * heights[index] :
                    (heights.length - stack.peek() - 1) * heights[index]
            );
        }
        return max;
    }
}
