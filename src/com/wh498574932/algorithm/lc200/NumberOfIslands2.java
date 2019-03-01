package com.wh498574932.algorithm.lc200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water
 * and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are
 * all surrounded by water.
 *
 * https://leetcode.com/problems/number-of-islands/
 *
 * Accepted: 5 ms	40.8 MB
 */
public class NumberOfIslands2 {
    public int numIslands(char[][] grid) {
        int ret = 0;
        if(grid == null || grid.length < 1 || grid[0].length < 1) {
            return ret;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; ++i) {
            for(int j = 0; j < grid[0].length; ++j) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    ret++;
                    visited[i][j] = true;
                    bfs(grid, visited, i, j);
                }
            }
        }
        return ret;
    }

    private void bfs(char[][] grid, boolean[][] visited, int r, int c) {
        int[][] direction = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        Queue<Integer> q = new LinkedList<>();
        q.offer( r * grid[0].length + c );
        while(!q.isEmpty()) {
            int val = q.poll();
            int row = val / grid[0].length;
            int col = val % grid[0].length;
            for(int k = 0; k < direction.length; ++k) {
                int i = direction[k][0] + row;
                int j = direction[k][1] + col;
                if(i >= 0 &&
                    i < grid.length &&
                    j >= 0 &&
                    j < grid[0].length &&
                    !visited[i][j] &&
                    grid[i][j] == '1')
                {
                    visited[i][j] = true;
                    q.offer(i * grid[0].length + j);
                }
            }
        }
    }
}
