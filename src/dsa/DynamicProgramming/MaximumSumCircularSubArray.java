package dsa.DynamicProgramming;

import java.util.Arrays;

/*
Maximum Sum Circular Subarray

Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.

A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].

A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.

Example 1:

Input: nums = [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3.
Example 2:

Input: nums = [5,-3,5]
Output: 10
Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.
Example 3:

Input: nums = [-3,-2,-3]
Output: -2
Explanation: Subarray [-2] has maximum sum -2.
 */
class MaximumSubArray {
    public static void main(String[] args) {
        int[] nums = {1,-2,3,-2};
        System.out.println("Maximum sum circular sub array :: "+maximumCircularSumSubArray(nums));

        int[] nums1 = {5,-3,5};
        System.out.println("Maximum sum circular sub array :: "+maximumCircularSumSubArray(nums1));

        int[] nums2 = {-3,-2,-3};
        System.out.println("Maximum sum circular sub array :: "+maximumCircularSumSubArray(nums2));
    }

    private static int maximumCircularSumSubArray(int[] nums) {

        //checking for negative values
//        boolean flag = false;
//        int min = Integer.MIN_VALUE;
//        for(int i=0;i<nums.length;i++) {
//            if(nums[i]<0) {
//                min = Math.max(min, nums[i]);
//            } else {
//                flag=true;
//            }
//        }
//        if(!flag) {
//            return min;
//        }

        int max_straight_sum = Integer.MIN_VALUE;
        int min_straight_sum = Integer.MAX_VALUE;
        int arr_sum = 0;
        int temp_maxSum = 0;
        int temp_minSum = 0;

        for(int i=0;i<nums.length;i++) {
            arr_sum = arr_sum+nums[i];

            temp_maxSum = temp_maxSum+nums[i];
            max_straight_sum = max_straight_sum < temp_maxSum ? temp_maxSum : max_straight_sum;
            temp_maxSum = temp_maxSum<0?0:temp_maxSum;

            temp_minSum = temp_minSum+nums[i];
            min_straight_sum = min_straight_sum>temp_minSum?temp_minSum:min_straight_sum;
            temp_minSum = temp_minSum>0?0:temp_minSum;
        }

        // for all negative values
        if(arr_sum == min_straight_sum) {
            return max_straight_sum;
        }
        return Math.max(max_straight_sum, (arr_sum-min_straight_sum));
      }
}