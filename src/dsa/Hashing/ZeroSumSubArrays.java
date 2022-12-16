package dsa.Hashing;/*
Print all subarrays with 0 sum

Given an array, print all subarrays in the array which has sum 0.

Examples:

Input:  arr = [6, 3, -1, -3, 4, -2, 2,
             4, 6, -12, -7]
Output:
Subarray found from Index 2 to 4
Subarray found from Index 2 to 6
Subarray found from Index 5 to 6
Subarray found from Index 6 to 9
Subarray found from Index 0 to 10
 */

import java.util.ArrayList;
import java.util.HashMap;

public class ZeroSumSubArrays {
    static class SubArray {
        int start, end;
         SubArray(int start, int end) {
             this.start = start;
             this.end = end;
         }

    }
    static void zeroSumSubArrays(int[] arr , int n) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<SubArray> result = new ArrayList<>();
        int sum = 0;
        for(int i=0;i<n;i++) {
            sum +=arr[i];
            if(sum == 0) {
               result.add(new SubArray(0,i));
            }
            ArrayList<Integer> list = new ArrayList<>();
            if(map.containsKey(sum)) {
                list = map.get(sum);
                for(int j=0;j<list.size();j++) {
                    result.add(new SubArray(list.get(j)+1, i));
                }
            }
            list.add(i);
            map.put(sum, list);
        }
        for(SubArray sarray: result) {
            System.out.println("Subarray found from Index " +sarray.start +" to " +sarray.end);
        }

    }

    public static void main(String[] args) {
       int [] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
       zeroSumSubArrays(arr, arr.length);
    }
}