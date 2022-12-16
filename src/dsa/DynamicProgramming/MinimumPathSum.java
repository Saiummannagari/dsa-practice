package dsa.DynamicProgramming;

/*
Minimum Path Sum

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example 1:
Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

Example 2:
Input: grid = [[1,2,3],[4,5,6]]
Output: 12
 */
class MinimumPathSum {
    public static void main(String[] args) {
        //using dp
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println("Minimum path sum :: "+minimumPathSum(grid));

        int[][] grid1 = {{1,2,3},{4,5,6}};
        System.out.println("Minimum path sum :: "+minimumPathSum(grid1));


        //using recursion
        int[][] grid2 = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println("Minimum path sum :: "+minimumPathSumByRecursion(grid2, 0, 0, 0));

        int[][] grid3 = {{1,2,3},{4,5,6}};
        System.out.println("Minimum path sum :: "+minimumPathSumByRecursion(grid3, 0, 0, 0));
    }

    private static int minimumPathSumByRecursion(int[][] grid, int i, int j, int cost) {
        if(i==grid.length-1 && j== grid[0].length-1) {
            return cost+grid[i][j];
        } else if(i==grid.length-1 && j< grid[0].length) {
            return minimumPathSumByRecursion(grid, i, j+1,cost+grid[i][j]);
        } else if(i<grid.length && j ==grid[0].length-1) {
            return minimumPathSumByRecursion(grid, i+1, j,cost+grid[i][j]);
        }
       else{
            return Math.min(minimumPathSumByRecursion(grid, i + 1, j, cost + grid[i][j]),
                    minimumPathSumByRecursion(grid, i, j + 1, cost + grid[i][j]));
        }
    }

    private static int minimumPathSum(int[][] grid) {
        int[][] cost = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(i==0 && j==0) {
                    cost[i][j] = grid[i][j];
                } else if(i==0) {
                    cost[i][j] = cost[i][j-1]+grid[i][j];
                } else if(j==0) {
                    cost[i][j] = cost[i-1][j]+grid[i][j];
                } else {
                    cost[i][j] = grid[i][j]+Math.min(cost[i-1][j], cost[i][j-1]);
                }
            }
        }
        return cost[grid.length-1][grid[0].length-1];
    }
}