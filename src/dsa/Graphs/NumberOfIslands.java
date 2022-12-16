package dsa.Graphs;

/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIslands {
    //n --> no of rows, k --> no of columns
    static void findIslands(int row, int col, int n ,int k, char[][] grid) {
        if(!isValid(row, col, n, k)) {
            return;
        }
        if(isValid(row, col, n, k)) {
            if(grid[row][col] != '1') {
                return;
            }
        }

        grid[row][col] = '2';
        findIslands(row+1,col, n, k, grid);
        findIslands(row-1,col, n, k, grid);
        findIslands(row,col+1, n, k, grid);
        findIslands(row,col-1, n, k, grid);

    }

    static boolean isValid(int row, int col, int n ,int k) {
        if(row>=0 && row<n && col>=0 && col<k) {
            return true;
        }
        return false;
    }

    static int numIslands(char[][] grid) {
        int n = grid.length;
        int k = grid[0].length;
        int num = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<k;j++) {
                if(grid[i][j] == '1') {
                     findIslands(i, j, n, k, grid);
                     num = num + 1;
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        char[][] grid = {
        {'1','1','1','1','0'},
        {'1','1','0','1','0'},
        {'1','1','0','0','0'},
        {'0','0','0','0','0'}
    };
        System.out.println(numIslands(grid));


        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(grid2));
    }

}