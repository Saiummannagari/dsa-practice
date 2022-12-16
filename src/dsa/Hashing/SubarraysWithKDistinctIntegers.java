package dsa.Hashing;/*
Count of subarrays having exactly K distinct elements

Given an array arr[] of size N and an integer K. The task is to find the count of subarrays such that each subarray has exactly K distinct elements.

Input: arr[] = {2, 1, 2, 1, 6}, K = 2
Output: 7
{2, 1}, {1, 2}, {2, 1}, {1, 6}, {2, 1, 2},
{1, 2, 1} and {2, 1, 2, 1} are the only valid subarrays.

Input: arr[] = {1, 2, 3, 4, 5}, K = 1
Output: 5
 */

public class SubarraysWithKDistinctIntegers {

    private static boolean subarraysWithKDistinct(int[] arr, int k) {


    }

    public static void main(String[] args) {
        int arr[] = { 2, 1, 2, 1, 6 };
        int k = 2;
        System.out.println(subarraysWithKDistinct(arr, k));
    }
}