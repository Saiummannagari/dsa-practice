package dsa.Hashing;/*
Find largest d in array such that a + b + c = d

Given a set S (all distinct elements) of integers, find the largest d such that a + b + c = d
where a, b, c, and d are distinct elements of S.

Examples :

Input : S[] = {2, 3, 5, 7, 12}
Output : 12
Explanation: 12 is the largest d which can be represented as 12 = 2 + 3 + 7

Input : S[] = {2, 16, 64, 256, 1024}
Output : No solution

 */

import java.util.HashMap;

public class FindLargestD  {

    static class Index {
        int i;
        int j;
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
    private static int findFourElements(int[] arr, int n) {
    int max = Integer.MIN_VALUE;
    HashMap<Integer, Index> map = new HashMap<>();
    for(int i=0;i<n-1;i++) {
        for(int j=i+1;j<n;j++) {
            map.put(arr[i]+arr[j], new Index(i, j));
        }
    }

    for(int i=0;i<n-1;i++) {
        for(int j=i+1;j<n;j++) {
            int diff = Math.abs(arr[i]-arr[j]);
            if(map.containsKey(diff)) {
                Index index = map.get(diff);
                if(index.getI() != i && index.getJ() != j && index.getI() != j && index.getJ()!=i) {
                    max = Math.max(max, Math.max(arr[i], arr[j]));
                }
            }
        }
    }
    return max;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 5, 7, 12 };
        int n = arr.length;
        int res = findFourElements(arr, n);
        if (res == Integer.MIN_VALUE)
            System.out.println("No Solution");
        else
            System.out.println(res);
    }
}