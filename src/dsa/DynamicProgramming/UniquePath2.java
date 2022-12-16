package dsa.DynamicProgramming;

/*
Unique Paths II

You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m-1][n-1]). The robot can only move either down or right at any point in time.

An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.

Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

Example 1:
Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right

Example 2:
Input: obstacleGrid = [[0,1],[0,0]]
Output: 1
 */
class UniquePath {

    public static void main(String[] args) {
        int grid[][] = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println("Number of unique paths :: "+ uniquePaths(grid));

        int grid1[][] = {{0,1},{0,0}};
        System.out.println("Number of unique paths :: "+ uniquePaths(grid1));

        int grid2[][] = {{0,0,0},{0,0,0},{0,0,0}};
        System.out.println("Number of unique paths :: "+ uniquePaths(grid2));

        int grid3[][] = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println("Number of unique paths :: "+ recursiveUniquePaths(grid3, 0, 0, 0));

        int grid4[][] = {{0,1},{0,0}};
        System.out.println("Number of unique paths :: "+ recursiveUniquePaths(grid4, 0, 0,0));

        int grid5[][] = {{0,0,0},{0,0,0},{0,0,0}};
        System.out.println("Number of unique paths :: "+ recursiveUniquePaths(grid5,0, 0, 0));

    }

    private static int uniquePaths(int[][] grid) {
         int[][] dp = new int[grid.length][grid[0].length];
         boolean flag = false;
         for(int i=0;i<grid.length;i++) {
             if(grid[i][0] == 1 || flag) {
                 flag = true;
                 dp[i][0] = 0;
             } else {
                 dp[i][0] = 1;
             }
         }
        flag = false;
        for(int j=0;j<grid[0].length;j++) {
            if(grid[0][j] == 1 || flag) {
                flag = true;
                dp[0][j] = 0;
            } else {
                dp[0][j] = 1;
            }
        }

         for(int i=1;i<grid.length;i++) {
             for(int j=1;j< grid[0].length;j++) {
                     if(grid[i][j]!=1) {
                     dp[i][j] = dp[i][j-1] + dp[i-1][j];
                 } else {
                     dp[i][j] = 0;
                     }
             }
         }
         return dp[grid.length-1][grid[0].length-1];
    }

    private static int recursiveUniquePaths(int[][] grid, int i, int j, int count) {
        if ((i == grid.length - 1 || j == grid[0].length - 1) && grid[i][j] != 1) {
            return 1 + count;
        } else if (grid[i][j] == 1) {
            return 0;
        } else {
            return recursiveUniquePaths(grid, i + 1, j, count) +
                    recursiveUniquePaths(grid, i, j + 1, count);
        }
    }
}