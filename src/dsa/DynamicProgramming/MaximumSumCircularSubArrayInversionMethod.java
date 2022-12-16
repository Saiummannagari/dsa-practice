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

    static int kadaneSum(int[] nums) {
        int max_sum = 0;
        int max_sum_result = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++) {
            max_sum = max_sum + nums[i];
            if (nums[i] > max_sum) {
                max_sum = nums[i];
            }
            if (max_sum > max_sum_result) {
                max_sum_result = max_sum;
            }
        }
        return max_sum_result;
    }
    //using inverted method
    private static int maximumCircularSumSubArray(int[] nums) {

        //checking for negative values
        boolean flag = false;
        int min = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]<0) {
                min = Math.max(min, nums[i]);
            } else {
                flag=true;
            }
        }
        if(!flag) {
            return min;
        }


        int kadane_sum = kadaneSum(nums);
        //inverting the sign of array elements
        int[] copy = Arrays.stream(nums).map(num -> -num).toArray();

        //used for tracking the total sum of the elements
        int total_sum = 0;
        //maximum sum subarray (Using kadane's algorithm)
        int max_sum = 0;
        int max_sum_result = Integer.MIN_VALUE;
        for(int i=0;i<copy.length;i++) {
            total_sum = total_sum + copy[i];
        }
        int negative_kadane_sum = kadaneSum(copy);
//        System.out.println("total sum :: "+total_sum);
//        System.out.println("negative sum :: "+ max_sum_result);
        return Math.max(kadane_sum, -total_sum-(-negative_kadane_sum));
    }
}