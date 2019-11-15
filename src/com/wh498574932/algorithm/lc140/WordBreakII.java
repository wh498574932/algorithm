package com.wh498574932.algorithm.lc140;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct
 * a sentence where each word is a valid dictionary word. Return all such possible sentences.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 *
 * Example 1:
 *
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 *
 * Example 2:
 *
 * Input:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 *
 * Example 3:
 *
 * Input:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output:
 * []
 *
 * Time:        2 ms        99.58%      O(N^2 + |E| + |V|)
 * Space:       36.9 MB     100.00%     O(N^2 + |E| + |V|)
 *
 * https://leetcode.com/problems/word-break-ii/
 */
public class WordBreakII
{
    public List<String> wordBreak(final String s, final List<String> wordDict)
    {
        final List<List<String>> possibleSubstringsFromIndex = new ArrayList<>();
        for(int i = 0; i < s.length(); ++i)
        {
            possibleSubstringsFromIndex.add( new ArrayList<>() );
        }

        int maxLengthInDic = 0;
        final Set<String> wordSet = new HashSet<>();
        for(final String word : wordDict)
        {
            wordSet.add(word);
            maxLengthInDic = Math.max( maxLengthInDic, word.length() );
        }

        for(int i = s.length() - 1; i >= 0; --i)
        {
            populatePossibleSubstringsFromIndex(
                s,
                possibleSubstringsFromIndex,
                maxLengthInDic,
                wordSet,
                i
            );
        }
        final List<String> ret = new ArrayList<>();
        fillInResult(ret, "", possibleSubstringsFromIndex, 0);
        return ret;
    }

    private void populatePossibleSubstringsFromIndex(
        final String s,
        final List<List<String>> possibleSubstringsFromIndex,
        final int maxLengthInDic,
        final Set<String> wordSet,
        final int start)
    {
        final int maxSubstringLength = Math.min( start + maxLengthInDic, s.length() );
        for(int i = start + 1; i <= maxSubstringLength; ++i)
        {
            final String substring = s.substring(start, i);
            if(wordSet.contains(substring) &&
                (i == s.length() || possibleSubstringsFromIndex.get(i).size() > 0))
            {
                possibleSubstringsFromIndex.get(start).add(substring);
            }
        }
    }

    private void fillInResult(
        final List<String> ret,
        final String res,
        final List<List<String>> possibleSubstringsFromIndex,
        final int start)
    {
        if(start == possibleSubstringsFromIndex.size())
        {
            ret.add(res);
            return;
        }
        for(final String substring : possibleSubstringsFromIndex.get(start))
        {
            fillInResult(
                ret,
                res + (res.length() > 0 ? " " : "") + substring,
                possibleSubstringsFromIndex,
                start + substring.length()
            );
        }
    }
}
