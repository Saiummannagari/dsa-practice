package dsa.RecursionAndBackTracking;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsequenceUsingIterationWithoutDuplicates {

    public static void main(String[] args) {
      ArrayList<ArrayList<Integer>> results = subsequenceWithoutDuplication(new int[] {1,2,2,2});
      for(ArrayList<Integer> result: results) {
          System.out.println(result);
      }
    }

    static ArrayList<ArrayList<Integer>> subsequenceWithoutDuplication(int[] arr) {
        ArrayList<ArrayList<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        Arrays.sort(arr);
        int start = 0;
        int end = 0;
        for(int i=0; i<arr.length; i++) {
            if(i> 0 && arr[i] == arr[i-1]) {
                start = end + 1;
            }
            end = outer.size()-1;
            int n= outer.size();
            for(int j=start;j<n;j++) {
                ArrayList<Integer> inner = new ArrayList<>(outer.get(j));
                inner.add(arr[i]);
                outer.add(inner);
            }
        }
        return outer;
    }
}