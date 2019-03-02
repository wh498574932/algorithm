package com.wh498574932.algorithm.lc278;

/**
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of
 * your product fails the quality check. Since each version is developed based on the previous version, all the versions
 * after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following
 * ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to
 * find the first bad version. You should minimize the number of calls to the API.
 *
 * https://leetcode.com/problems/first-bad-version/
 *
 * Accepted	11 ms (99.93%)	34.4 MB (52.72%)
 *
 * Jan 28th, 2019 - FB - PS
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int l = 1, r = n;
        while(l <= r) {
            int m = (r - l) / 2 + l; // avoid integer overflow.
            if(isBadVersion(m)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    /**
     * Fake Method for compiling purpose.
     * @param m version number.
     * @return whether the version is bad or not.
     */
    private boolean isBadVersion(int m) {
        return m > 8;
    }
}
