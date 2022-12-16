package dsa.RecursionAndBackTracking.Backtracking;

public class IncludeAllPaths {

    public static void main(String[] args) {
        boolean[][] board = {
                {true, true, true},
                {true, false, true},
                {true, true, true}
        };
        printAllPaths("", board, 0, 0);
        System.out.println();
        System.out.println(returnCount("",board, 0, 0));
        boolean[][] board2 = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        System.out.println();
        printAllPaths("", board2, 0, 0);
        System.out.println();
        System.out.println(returnCount("",board2, 0, 0));
    }

    //prints all paths by backtracking
    static void printAllPaths(String p, boolean[][] board, int row, int col) {
        if(row==board.length-1 && col ==board[0].length-1) {
            System.out.println(p);
            return;
        }

        if(board[row][col] == false) {
            return;
        }
        board[row][col] = false;

        if(col>0) {
            printAllPaths(p+'L', board, row, col-1);
        }

        if(col<board[0].length-1) {
            printAllPaths(p+'R', board, row, col+1);
        }

        if(row<board[0].length-1) {
            printAllPaths(p+'D', board, row+1, col);
        }

        if(row>0) {
            printAllPaths(p+'U', board, row-1, col);
        }
        board[row][col] = true;
    }


    //return the count of all the paths
    static int returnCount(String p, boolean[][] board, int row, int col) {
        if(row==board.length-1 && col ==board[0].length-1) {
            return 1;
        }

        if(board[row][col] == false) {
            return 0;
        }
        board[row][col] = false;
        int counter=0;
        if(col>0) {
            counter = counter + returnCount(p+'L', board, row, col-1);
        }

        if(col<board[0].length-1) {
            counter = counter + returnCount(p+'R', board, row, col+1);
        }

        if(row<board[0].length-1) {
            counter = counter + returnCount(p+'D', board, row+1, col);
        }

        if(row>0) {
            counter = counter + returnCount(p+'U', board, row-1, col);
        }
        board[row][col] = true;
       return counter;
    }
}