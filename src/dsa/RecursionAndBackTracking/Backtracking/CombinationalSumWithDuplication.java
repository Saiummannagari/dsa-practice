package dsa.RecursionAndBackTracking.Backtracking;/*
Combinational Sum

Given a set of array numbers (without duplicates) and a target number (target), find all unique combinations in the array where the numbers sum to target. The same repeated number may be chosen from array unlimited number of times. Note: All numbers (including target) will be positive integers. The solution set must not contain duplicate combinations.

Example:

Input: array = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
 */

import java.util.*;
public class CombinationalSumWithDuplication  {

    public static void main(String args[]) {

        int[] candidates = { 1,2,3 };
        Arrays.sort(candidates);
        int target = 4;
        List<List<Integer>> result = combinationSum(candidates, target);
        System.out.println(result);
    }

   static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<Integer> currList = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        int sum=0;
        int index=0;
        combinationSum(candidates, target, currList, result, sum, index);
        return result;
    }

    static void combinationSum(int[] array, int target, List<Integer> currList, List<List<Integer>> result, int sum, int index) {
        if(sum > target) {
            return;
        } else if(sum == target) {
            Collections.sort(currList);
            if(!result.contains(currList)) {
                result.add(new ArrayList<>(currList));
            }
        } else {
            for(int i = index; i<array.length; i++) {
                currList.add(array[i]);
                combinationSum(array, target, currList, result, sum+array[i], i);
                currList.remove(currList.size()-1);
            }
        }
    }

}