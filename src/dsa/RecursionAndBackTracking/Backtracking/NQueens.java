package dsa.RecursionAndBackTracking.Backtracking;

public class NQueens {

    public static void main(String[] args) {
        int board[][] = {{ 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 }};

        System.out.println(nqueens(board, 0));
    }

    //time complexity O(n!)
    //space complexity O(n)
    static int nqueens(int[][] board , int row) {
        if(board.length < 4) {
            return 0;
        }
        int count =0;

        if(row == board.length) {
            for(int[] row1: board) {
                for(int num : row1) {
                    System.out.print(num+ " ");
                }
                System.out.println();
            }
            System.out.println();
            return 1;
        }
       for(int j=0; j< board.length; j++) {
                board[row][j] = 1;
                if(isSafe(board, row, j)) {
                    count = count + nqueens(board, row+1);
                }
                board[row][j] = 0;
            }

        return count;
    }

    private static boolean isSafe(int[][] board, int row, int col) {
        //checking vertical direction
            for(int i=0;i<row;i++) {
                if(board[i][col] == 1) {
                    return false;
                }
        }

        //for checking diagonal left
        int maxLeft = Math.min(row, col);
        for(int i = 1; i <= maxLeft; i++) {
            if(board[row-i][col-i] == 1) {
                return false;
            }
        }

        //for checking diagonal right
        int maxRight = Math.min(row, board.length-1-col);
        for(int i = 1; i <= maxRight; i++) {
            if(board[row-i][col+i] == 1) {
                return false;
            }
        }
        return true;
    }
}