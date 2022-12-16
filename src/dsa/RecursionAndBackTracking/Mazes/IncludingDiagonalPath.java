package dsa.RecursionAndBackTracking.Mazes;

import java.util.ArrayList;

public class IncludingDiagonalPath {

    public static void main(String[] args) {

        boolean[][] board = {
                {true, true, true},
                {true, false, true},
                {true, true, true}
        };

        printPaths("", board, 0, 0);
        System.out.println(printPaths2("", board, 0, 0));
        System.out.println(countPaths("", board, 0, 0));

        boolean[][] board2 = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };

        printPaths("", board2, 0, 0);
        System.out.println(printPaths2("", board2, 0, 0));
        System.out.println(countPaths("", board2, 0, 0));
    }

    //with no return type
    static void printPaths(String p,boolean[][] board,  int row, int col) {
        if(row == board.length-1&& col ==board[0].length-1) {
            System.out.println(p);
            return;
        }
        if(!board[row][col]) {
            return;
        }

        if(col <board[0].length-1) {
            printPaths(p + "H", board, row, col + 1);
        }
        if(row < board.length-1) {
            printPaths(p + "V", board, row + 1, col);
        }
        if(col <board[0].length-1 && row < board.length-1) {
            printPaths(p + "D", board, row + 1, col+1);
        }
    }

    // Returning arrayList
    static ArrayList<String> printPaths2(String p, boolean[][] board, int row, int col) {
        if(row == board.length-1 && col ==board[0].length-1) {
            return new ArrayList<>(){{add(p);}};
        }

        if(!board[row][col]) {
            return new ArrayList<>();
        }
        ArrayList<String> all = new ArrayList<>();
        if(col <board[0].length-1) {
            all.addAll(printPaths2(p + "H", board, row, col + 1));
        }
        if(row < board.length-1) {
            all.addAll(printPaths2(p + "V", board, row + 1, col));
        }
        if(col <board[0].length-1 && row < board.length-1) {
            all.addAll(printPaths2(p + "D", board, row + 1, col+1));
        }
        return all;
    }

    //counting paths
    static int countPaths(String p, boolean[][] board, int row, int col) {
        if(row == board.length-1 && col ==board[0].length-1) {
            return 1;
        }

        if(!board[row][col]) {
            return 0;
        }
        int count =0;
        if(col <board[0].length-1) {
            count = count+ countPaths(p + "H", board, row, col + 1);
        }
        if(row < board.length-1) {
            count = count+  countPaths(p + "V", board, row + 1, col);
        }
        if(col <board[0].length-1 && row < board.length-1) {
            count = count+  countPaths(p + "D", board, row + 1, col+1);
        }
        return count;
    }
}