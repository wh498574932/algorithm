package com.wh498574932.algorithm.lc004;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Time:    24 ms       74.53%      O(log(M+N))
 * Space:   49 MB       60.00%      O(1)
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class MedianOfTwoSortedArrays_Iter {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int halfTotalLength = (nums1.length + nums2.length) / 2;
        int l = 0, r = nums1.length - 1;
        while(true) {
            int m;
            if(r == -1) { m = -1; }
            else if (l == nums1.length) { m = nums1.length; }
            else { m = (l+r)/2; }
            System.out.println("m: " + m);
            int n = halfTotalLength - m - 2;
            System.out.println("n: " + n);
            int shortLeft = m >= 0 ? nums1[m] : Integer.MIN_VALUE;
            int shortRight = (m+1) < nums1.length ? nums1[m+1] : Integer.MAX_VALUE;
            int longLeft = n >= 0 ? nums2[n] : Integer.MIN_VALUE;
            int longRight = (n+1) < nums2.length ? nums2[n+1] : Integer.MAX_VALUE;
            if(shortLeft <= longRight && longLeft <= shortRight) {
                return (nums1.length + nums2.length) % 2 == 1 ?
                    Math.min(shortRight, longRight) :
                    (Math.max(shortLeft, longLeft) + Math.min(shortRight, longRight))/2.0;
            } else if(shortLeft > longRight) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
    }
}
