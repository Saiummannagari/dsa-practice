package dsa.RecursionAndBackTracking;

import java.util.ArrayList;

public class SubsequencesUsingIteration {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> res = printSubsequences(new int[]{1, 2, 3});
        for (ArrayList result : res) {
            System.out.println(result);
        }
    }

    static ArrayList<ArrayList<Integer>> printSubsequences(int[] arr)
    {
        ArrayList<ArrayList<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for(int num : arr) {
            int n = outer.size();
            for(int i=0; i<n; i++) {
                ArrayList<Integer> internal = new ArrayList<>(outer.get(i));
                    internal.add(num);
                    outer.add(internal);
                }
            }
        return outer;
        }

    }
