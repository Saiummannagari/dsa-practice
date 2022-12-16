package dsa.Hashing;/*
Sum equals to Sum

Given an array A of N integers. The task is to find if there are two pairs (a, b) and (c, d) such that a+b = c+d.

Example 1:

Input:N=7 A[] = {3, 4, 7, 1, 2, 9, 8} Output: 1Explanation:(3, 7) and (9, 1) are the pairs whosesum are equal.

Example 2:

Input:N=7 A[] = {65, 30, 7, 90, 1, 9, 8}Output: 0
 */

import java.util.HashMap;
import java.util.HashSet;

public class SumEqualsSum {
    static class Index {
        int i, j;

        public Index(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    static int countSumEqualsSumPair(int[] arr) {
        int count = 0;
        int n = arr.length;
        HashMap<Integer, Index> map = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                map.put(arr[i] + arr[j], new Index(i, j));
            }
        }
        for(int i=0;i<n-1;i++) {
            for(int j=i+1;j<n;j++) {
                int sum = arr[i]+arr[j];
                if(map.containsKey(sum)) {
                    Index index = map.get(sum);
                    if(index.getI() != i && index.getJ() != j && index.getI() != j && index.getJ()!=i) {
                       count++;
                       System.out.println("Pairs are :: "+ "("+arr[i]+","+arr[j]+")" +
                           " = " + "("+arr[index.getI()]+","+arr[index.getJ()]+")");
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 7, 1, 2, 9, 8};
        int pairs = countSumEqualsSumPair(arr);
        System.out.println("Number of pairs :: " + pairs);
    }
}