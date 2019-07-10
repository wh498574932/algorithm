package com.wh498574932.algorithm.lc084;

import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area
 * of largest rectangle in the histogram.
 *
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 *
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 *
 * Example:
 *
 * Input: [2,1,5,6,2,3]
 * Output: 10
 *
 * Time:        13 ms       71.33%      O(N)
 * Space:       39.7 MB     98.77%      O(N)
 *
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
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
