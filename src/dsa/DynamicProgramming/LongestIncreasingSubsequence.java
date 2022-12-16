package dsa.DynamicProgramming;/*
Longest Increasing Subsequence

Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7]

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1
 */

import java.util.Arrays;

class IncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums={10,9,2,5,3,7,101,18};
        System.out.println("Longest increasing subsequence :: "+longestIncreasingSubsequence(nums));

        int[] nums2={0,1,0,3,2,3};
        System.out.println("Longest increasing subsequence :: "+longestIncreasingSubsequence(nums2));

        int[] nums3={7,7,7,7,7,7,7};
        System.out.println("Longest increasing subsequence :: "+longestIncreasingSubsequence(nums3));

    }

    static int longestIncreasingSubsequence(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        for(int i=0;i<nums.length-1;i++) {
            for(int j=i+1;j< nums.length;j++) {
                if(nums[i]<nums[j] && dp[j]<=dp[i]+1) {
                    dp[j] = dp[i]+1;
                }
            }
        }
        int max=0;
        for(int i=0;i<nums.length;i++) {
           max = Math.max(max, dp[i]);
        }

        int maxIndex=max;
        for(int j=nums.length-1;j>=0;j--) {
            if(dp[j]==maxIndex) {
                System.out.print(nums[j]+" ");
                --maxIndex;
                continue;
            }
        }
        System.out.println();
        return max;
    }
}