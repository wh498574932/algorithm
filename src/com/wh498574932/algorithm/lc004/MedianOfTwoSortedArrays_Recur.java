package com.wh498574932.algorithm.lc004;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Time:    23 ms       86.27%      O(log(M+N))
 * Space:   49.6 MB     42.26%      O(log(M+N))
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class MedianOfTwoSortedArrays_Recur {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null) {
            return 0.0;
        }
        int m = nums1.length;
        int n = nums2.length;
        return (
            findKth(nums1, 0, nums2, 0, (m + n + 1)/2) +
                findKth(nums1, 0, nums2, 0, (m + n + 2)/2)
        ) / 2.0;
    }

    private double findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        if(i >= nums1.length) {
            return nums2[k + j - 1];
        }
        if(j >= nums2.length) {
            return nums1[k + i - 1];
        }
        if(k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        int mid1 = i+k/2-1 >= nums1.length ? Integer.MAX_VALUE : nums1[i+k/2-1];
        int mid2 = j+k/2-1 >= nums2.length ? Integer.MAX_VALUE : nums2[j+k/2-1];
        return mid1 < mid2 ?
            findKth(nums1, i+k/2, nums2, j, k-k/2) :
            findKth(nums1, i, nums2, j+k/2, k-k/2);
    }
}
