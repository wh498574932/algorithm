package com.wh498574932.algorithm.lc011;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines
 * are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis
 * forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 *
 * Time:        2 ms        98.05%      O(N)
 * Space:       40.8 MB     10.02%      O(1)
 *
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if(height == null || height.length < 2) { return 0; }
        int l = 0, r = height.length-1;
        int ret = 0;
        while(l < r) {
            ret = Math.max( ret, Math.min( height[l], height[r] ) * ( r-l ) );
            if(height[l] < height[r]) { l++; }
            else { r--; }
        }
        return ret;
    }
}
