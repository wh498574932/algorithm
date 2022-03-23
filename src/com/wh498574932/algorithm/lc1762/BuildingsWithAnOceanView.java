package com.wh498574932.algorithm.lc1762;

import java.util.Stack;

public class BuildingsWithAnOceanView {
    public int[] findBuildings(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(heights.length-1);
        for(int i = heights.length - 2; i >= 0; i--) {
            if(heights[i] > heights[stack.peek()]) {
                stack.push(i);
            }
        }
        int[] ret = new int[stack.size()];
        for(int i = 0; i < ret.length; ++i) {
            ret[i] = stack.pop();
        }
        return ret;
    }
}
