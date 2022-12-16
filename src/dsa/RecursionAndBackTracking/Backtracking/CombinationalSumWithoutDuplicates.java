package dsa.RecursionAndBackTracking.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationalSumWithoutDuplicates {

    public static void main(String[] args) {
        int[] candidates = { 2, 4, 6, 8  };
        Arrays.sort(candidates);
        int target = 8;
        List<List<Integer>> result = findCombinations(candidates, target);
        System.out.println(result);
    }

    static List<List<Integer>> findCombinations(int[] arr, int target) {
        List<Integer> currList = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        int index = 0;
        int sum =0;
        findCombinations(arr, target, currList, result, sum, index);
        return result;
    }

    static void findCombinations(int[] arr, int target, List<Integer> currList, List<List<Integer>> result, int sum, int index) {

        if(sum > target) {
            return;
        }
        else if(sum == target) {
            Collections.sort(currList);
            if(!result.contains(currList)) {
              result.add(new ArrayList<>(currList));
            }
        } else {
            for(int i=index;i< arr.length;i++) {
                currList.add(arr[i]);
                findCombinations(arr, target, currList, result, sum + arr[i], i+1);
                currList.remove(currList.size() -1);
            }
        }
    }
}