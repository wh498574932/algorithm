package com.wh498574932.algorithm.lc060;

import java.util.ArrayList;
import java.util.List;

/**
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 * Note:
 *
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 *
 * Example 1:
 *
 * Input: n = 3, k = 3
 * Output: "213"
 *
 * Example 2:
 *
 * Input: n = 4, k = 9
 * Output: "2314"
 *
 * Time:        1 ms        99.50%      O(N)
 * Space:       34.2 MB     100.00%     O(N)
 *
 * https://leetcode.com/problems/permutation-sequence/
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        List<Integer> res = new ArrayList<>();
        int div = 1;
        for(int i = 1; i <= n; ++i) { res.add(i); div *= i;}
        div /= n;
        k--;
        StringBuilder sb = new StringBuilder();
        for(int i = n - 1; i >= 0; i--) {
            sb.append( res.get( k/div ) );
            res.remove( k/div );
            k %= div;
            if(i > 0) { div /= i; }
        }
        return sb.toString();
    }
}
