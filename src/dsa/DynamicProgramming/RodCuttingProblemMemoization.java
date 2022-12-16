package dsa.DynamicProgramming;

/*
Rod Cutting is another term for Unbounded Knapsack

Cut the rod with highest profit
 */
class RodCutting {
    public static void main(String[] args) {
        int price[] = { 1,5, 8,9};
        int length[] = {2, 2, 3, 4};
        int l = 6;
        int[][] dp = new int[length.length+1][l+1];
        for(int i=0;i<length.length+1;i++) {
            for(int j=0;j<l+1;j++) {
                dp[i][j] = -1;
            }
        }
        int res = unboundedKnapsack(price, length, l, 4, dp);
        System.out.println("Highest profit :: "+res);
    }

    static int unboundedKnapsack(int[] price, int[] length, int maxlen, int n, int[][] dp) {
        if(n==0 || maxlen == 0) {
            return 0;
        }
        if(dp[length[n-1]][maxlen]==-1) {
            if (length[n - 1] > maxlen) {
                return dp[length[n - 1]][maxlen] = unboundedKnapsack(price, length, maxlen, n - 1, dp);
            } else {
                return dp[length[n - 1]][maxlen] = Math.max(price[n - 1] + unboundedKnapsack(price, length, maxlen - length[n - 1], n, dp),
                        unboundedKnapsack(price, length, maxlen, n - 1, dp));

            }
        }
        else {
            return dp[length[n-1]][maxlen];
        }
    }
}