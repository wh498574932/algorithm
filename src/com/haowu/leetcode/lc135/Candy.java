package com.haowu.leetcode.lc135;

/**
 * There are N children standing in a line. Each child is assigned a rating value.
 *
 * You are giving candies to these children subjected to the following requirements:
 *
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 */
public class Candy {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length < 1) { return 0; }
        int[] dp = new int[ratings.length];
        dp[0] = 1;
        for(int i = 1; i < ratings.length; ++i) {
            dp[i] = ratings[i] > ratings[i-1] ? dp[i-1] + 1 : 1;
        }
        int ret = dp[ratings.length-1];
        for(int i = ratings.length-2; i >= 0; --i) {
            dp[i] = ratings[i] > ratings[i+1] ? Math.max(dp[i], dp[i+1]+1) : dp[i];
            ret += dp[i];
        }
        return ret;
    }
}
