package com.wh498574932.algorithm.lc127;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation
 * sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 *
 * Note:
 *
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 *
 * Example 1:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 *
 * Example 2:
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 *
 * Time:        60 ms       55.73%      O(M*N)
 * Space:       44.1 MB     25.55%      O(M*N)
 *
 * https://leetcode.com/problems/word-ladder/
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if( !wordList.contains(endWord) ) { return 0; }
        int len = endWord.length();
        Map<String, List<String>> dic = dic(wordList, len);
        Queue<String> q = new LinkedList<>();
        Map<String, Integer> visitedBegin = new HashMap<>();
        Map<String, Integer> visitedEnd = new HashMap<>();
        q.offer(beginWord);
        q.offer(endWord);
        visitedBegin.put(beginWord, 1);
        visitedEnd.put(endWord, 1);
        while(!q.isEmpty()) {
            String curr = q.poll();
            boolean isBegin = visitedBegin.containsKey(curr);
            for(int i = 0; i < len; ++i) {
                String key = curr.substring(0, i) + '*' + curr.substring(i+1, len);
                if( dic.containsKey(key) ) {
                    List<String> value = dic.get( key );
                    Map<String, Integer> thisVisited = isBegin ? visitedBegin : visitedEnd;
                    Map<String, Integer> thatVisited = isBegin ? visitedEnd : visitedBegin;
                    for(String next : value) {
                        if(thisVisited.containsKey(next)) { continue; }
                        if(thatVisited.containsKey(next)) {
                            return thisVisited.get(curr) + thatVisited.get(next);
                        }
                        thisVisited.put(next, thisVisited.get(curr)+1);
                        q.offer(next);
                    }
                }
            }
        }
        return 0;
    }

    private Map<String, List<String>> dic(List<String> wordList, int len) {
        Map<String, List<String>> dic = new HashMap<>();
        wordList.forEach( word -> {
            for(int i = 0; i < len; ++i) {
                String key = word.substring(0, i) + '*' + word.substring(i + 1, len);
                List<String> value = dic.getOrDefault( key, new ArrayList<>() );
                value.add( word );
                dic.put(key, value);
            }
        } );
        return dic;
    }
}
