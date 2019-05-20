package com.wh498574932.algorithm.lc037;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 * A sudoku solution must satisfy all of the following rules:
 *
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * Empty cells are indicated by the character '.'.
 *
 * Note:
 *
 * The given board contain only digits 1-9 and the character '.'.
 * You may assume that the given Sudoku puzzle will have a single unique solution.
 * The given board size is always 9x9.
 *
 * Time:        9 ms        39.26%      Exponential
 * Space:       37.5 MB     46.69%      Exponential
 *
 * https://leetcode.com/problems/sudoku-solver/
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        helper(board, 0);
    }

    private boolean helper(char[][] board, int i) {
        if( i == 81 ) { return true; }
        if( board[i/9][i%9] != '.' ) { return helper(board, i + 1); }
        for(int k = 0; k < 9; ++k) {
            char temp = (char)('1' + k);
            board[i/9][i%9] = temp;
            if( isValid(board, i/9, i%9) && helper(board, i + 1) ) { return true; }
        }
        board[i/9][i%9] = '.';
        return false;
    }

    private boolean isValid(char[][] board, int i, int j) {
        for(int k = 0; k < 9; ++k) {
            if(i != k && board[i][j] == board[k][j]) { return false; }
            if(j != k && board[i][j] == board[i][k]) { return false; }
            int r = i/3*3+k/3, c = j/3*3+k%3;
            if((i != r || j != c) && board[i][j] == board[r][c]) { return false; }
        }
        return true;
    }
}
