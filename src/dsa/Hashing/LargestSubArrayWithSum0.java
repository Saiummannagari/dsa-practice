package dsa.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
Largest subarray with 0 sum

Given an array having both positive and negative integers. The task is to compute the length of the largest subarray with sum 0.

Example 1:

Input:
N = 8
A[] = {15,-2,2,-8,1,7,10,23}
Output: 5
Explanation: The largest subarray with
sum 0 will be -2 2 -8 1 7.
 */
public class LargestSubArrayWithSum0 {

   static int[] largestSubArray(int arr[]) {
       HashMap<Integer, Integer> map = new HashMap<>();
       int sum=0;
       int first = -1;
       int last = -1;
       int maxLength = Integer.MIN_VALUE;
       for(int i=0;i<arr.length;i++) {
           sum = sum+arr[i];
           if(sum == 0) {
               if(maxLength < i) {
                   first = 0;
                   last = i;
                   maxLength = i;
               }
           } else {
               if (map.containsKey(sum)) {
                   int index = map.get(sum);
                   if (maxLength < i - index) {
                       first = index;
                       last = i;
                       maxLength = i - index;
                   }
               } else {
                   map.put(sum, i);
               }
           }
       }
       return Arrays.copyOfRange(arr, first+1, last+1);
   }

    public static void main(String[] args) {
        int[] arr = {15,-2,2,-8,1,7,10,23};
        System.out.println(" largest sub array :: "+ Arrays.toString(largestSubArray(arr)));
        int arr1[] = {1, 2, 3};
        System.out.println(" largest sub array :: "+ Arrays.toString(largestSubArray(arr1)));
        int arr2[] = {1, 0, 3};
        System.out.println(" largest sub array :: "+ Arrays.toString(largestSubArray(arr2)));

    }
}