package dsa.DynamicProgramming;/*
Target Sum

You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1"

Return the number of different expressions that you can build, which evaluates to target.

Example 1:

Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
Example 2:

Input: nums = [1], target = 1
Output: 1
 */

class TargetSum {

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target = 3;
        System.out.println("number of pairs :: "+ numberOfPairs(nums, target));

        int[] nums2 = {1};
        int target2 = 1;
        System.out.println("number of pairs :: "+ numberOfPairs(nums2, target2));
    }

    private static int numberOfPairs(int[] nums, int target) {
        int sum =0;
        for(int i=0;i<nums.length;i++) {
            sum = sum+nums[i];
        }
        int s1 = (sum+target)/2;
        int[][] dp = new int[nums.length+1][s1+1];
        for(int i=0;i<nums.length+1;i++) {
            for(int j=0;j<s1+1;j++) {
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
        return dp[nums.length][s1];
    }
}