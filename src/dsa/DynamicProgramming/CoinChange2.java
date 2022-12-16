package dsa.DynamicProgramming;

/*
Coin Change II

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

You may assume that you have an infinite number of each kind of coin.

The answer is guaranteed to fit into a signed 32-bit integer.

Example 1:

Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1

Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
 */
class CoinChange {
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = new int[] {1,2,5};
        System.out.println("coin change :: "+ change(amount, coins));

        int amount2 = 3;
        int[] coins2 = new int[] {2};
        System.out.println("coin change :: "+ change(amount2, coins2));

        int amount3 = 10;
        int[] coins3 = new int[] {10};
        System.out.println("coin change :: "+ change(amount3, coins3));
    }

    static int change(int amount, int[] coins) {
      int[][] dp = new int[coins.length+1][amount+1];
      for(int i=0;i< coins.length+1;i++) {
          for(int j=0;j<amount+1;j++) {
              if(i==0){
                  dp[i][j] = 0;
              }
              else if(j==0) {
                  //we can either include or exclude the coin. So there is always a 1 way to find sum=0
                  dp[i][j] = 1;
              }
              //checking if coin amount is grater than the current amount
              else if(coins[i-1]>j) {
                  dp[i][j] = dp[i-1][j];
              }
              else {
                  dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
              }
          }
      }
      return dp[coins.length][amount];
    }
}