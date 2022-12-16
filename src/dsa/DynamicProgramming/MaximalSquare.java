package dsa.DynamicProgramming;

/*
Maximal Square

Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example1 :
Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 4

Example2:
Input: matrix = [["0","1"],["1","0"]]
Output: 1
Example 3:

Input: matrix = [["0"]]
Output: 0
 */
class MaximalSquare {
    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},
                           {'1','0','1','1','1'},
                           {'1','1','1','1','1'},
                           {'1','0','0','1','0'}};
        System.out.println("Maximal square size :: "+ sizeOfMaximalSquare(matrix));
        System.out.println("Maximal square area :: "+ maximalSquareArea(matrix));

        char[][] matrix2 = {{'0','1'},{'1','0'}};
        System.out.println("Maximal square size :: "+ sizeOfMaximalSquare(matrix2));
        System.out.println("Maximal square area :: "+ maximalSquareArea(matrix2));

        char[][] matrix3 = {{'0'}};
        System.out.println("Maximal square size :: "+ sizeOfMaximalSquare(matrix3));
        System.out.println("Maximal square area :: "+ maximalSquareArea(matrix3));
    }

    private static int sizeOfMaximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<matrix.length+1;i++) {
            for(int j=0;j<matrix[0].length+1;j++) {
                if(i==0 || j==0) {
                    dp[i][j] = 0;
                } else {
                    min = Math.min(dp[i][j-1], dp[i-1][j]);
                    min = Math.min(min, dp[i-1][j-1]);
                    if(matrix[i-1][j-1] == '1') {
                        dp[i][j] = min+1;
                    }
                    max = Math.max(dp[i][j], max);
//                    else {
//                        dp[i][j] = min;
//                    }
                }
            }
        }

        for(int i=0;i<matrix.length+1;i++) {
            for(int j=0;j<matrix[0].length+1;j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        return max*max;
    }


    private static int maximalSquareArea(char[][] matrix) {
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        int min = -1;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<matrix.length+1;i++) {
            for(int j=0;j<matrix[0].length+1;j++) {
                if(i==0 || j==0) {
                    dp[i][j] = 0;
                } else {
                    min = Math.min(dp[i][j-1], dp[i-1][j]);
                    min = Math.min(min, dp[i-1][j-1]);
                    if(matrix[i-1][j-1] == '1') {
                        dp[i][j] = min+1;
                    }
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max*max;
    }
}