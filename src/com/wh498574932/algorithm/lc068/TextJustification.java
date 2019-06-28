package com.wh498574932.algorithm.lc068;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and
 * is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces
 * ' ' when necessary so that each line has exactly maxWidth characters.
 *
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not
 * divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 *
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 *
 * Note:
 *
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 *
 * Example 1:
 *
 * Input:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * Output:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 *
 * Example 2:
 *
 * Input:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * Output:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be",
 *              because the last line must be left-justified instead of fully-justified.
 *              Note that the second line is also left-justified becase it contains only one word.
 *
 * Example 3:
 *
 * Input:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 *          "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * Output:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 *
 * Time:        0 ms        100.00%     O(N)
 * Space:       35.1 MB     88.33%      O(N)
 *
 * https://leetcode.com/problems/text-justification/
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ret = new ArrayList<>();
        List<String> res = new ArrayList<>();
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < words.length; ++i) {
            if( ( sum > 0 ? 1 : 0 ) + words[i].length() + sum > maxWidth ) {
                int spaces = maxWidth - sum;
                if( res.size() == 1 ) {
                    sb.append( res.get(0) );
                    for(int k = 0; k < maxWidth-res.get(0).length(); ++k) {
                        sb.append(' ');
                    }
                } else {
                    int div = spaces / ( res.size() - 1 );
                    int remain = spaces - div*(res.size()-1);
                    for(int j = 0; j < res.size(); ++j) {
                        if(j > 0) {
                            sb.append(' ');
                            for(int k = 0; k < div; ++k) { sb.append(' '); }
                            if(remain-- > 0) { sb.append(' '); }
                        }
                        sb.append(res.get(j));
                    }
                }
                ret.add( sb.toString() );
                res = new ArrayList<>();
                sum = 0;
                sb = new StringBuilder();
                i--;
            } else if(i == words.length-1) {
                sum += (( sum > 0 ? 1 : 0 ) + words[i].length());
                res.add( words[i] );
                for(int k = 0; k < res.size(); ++k) {
                    if( k != 0 ) { sb.append(' '); }
                    sb.append( res.get(k) );
                }
                for(int k = 0; k < maxWidth - sum; ++k) { sb.append(' '); }
                ret.add( sb.toString() );
            } else {
                sum += (( sum > 0 ? 1 : 0 ) + words[i].length());
                res.add( words[i] );
            }
        }
        return ret;
    }
}
