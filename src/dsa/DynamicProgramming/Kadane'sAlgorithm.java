package dsa.DynamicProgramming;

/*
Maximum Subarray

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

A subarray is a contiguous part of an array.

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Example 2:

Input: nums = [1]
Output: 1
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
 */
class Algorithm {
    public static void main(String[] args) {
      int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
      System.out.println("Maximum subarray :: "+ maxSubArray(nums));

      int[] nums2 = {1};
      System.out.println("Maximum subarray :: "+ maxSubArray(nums2));

      int[] nums3 = {5,4,-1,7,8};
      System.out.println("Maximum subarray :: "+ maxSubArray(nums3));

      int[] nums4 = {-3,-2,-3};
      System.out.println("Maximum subarray :: "+ maxSubArray(nums4));
    }

    private static int maxSubArray(int[] nums) {
        int sum = 0;
        int result = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++) {
            //sum is temporary sum[adding previous elements with the current element]
            sum = sum+nums[i];
            //if current element is greater than the sum of previous elements and current element, assign temporary sum as the current element value
            if(sum<nums[i]) {
                sum = nums[i];
            }
            if(result < sum) {
                result = sum;
            }
        }
        return result;
    }
}