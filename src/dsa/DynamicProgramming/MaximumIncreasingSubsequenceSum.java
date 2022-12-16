package dsa.DynamicProgramming;/*
maximum Increasing Subsequence sum

Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7]

Example 1:

Input: nums = [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11]
Output: 34
Explanation: The maximum increasing subsequence sum is [8, 12, 14], therefore the length is 34.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 6
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 7
 */

import java.util.Arrays;

class IncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums={10,9,2,5,3,7,101,18};
        System.out.println("Longest increasing subsequence :: "+longestIncreasingSubsequence(nums));

        int[] nums1={0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11};
        System.out.println("Longest increasing subsequence :: "+longestIncreasingSubsequence(nums1));

        int[] nums2={0,1,0,3,2,3};
        System.out.println("Longest increasing subsequence :: "+longestIncreasingSubsequence(nums2));

        int[] nums3={7,7,7,7,7,7,7};
        System.out.println("Longest increasing subsequence :: "+longestIncreasingSubsequence(nums3));

    }

    static int longestIncreasingSubsequence(int[] nums) {
        int len=nums.length;
        int dp[] = new int[nums.length];
        for(int i=0;i< dp.length;i++) {
            dp[i] = nums[i];
        }

        for(int i=0;i<nums.length-1;i++) {
            for(int j=i+1;j< nums.length;j++) {
                if(nums[j]>nums[i] && dp[j]<dp[i]+nums[j]) {
                    dp[j]=dp[i]+nums[j];
                }
            }
        }
        int max=0;
        for(int i=0;i<nums.length;i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}