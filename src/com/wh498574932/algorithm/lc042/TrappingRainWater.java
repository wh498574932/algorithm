package com.wh498574932.algorithm.lc042;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water
 * it is able to trap after raining.
 *
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue
 * section) are being trapped. Thanks Marcos for contributing this image!
 *
 * Example:
 *
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 *
 * Time:        1 ms        99.76%      O(N)
 * Space:       36.6 MB     99.72%      O(N)
 *
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        if(height == null || height.length < 3) { return 0; }
        int[] maxHeight = new int[height.length];
        for(int i = 0; i < height.length - 1; ++i) {
            if( i == 0 ) { maxHeight[i] = height[i]; }
            else { maxHeight[i] = Math.max( maxHeight[i-1], height[i] ); }
        }
        int ret = 0;
        for(int i = height.length - 1; i > 0; --i) {
            if( i == height.length - 1 ) {
                maxHeight[i] = height[i];
            } else {
                ret += height[i] < maxHeight[i+1] && height[i] < maxHeight[i-1]
                    ? Math.min( maxHeight[i+1], maxHeight[i-1] ) - height[i]
                    : 0;
                maxHeight[i] = Math.max( height[i], maxHeight[i+1] );
            }
        }
        return ret;
    }
}
