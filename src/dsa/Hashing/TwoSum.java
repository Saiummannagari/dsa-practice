package dsa.Hashing;/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
Input: nums = [2,7,11,15], target = 9
Output: [2,7]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */

import java.util.ArrayList;
import java.util.HashMap;

public class TwoSum {

    static class SubArray {
        int start, end;
        SubArray(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    static void findTwoSum(int[] arr, int n, int target) {
     HashMap<Integer, Integer> map = new HashMap<>();
     ArrayList<SubArray> list = new ArrayList<>();
     for(int i=0;i<n;i++) {
         int diff = target-arr[i];
         if(map.containsKey(diff)) {
             for(int j=0;j<map.get(diff);j++) {
                 list.add(new SubArray(diff, arr[i]));
             }
         }
         if (map.containsKey(arr[i]))
         {
             map.put(arr[i], map.get(arr[i]) + 1);
         }
         else
         {
             map.put(arr[i], 1);
         }
     }
      for(SubArray sarray : list) {
          System.out.println("("+sarray.start+","+sarray.end+")");
      }
    }

    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int n = arr.length;
        int target = 9;
        System.out.println("first array o/p::");
        findTwoSum(arr, n, target);
        int[] arr2 = {1, 5, 7, -1, 5};
        int n2 = arr2.length;
        int target2=6;
        System.out.println("second array o/p::");
        findTwoSum(arr2, n2, target2);
    }
}