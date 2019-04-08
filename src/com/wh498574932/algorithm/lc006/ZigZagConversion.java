package com.wh498574932.algorithm.lc006;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to
 * display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * Time:        3 ms        99.28%      O(N)
 * Space:       39.4 MB     85.17%      O(1)
 *
 * https://leetcode.com/problems/zigzag-conversion/
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(s == null || s.length() <= 1 ||  numRows <= 1 || s.length() <= numRows) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for(int r = 0; r < numRows; ++r) {
            for(int i = r; i < s.length(); i += (2*numRows - 2)) {
                sb.append( s.charAt(i) );
                int m = i + 2*numRows - 2 - 2*r;
                if( r != 0 && r != numRows-1 && m < s.length() ) {
                    sb.append( s.charAt(m) );
                }
            }
        }
        return sb.toString();
    }
}
