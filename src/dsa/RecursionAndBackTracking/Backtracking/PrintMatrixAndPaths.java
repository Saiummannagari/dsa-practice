package dsa.RecursionAndBackTracking.Backtracking;

import java.util.Arrays;

public class PrintMatrixAndPaths {

    public static void main(String[] args) {
        boolean[][] board = {
                {true, true, true},
                {true, false, true},
                {true, true, true}
        };
        printMatrixAndPaths("", board, 0, 0, new int[board.length][board[0].length], 1);
        System.out.println();
        boolean[][] board2 = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        printMatrixAndPaths("", board2, 0, 0, new int[board2.length][board2[0].length], 1);
    }

    static void printMatrixAndPaths(String p, boolean[][] board, int row, int col, int[][] path, int count) {
        if(row == board.length-1 && col == board[0].length-1) {
            path[row][col] = count;
            for(int[] arr : path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }

        if(board[row][col] == false) {
            return;
        }
        board[row][col] = false;
        path[row][col] = count;
        if(col < board[0].length-1) {
            printMatrixAndPaths(p+'R', board, row, col+1, path,count+1);
        }
        if(col > 0) {
            printMatrixAndPaths(p+'L', board, row, col-1, path,count+1);
        }
        if(row > 0) {
            printMatrixAndPaths(p+'U', board, row-1, col, path,count+1);
        }
        if(row < board.length-1) {
            printMatrixAndPaths(p+'D', board, row+1, col, path,count+1);
        }
        board[row][col] = true;
        path[row][col] = 0;
    }
}