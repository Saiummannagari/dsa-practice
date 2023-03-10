package dsa.DynamicProgramming;/*
Coin Change

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
 */


/*
check if you can do with a single array
 */
class CoinChange{
    public static void main(String[] args) {
        int amount =11;
        int[] coins = {1,2,5};
        System.out.println("Min Number of coins required :: "+coinChange(coins, amount));

        int amount2 =3;
        int[] coins2 = {2};
        System.out.println("Min Number of coins required :: "+coinChange(coins2, amount2));

        int amount3 = 0;
        int[] coins3 = {1};
        System.out.println("Min Number of coins required :: "+coinChange(coins3, amount3));
    }

    static int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i=0;i<coins.length+1;i++) {
            for(int j=0;j<amount+1;j++) {
                if(i==0) {
                    dp[i][j] = Integer.MAX_VALUE;
                } else if(j==0) {
                    dp[i][j] = 0;
                } else if(coins[i-1]>j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                        dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }
        if(dp[coins.length][amount] == Integer.MAX_VALUE || dp[coins.length][amount] < 0) {
            return -1;
        }
        return dp[coins.length][amount];
    }
}