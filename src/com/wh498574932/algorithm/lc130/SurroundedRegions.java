package com.wh498574932.algorithm.lc130;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * Example:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 *
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 * Explanation:
 *
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to
 * 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells
 * are connected if they are adjacent cells connected horizontally or vertically.
 *
 * Time:        2 ms        52.13%      O(M*N)
 * Space:       47.1 MB     21.43%      O(M*N)
 *
 * https://leetcode.com/problems/surrounded-regions/
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        if(board == null || board.length < 1 || board[0].length < 1) { return; }
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < board.length; ++i) {
            if(board[i][0] == 'O') {
                q.offer(i*board[0].length);
                board[i][0] = '#';
            }
            if(board[i][board[0].length-1] == 'O') {
                q.offer(i*board[0].length + board[0].length-1);
                board[i][board[0].length-1] = '#';
            }
        }
        for(int i = 0; i < board[0].length; ++i) {
            if(board[0][i] == 'O') {
                q.offer(i);
                board[0][i] = '#';
            }
            if(board[board.length-1][i] == 'O') {
                q.offer((board.length-1)*board[0].length+i);
                board[board.length-1][i] = '#';
            }
        }
        while(!q.isEmpty()) {
            int val = q.poll();
            int curRow = val / board[0].length, curCol = val % board[0].length;
            for(int[] dir : dirs) {
                int newRow = curRow + dir[0], newCol = curCol + dir[1];
                if(newRow >= 0 &&
                    newRow < board.length &&
                    newCol >= 0 &&
                    newCol < board[0].length &&
                    board[newRow][newCol] == 'O')
                {
                    board[newRow][newCol] = '#';
                    q.offer( newRow * board[0].length + newCol );
                }
            }
        }
        for(int i = 0; i < board.length; ++i) {
            for(int j = 0; j < board[0].length; ++j) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                else if(board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}
