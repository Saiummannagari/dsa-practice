package dsa.Hashing;/*
Check if there exist two elements in an array whose sum is equal to the sum of rest of the array

We have an array of integers and we have to find two such elements in the array such that sum of these two elements is equal to the sum of rest of elements in array.

Examples:

Input  : arr[] = {2, 11, 5, 1, 4, 7}
Output : Elements are 4 and 11
Note that 4 + 11 = 2 + 5 + 1 + 7

Input  : arr[] = {2, 4, 2, 1, 11, 15}
Output : Elements do not exist
 */

import java.util.Arrays;
import java.util.HashSet;

class SumEqualsSum2 {

    static boolean checkPair(int[] arr, int n) {
        int sum= Arrays.stream(arr).sum();
        if(sum%2!=0) {
            return false;
        }
        sum= sum/2;

        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++) {
            int diff = sum-arr[i];
            if(set.contains(diff)) {
                System.out.printf("Pair elements are %d and %d\n",
                        arr[i], diff);
                return true;
            }
            set.add(arr[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = {2, 11, 5, 1, 4, 7};
        int n = arr.length;
        if (checkPair(arr, n) == false)
        {
            System.out.printf("No pair found");
        }
    }
}