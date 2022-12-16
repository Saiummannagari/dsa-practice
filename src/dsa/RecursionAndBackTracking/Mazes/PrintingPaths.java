package dsa.RecursionAndBackTracking.Mazes;

import java.util.ArrayList;

public class PrintingPaths {

    public static void main(String[] args) {
        boolean[][] board = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };

        printPaths("", board, 0, 0);
        System.out.println(printPaths2("", board, 0, 0));
    }

    //with no return type
    static void printPaths(String p,boolean[][] board,  int row, int col) {
        if(row == board.length-1&& col ==board[0].length-1) {
            System.out.println(p);
            return;
        }

        if(col <board[0].length-1) {
            printPaths(p + "R", board, row, col + 1);
        }
        if(row < board.length-1) {
            printPaths(p + "D", board, row + 1, col);
        }
    }

    // Returning arrayList
    static ArrayList<String> printPaths2(String p,boolean[][] board,  int row, int col) {
        if(row == board.length-1 && col ==board[0].length-1) {
          return new ArrayList<>(){{add(p);}};
        }
        ArrayList<String> all = new ArrayList<>();
        if(col <board[0].length-1) {
            all.addAll(printPaths2(p + "R", board, row, col + 1));
        }
        if(row < board.length-1) {
            all.addAll(printPaths2(p + "D", board, row + 1, col));
        }
        return all;
    }
}