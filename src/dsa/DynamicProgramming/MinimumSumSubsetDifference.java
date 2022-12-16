package dsa.DynamicProgramming;/*
Partition Array Into Two Arrays to Minimize Sum Difference

You are given an integer array nums of 2 * n integers. You need to partition nums into two arrays of length n to minimize the absolute difference of the sums of the arrays. To partition nums, put each element of nums into one of the two arrays.

Return the minimum possible absolute difference.

Example 1:
Input: nums = [3,9,7,3]
Output: 2
Explanation: One optimal partition is: [3,9] and [7,3].
The absolute difference between the sums of the arrays is abs((3 + 9) - (7 + 3)) = 2.
 */

class MinimumSumSubset {
    public static void main(String[] args) {
        //works only for positive integers
       int nums[] = {3,9,7,3};
        System.out.println("Number of minimum sum subset difference :: "+ minSumDiff(nums));

//        int nums2[] = {-36,36};
//        System.out.println("Number of minimum sum subset difference :: "+ minSumDiff(nums2));
//
//        int nums3[] = {2,-1,0,4,-2,-9};
//        System.out.println("Number of minimum sum subset difference :: "+ minSumDiff(nums3));
    }

    private static int minSumDiff(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++) {
            sum = sum+nums[i];
        }
//        int sum1= (sum/2);
//        System.out.println(sum1);
        boolean[][] dp = new boolean[nums.length+1][sum+1];
        for(int i=0;i<nums.length+1;i++) {
            for(int j=0;j<sum+1;j++) {
                if(j==0) {
                    dp[i][j]=true;
                } else if(i == 0) {
                    dp[i][j]=false;
                } else if(j<nums[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j-nums[i - 1]];
                }
            }
        }
        int diff = Integer.MAX_VALUE;
        for(int i=0;i<=sum/2;++i) {
            int first = i;
            int second = sum-i;
            if(dp[nums.length][i] == true && diff>Math.abs(first-second)) {
                diff = Math.abs(first-second);
            }
          }
    return diff;
    }
}