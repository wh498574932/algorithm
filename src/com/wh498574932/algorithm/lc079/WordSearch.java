package com.wh498574932.algorithm.lc079;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally
 * or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 *
 * Time:        8 ms        28.32%      Exponential
 * Space:       38.5 MB     98.54%      Exponential
 *
 * https://leetcode.com/problems/word-search/
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if( board == null || board.length < 1 || board[0].length < 1 || word == null || word.length() < 1 ) {
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; ++i) {
            for(int j = 0; j < board[0].length; ++j) {
                if(helper(board, word, 0, i, j, visited)) { return true; }
            }
        }
        return false;
    }

    private boolean helper(
        char[][] board,
        String word,
        int start,
        int r,
        int c,
        boolean[][] visited)
    {
        if( start == word.length() ) { return true; }
        if( r < 0
            || r == board.length
            || c < 0
            || c == board[0].length
            || visited[r][c]
            || board[r][c] != word.charAt(start) )
        {
            return false;
        }
        visited[r][c] = true;
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int[] dir : directions) {
            if(helper(board, word, start+1, r+dir[0], c+dir[1], visited)) { return true; }
        }
        visited[r][c] = false;
        return false;
    }
}
