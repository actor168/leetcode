package leetcode.editor.cn;
/*
 * @lc app=leetcode.cn id=1091 lang=java
 *
 * [1091] 二进制矩阵中的最短路径
 */

import java.util.LinkedList;
import java.util.Queue;

// @lc code=start
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        // 求解最短路径 1. 动态规划 2. BFS 本题适用BFS
        int m = grid.length;
        if (m <= 0) {return -1;}
        int n = grid[0].length;

        int[][] directions = new int[][]{{-1,-1}, {-1,0}, {-1,1}, {0,1}, {0,-1}, {1,-1}, {1,0}, {1,1}};
        if (grid[0][0] == 1 || grid[m-1][n-1] == 1) return -1;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        int cnt = 0;
        while(q.size() > 0) {
            cnt++;
            int size = q.size();
            for(int j = 0; j < size; j++) {
                int[] pos = q.poll();
                int x = pos[0], y = pos[1];

                if (x == m-1 && y == n-1) return cnt;

                for(int i = 0; i < directions.length; i++) {
                    // 往所有的方向走，最快到达终点的一定是最短的路径
                    int newX = x + directions[i][0];
                    int newY = y + directions[i][1];

                    if (inGrid(newX, newY, m, n) && grid[newX][newY] == 0) {
                        q.add(new int[]{newX, newY});
                        grid[newX][newY] = 1;
                    }
                }
            }
        }
        return -1;
    }

    private boolean inGrid(int newX, int newY, int M, int N) {
        return newX >= 0  && newX < M && newY >= 0 && newY < N;
    }
}
// @lc code=end