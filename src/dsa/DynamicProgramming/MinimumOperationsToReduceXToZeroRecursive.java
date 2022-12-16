package dsa.DynamicProgramming;

/*
Minimum Operations to Reduce X to Zero

You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x. Note that this modifies the array for future operations.

Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise, return -1.

Example 1:

Input: nums = [1,1,4,2,3], x = 5
Output: 2
Explanation: The optimal solution is to remove the last two elements to reduce x to zero.
Example 2:

Input: nums = [5,6,7,8,9], x = 4
Output: -1
Example 3:

Input: nums = [3,2,20,1,1,3], x = 10
Output: 5
Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in total) to reduce x to zero.
 */
class MinimumNumber {
    public static void main(String[] args) {
        int[] nums = {1,1,4,2,3};
        int x= 5;
        int res = minNumberOfOperations(nums, x, 0, nums.length-1, 0);
        int count = res==Integer.MAX_VALUE?-1:res;
        System.out.println("Minimum number of operations :: "+ count);

        int[] nums2 = {5,6,7,8,9};
        int x2= 4;
        int res2 = minNumberOfOperations(nums2, x2, 0, nums2.length-1, 0);
        int count2 = res2==Integer.MAX_VALUE?-1:res2;
        System.out.println("Minimum number of operations :: "+ count2);

        int[] nums3 = {3,2,20,1,1,3};
        int x3= 10;
        int res3 = minNumberOfOperations(nums3, x3, 0, nums3.length-1, 0);
        int count3 = res3==Integer.MAX_VALUE?-1:res3;
        System.out.println("Minimum number of operations :: "+ count3);

    }

    //we have to folllow this approach of left and right pointer if we want to consider either of them
    static int minNumberOfOperations(int[] nums, int x,int left, int right, int count) {
       if(x==0) {
           return count;
       }
       if(left>=right || x<0) {
           //we are checking for a minimum value, so for comparision return maximum value
           return Integer.MAX_VALUE;
       }
       int leftRes = minNumberOfOperations(nums, x-nums[left], left+1, right, count+1);
       int rightRes = minNumberOfOperations(nums, x-nums[right], left, right-1, count+1);
       return Math.min(leftRes, rightRes);
    }
}