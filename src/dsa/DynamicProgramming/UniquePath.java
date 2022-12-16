package dsa.DynamicProgramming;

/*
Unique Paths

There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

Example 1:
Input: m = 3, n = 7
Output: 28

Example 2:
Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
 */
class UniquePath {
    public static void main(String[] args) {
        //using dp
        int m=3;
        int n=7;
        System.out.println("Number of unique paths :: "+ uniquePaths(m, n));

        int m1=3;
        int n1=2;
        System.out.println("Number of unique paths :: "+ uniquePaths(m1, n1));

        //using recursive call
        int m2=3;
        int n2=7;
        System.out.println("Number of unique paths :: "+ recursiveUniquePaths(0, 0, m2, n2, 0));

        int m3=3;
        int n3=2;
        System.out.println("Number of unique paths :: "+ recursiveUniquePaths(0, 0, m3, n3, 0));
    }

    private static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(i==0 || j==0) {
                    dp[i][j] = 1;
                }
                else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    private static int recursiveUniquePaths(int i, int j, int m , int n, int count) {
        if(i==m-1 || j==n-1) {
            return count+1;
        }
        else {
            return recursiveUniquePaths(i+1, j, m, n, count) + recursiveUniquePaths(i, j+1, m, n, count);
        }
    }
}