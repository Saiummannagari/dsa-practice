package dsa.DynamicProgramming;

/*
Number of Subsequences That Satisfy the Given Sum Condition

You are given an array of integers nums and an integer target.

Return the number of non-empty subsequences of nums such that the sum of the minimum and maximum element on it is less or equal to target. Since the answer may be too large, return it modulo 109 + 7.

Example 1:

Input: nums = [3,5,6,7], target = 9
Output: 4
Explanation: There are 4 subsequences that satisfy the condition.
[3] -> Min value + max value <= target (3 + 3 <= 9)
[3,5] -> (3 + 5 <= 9)
[3,5,6] -> (3 + 6 <= 9)
[3,6] -> (3 + 6 <= 9)
Example 2:

Input: nums = [3,3,6,8], target = 10
Output: 6
Explanation: There are 6 subsequences that satisfy the condition. (nums can have repeated numbers).
[3] , [3] , [3,3], [3,6] , [3,6] , [3,3,6]
Example 3:

Input: nums = [2,3,3,4,6,7], target = 12
Output: 61
Explanation: There are 63 non-empty subsequences, two of them do not satisfy the condition ([6,7], [7]).
Number of valid subsequences (63 - 2 = 61).
 */
class NumberOfSubsets {
    public static void main(String[] args) {
        int[] nums = {3,5,6,7};
        int target = 9;
        System.out.println("Number of subsets :: "+ numberOfSubsets(nums, target));

        int[] nums2 = {3,3,6,8};
        int target2 = 10;
        System.out.println("Number of subsets :: "+ numberOfSubsets(nums2, target2));

        int[] nums3 = {2,3,3,4,6,7};
        int target3 = 12;
        System.out.println("Number of subsets :: "+ numberOfSubsets(nums3, target3));
    }

    private static int numberOfSubsets(int[] nums, int target) {
        int[][] dp = new int[nums.length+1][target+1];
        for(int i=0;i<nums.length+1;i++) {
            for(int j=0;j<target+1;j++) {
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
//        int sum=0;
//        for(int j=1;j<target+1;j++)
//        {
//            System.out.print(dp[nums.length][j]+" ");
//            sum= sum+dp[nums.length][j];
//        }
//        return sum;
        return dp[nums.length][target];
    }
}