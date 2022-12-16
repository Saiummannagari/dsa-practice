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
        int res = unboundedKnapsack(price, length, l);
        System.out.println("Highest profit :: "+res);

        int price2[] = { 1,5, 8,9};
        int length2[] = {2, 2, 3, 4};
        int l2 = 4;
        int res2 = unboundedKnapsack(price2, length2, l2);
        System.out.println("Highest profit :: "+res2);
    }

    static int unboundedKnapsack(int[] price, int[] length, int maxlen) {
        int[][] dp = new int[length.length + 1][maxlen + 1];

        for (int i = 0; i < length.length + 1; i++) {
            for (int j = 0; j < maxlen + 1; j++) {
                if (j == 0 || i == 0) {
                    dp[i][j] = 0;
                }
                else if (j < length[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(price[i - 1] + dp[i][j - length[i - 1]], dp[i - 1][j]);
                }
            }
        }
      return dp[length.length][maxlen];
    }
}