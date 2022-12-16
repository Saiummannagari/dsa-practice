package dsa.DynamicProgramming;

/*
Subset Sum Problem

Given an array of non-negative integers and an integer sum. We have to tell whether there exists any subset in an array whose sum is equal to the given integer sum.

Examples:

Input: arr[] = {3, 34, 4, 12, 3, 2}, sum = 7
Output: True
Explanation: There is a subset (4, 3) with sum 7.

Input: arr[] = {2, 2, 2, 3, 2, 2}, sum = 10
Output: True
 */
class SubsetSumProblem {
    public static void main(String[] args) {
        int amount =7;
        int[] coins = {3, 34, 4, 12, 3, 2};
        System.out.println("Subset can be formed :: "+subsetSum(coins, amount));

        int amount2 =10;
        int[] coins2 = {2, 2, 2, 3, 2, 2};
        System.out.println("Subset can be formed :: "+subsetSum(coins2, amount2));
    }

    private static boolean subsetSum(int[] coins, int amount) {
        boolean[][] dp = new boolean[coins.length+1][amount+1];
        for(int i=0;i<coins.length+1;i++) {
            for(int j=0;j<amount+1;j++) {
                if(j==0) {
                    dp[i][j] = true;
                }
                else if(i==0) {
                    dp[i][j] = false;
                }
                else if(coins[i-1]>j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-coins[i-1]];
                }
            }
        }
        
        return dp[coins.length][amount];
    }
}