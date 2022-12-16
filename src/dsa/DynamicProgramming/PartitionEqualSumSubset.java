package dsa.DynamicProgramming;

/*
Partition Equal Subset Sum

Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
 */
class PartitionEqualSumSubset {
    public static void main(String[] args) {
       int[] nums = {1,5,11,5};
       System.out.println(partitionArray(nums));

       int[] nums2 = {1,2,3,5};
        System.out.println(partitionArray(nums2));
    }

    private static boolean partitionArray(int[] nums) {
        int sum =0;
        for(int i=0;i<nums.length;i++) {
            sum = sum+nums[i];
        }
        if(sum%2!=0) {
            return false;
        }
        boolean[][] dp = new boolean[nums.length+1][(sum/2)+1];
        for(int i=0;i<nums.length+1;i++) {
            for(int j=0;j<(sum/2)+1;j++) {
                if(j==0) {
                    dp[i][j]=true;
                }
                else if(i==0) {
                    dp[i][j] = false;
                } else if(nums[i-1]>j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[nums.length][sum/2];
    }
}