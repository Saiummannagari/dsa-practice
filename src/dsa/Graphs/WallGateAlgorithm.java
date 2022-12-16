package dsa.Graphs;/*
You are given a m x n 2D grid initialized with these three possible values. -1 - A wall or an obstacle. 0 - A gate. INF - Infinity means an empty room Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate

Example:

For example, given the 2D grid:
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:
  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
 */

import java.util.LinkedList;
import java.util.Queue;

class WallGateAlgorithm {

    static class Cell {
        int m;
        int n;
        int cost;

        Cell(int m, int n, int cost) {
            this.cost = cost;
            this.m = m;
            this.n = n;
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {{Integer.MAX_VALUE,-1,0,Integer.MAX_VALUE},
                          {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,-1},
                          {Integer.MAX_VALUE,-1,Integer.MAX_VALUE,-1},
                          {0,-1,Integer.MAX_VALUE,Integer.MAX_VALUE}};
        wallsAndGates(matrix);
    }

    public static void wallsAndGates(int[][] matrix)
    {
        int rows = matrix.length;
        int cols = matrix[0].length;
        Queue<Cell> queue = new LinkedList<>();
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(matrix[i][j]==0) {
                    queue.add(new Cell(i, j, 0));
                }
            }
        }

        while(!queue.isEmpty()) {
            Cell c = queue.poll();

            if(isValid(c.m-1, c.n, rows, cols, matrix)) {
                matrix[c.m-1][c.n] = c.cost+1;
                queue.add(new Cell(c.m-1, c.n, c.cost+1));
            }

            if(isValid(c.m+1, c.n, rows, cols, matrix)) {
                matrix[c.m+1][c.n] = c.cost+1;
                queue.add(new Cell(c.m+1, c.n, c.cost+1));
            }

            if(isValid(c.m, c.n-1, rows, cols, matrix)) {
                matrix[c.m][c.n-1] = c.cost+1;
                queue.add(new Cell(c.m, c.n-1, c.cost+1));
            }

            if(isValid(c.m, c.n+1, rows, cols, matrix)) {
                matrix[c.m][c.n+1] = c.cost+1;
                queue.add(new Cell(c.m, c.n+1, c.cost+1));
            }
        }

        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    static boolean isValid(int i, int j, int m, int n, int[][] matrix) {
        if(i>=0 && i<m && j>=0 && j<n && matrix[i][j]==Integer.MAX_VALUE) {
            return  true;
        }
        return false;
    }
}