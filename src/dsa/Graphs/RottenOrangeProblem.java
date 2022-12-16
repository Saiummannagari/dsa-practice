package dsa.Graphs;

import java.util.LinkedList;
import java.util.Queue;

/*
Breadth first search algorithm to solve Rotten Orange Problem

A matrix of m*n where each cell in the matrix have Fresh,Rotten and Empty Cell. Write algorithm to find minimum time required so that all the oranges become rotten in Time Complexity O(m*n) and Space Complexity O*m*n) i.e extra matrix space Asked in : Microsoft, Amazon, Expedia

Example:

[In a given matrix , each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange]
Input: [[2,1,1],[1,1,0],[0,1,1]]

Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: 4

Output: -1

Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Hint: Same as Number of Island problem, think of BFS approach
 */
class RottenOrangeProblem {

    static class Cell {
        int i;
        int j;
        int value;

        Cell(int i, int j, int value) {
            this.i = i;
            this.j = j;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        int matrix[][] = { {2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}};
        int ans = rottanOrange(matrix);
        if(ans == -1)
            System.out.println("Not a valid case");
        else
            System.out.println("Time required for all oranges to rot = " + ans);

        int matrix2[][] = {{2,1,1},
                           {1,1,0},
                           {0,1,1}};
        int ans2 = rottanOrange(matrix2);
        if(ans2 == -1)
            System.out.println("Not a valid case");
        else
            System.out.println("Time required for all oranges to rot = " + ans2);

        int matrix3[][] = {{2,1,1},
                           {0,1,1},
                           {1,0,1}};
        int ans3 = rottanOrange(matrix3);
        if(ans3 == -1)
            System.out.println("Not a valid case");
        else
            System.out.println("Time required for all oranges to rot = " + ans3);
    }

    private static int rottanOrange(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        Queue<Cell> queue = new LinkedList<>();
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(matrix[i][j] == 2) {
                    queue.add(new Cell(i, j, 1));
                }
            }
        }

        while(!queue.isEmpty()) {
            Cell c = queue.poll();
            int i = c.i;
            int j = c.j;
            int val = c.value;
            if(isValid(rows, cols, i-1, j, matrix)) {
                matrix[i-1][j] = val+1;
                queue.add(new Cell(i-1, j, val+1));
            }
            if(isValid(rows, cols, i+1, j, matrix)) {
                matrix[i+1][j] = val+1;
                queue.add(new Cell(i+1, j, val+1));
            }
            if(isValid(rows, cols, i, j-1, matrix)) {
                matrix[i][j-1] = val+1;
                queue.add(new Cell(i, j-1, val+1));
            }
            if(isValid(rows, cols, i, j+1, matrix)) {
                matrix[i][j+1] = val+1;
                queue.add(new Cell(i, j+1, val+1));
            }
        }
        int max =0;
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(matrix[i][j] == 1) {
                    return -1;
                }
                max = Math.max(max, matrix[i][j]);
            }
        }
        return max;
    }

    public static boolean isValid(int rows, int cols, int i, int j, int[][] matrix) {
        if(i>=0 && i<rows && j>=0 && j<cols && matrix[i][j] ==1){
            return true;
        }
        return false;
    }
}