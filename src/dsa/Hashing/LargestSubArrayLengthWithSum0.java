package dsa.Hashing;/*
Find the length of largest subarray with 0 sum

Given an array arr[] of length N, find the length of the longest sub-array with a sum equal to 0.

Examples:

Input: arr[] = {15, -2, 2, -8, 1, 7, 10, 23}
Output: 5
Explanation: The longest sub-array with elements summing up-to 0 is {-2, 2, -8, 1, 7}

Input: arr[] = {1, 2, 3}
Output: 0
Explanation: There is no subarray with 0 sum

Input:  arr[] = {1, 0, 3}
Output:  1
Explanation: The longest sub-array with elements summing up-to 0 is {0}
 */

import java.util.HashMap;

public class LargestSubArrayLengthWithSum0 {


    static int maxLength(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        int sum =0;
        for(int i=0;i< arr.length;i++) {
            sum = sum+arr[i];
            if(sum == 0) {
               maxLength = Math.max(maxLength,i+1);
            }
            else {
                if (map.containsKey(sum)) {
                    int prevLength = map.get(sum);
                    //do not store the length in to map, as we need to track the first index also
                    maxLength = Math.max(maxLength, i - prevLength + 1);
                } else {
                    map.put(sum, i + 1);
                }
            }
            }
        return maxLength;
        }


    public static void main(String[] args) {
        int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println("largest subarray length with sum 0 :: " + maxLength(arr));
        int arr1[] = {0, 0, 0, 0};
        System.out.println("largest subarray length with sum 0 :: " + maxLength(arr1));
        int arr2[] = {15, 12, 8, -15, -8, -12};
        System.out.println("largest subarray length with sum 0 :: " + maxLength(arr2));
        int arr3[] = {1, 2, 3};
        System.out.println("largest subarray length with sum 0 :: " + maxLength(arr3));
        int arr4[] = {1, 0, 3};
        System.out.println("largest subarray length with sum 0 :: " + maxLength(arr4));
    }
}