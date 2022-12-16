package dsa.RecursionAndBackTracking.Backtracking;

public class NKnights {

    public static void main(String[] args) {
       boolean[][] board = {{false,false,false,false},
               {false,false,false,false},
               {false,false,false,false},
               {false,false,false,false}};
       knights(board, 0, 0, 4);
    }

    static void knights(boolean[][] board, int row, int col, int knights) {
        if(knights == 0) {
            display(board);
            System.out.println();
            return;
        }
       if(col == board[0].length) {
           knights(board, row+1, col, knights);
       }

       if(isSafe(board, row,col)) {
           board[row][col] = true;
           knights(board, row, col+1, knights-1);
           board[row][col] = false;
       }
       knights(board, row, col+1, knights);
    }

    private static void display(boolean[][] board) {
        for(boolean[] row : board) {
            for(boolean elem : row) {
                if(elem) {
                    System.out.print('K');
                }
                else {
                    System.out.print('X');
                }
            }
            System.out.println();
        }
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        if(isValid(board, row-1, col-2)) {
          if(board[row-1][col-2] == true) {
              return false;
          }
       }

        if(isValid(board, row-1, col+2)) {
            if(board[row-1][col+2] == true) {
                return false;
            }
        }

        if(isValid(board, row-2, col-1)) {
            if(board[row-2][col-1] == true) {
                return false;
            }
        }

        if(isValid(board, row-2, col +1)) {
            if(board[row-2][col +1] == true) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValid(boolean[][] board, int row, int col) {
        if(row>=0 && row< board.length && col >=0 && col <board[0].length) {
            return true;
        }
        return false;
    }
}