package dsa.DynamicProgramming;

/*

 */
class SubsetsWithDifference {
    public static void main(String[] args) {
      int[] nums = {2,3,7,6};
      int diff = 1;
      System.out.println("number of pairs :: "+numberOfSubsets(nums,diff));
    }

    static int numberOfSubsets(int[] nums, int diff) {
        int sum =0;
        for(int i=0;i<nums.length;i++) {
            sum = sum + nums[i];
        }
        int sum1 = (sum+diff)/2;
        int[][] dp = new int[nums.length+1][sum1+1];
        for(int i=0;i<nums.length+1;i++) {
            for(int j=0;j<sum1+1;j++) {
                if(j==0) {
                    dp[i][j]=1;
                } else if(i==0) {
                    dp[i][j]=0;
                } else if(nums[i-1]>j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j]+dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[nums.length][sum1];
    }
}