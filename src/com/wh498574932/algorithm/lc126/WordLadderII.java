package com.wh498574932.algorithm.lc126;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s)
 * from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 *
 * Note:
 *
 * Return an empty list if there is no such transformation sequence.
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
 * Output:
 * [
 *   ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 * ]
 *
 * Example 2:
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: []
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 *
 * Time:        225 ms      23.93%      O(N)
 * Space:       51.2 MB     36.54%      O(N)
 *
 * https://leetcode.com/problems/word-ladder-ii/
 */
public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> unvisited = new HashSet<>(wordList);
        List<String> initialPath = new ArrayList<>();
        initialPath.add(beginWord);
        Queue<List<String>> paths = new LinkedList<>();
        paths.offer(initialPath);
        int level = 1, minLevel = Integer.MAX_VALUE;
        Set<String> visitedOfCurrentLevel = new HashSet<>();

        while (!paths.isEmpty()) {
            List<String> path = paths.poll();
            if (path.size() > level) {
                for (String visited : visitedOfCurrentLevel) unvisited.remove(visited);
                visitedOfCurrentLevel.clear();
                level = path.size();
                if (level > minLevel) break;
            }

            String lastWord = path.get( path.size() - 1 );
            for (int i = 0; i < lastWord.length(); ++i) {
                char[] cs = lastWord.toCharArray();
                char c0 = cs[i];
                for (char ch = 'a'; ch <= 'z'; ++ch) {
                    cs[i] = ch;
                    String newLast = new String(cs);
                    if (!unvisited.contains(newLast)) continue;
                    visitedOfCurrentLevel.add(newLast);
                    List<String> nextPath = new ArrayList<>(path);
                    nextPath.add(newLast);
                    if (newLast.equals(endWord)) {
                        res.add(nextPath);
                        minLevel = level;
                    } else {
                        paths.offer(nextPath);
                    }
                }
                cs[i] = c0;
            }
        }
        return res;
    }
}
