package dsa.DynamicProgramming;

import java.util.Arrays;

/*
Time complexity :: O(N*W).
 */
class Knapsack {

    public static void main(String[] args) {
        int val[] = { 60, 100, 120 };
        int wt[] = { 10, 20, 30 };
        int W = 40;
        int n = val.length;
        int[][] dp = new int[n][W+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<W+1;j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(knapsack(dp, W, wt, val, n));
    }

    private static int knapsack(int[][] dp, int w, int[] wt, int[] val, int n) {
        if(w==0 || n==0) {
            return 0;
        } if(dp[n-1][w] ==-1) {
            if (wt[n - 1] > w) {
                return dp[n - 1][w] = knapsack(dp, w, wt, val, n - 1);
            } else {
                return dp[n - 1][w] = Math.max(val[n - 1] + knapsack(dp, w - wt[n - 1], wt, val, n - 1), knapsack(dp, w, wt, val, n - 1));
            }
        } else {
            return dp[n-1][w];
        }
    }
}