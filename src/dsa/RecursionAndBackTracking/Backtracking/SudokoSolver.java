package dsa.RecursionAndBackTracking.Backtracking;

public class SudokoSolver {

    public static void main(String[] args) {
        int [][] grid = { {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0} };
        if(sudokoSolve(grid)) {
            for(int [] row : grid) {
                for(int num : row) {
                    System.out.print(num+ " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("cannot find answer");
        }


        int [][] grid2 = { {3, 1, 6, 5, 2, 8, 4, 2, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0} };
        if(sudokoSolve(grid2)) {
            for(int [] row : grid2) {
                for(int num : row) {
                    System.out.print(num+ " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("cannot find answer");
        }
    }

    // time complexity O(9 power n2)
    static boolean sudokoSolve(int[][] board) {
        boolean isEmpty = false;
        int row=-1;
        int col = -1;
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board.length;j++) {
                if(board[i][j] == 0) {
                    isEmpty = true;
                    row = i;
                    col = j;
                    break;
                }
            }
            if(isEmpty) {
                break;
            }
        }
        if(!isEmpty) {
            return true;
        }

        for(int number=1;number<=9;number++) {
            if(isSafe(board, row, col, number)) {
                board[row][col] = number;
                if(sudokoSolve(board))  {
                     return true;
                }
                    board[row][col] = 0;
            }

        }
      return false;
    }

    static boolean isSafe(int[][] board, int row, int col, int num) {
        //checking for rows
        for(int i=0;i<board.length;i++) {
            if(board[row][i] == num){
                return false;
            }
        }

        //checking for columns
        for(int i=0;i< board.length;i++) {
            if(board[i][col] == num) {
                return false;
            }
        }

        int sqrt = (int)(Math.sqrt(board.length));
        int startRow = row - row%sqrt;
        int startCol = col - col%sqrt;

        for(int i=startRow;i<startRow+sqrt;i++) {
            for(int j=startCol;j<startCol+sqrt;j++) {
                if(board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }


}