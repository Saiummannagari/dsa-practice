package dsa.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Russian Doll Envelopes

You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.

One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.

Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).

Note: You cannot rotate an envelope.

Example 1:

Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
Output: 3
Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
Example 2:

Input: envelopes = [[1,1],[1,1],[1,1]]
Output: 1
 */
class RussianDoll {
    public static void main(String[] args) {
//        int[][] list = {{5,4},{6,4},{6,7},{2,3}};
//        System.out.println("Number of envelopes :: "+ numberOfEnvelopes(list));
//
//        int[][] list2 = {{1,1},{1,1},{1,1},{1,1}};
//        System.out.println("Number of envelopes :: "+ numberOfEnvelopes(list2));

        int[][] list = {{5,4},{6,4},{6,7},{2,3}};
        System.out.println("Number of envelopes :: "+ maxEnvelopes(list));


        int[][] list2 = {{1,1},{1,1},{1,1},{1,1}};
        System.out.println("Number of envelopes :: "+ maxEnvelopes(list2));

    }

    //using dp
    private static int numberOfEnvelopes(int[][] list) {
       int[] dp = new int[list.length];
       Arrays.fill(dp, 1);
       for(int i=0;i< list.length;i++) {
           for(int j=0;j< list.length;j++) {
               if(list[j][0]<list[i][0] && list[j][1]<list[i][1] && dp[i]<dp[j]+1 && i!=j) {
                   dp[i] = dp[j]+1;
               }
           }
       }
       int max=0;
       for(int i=0;i< list.length;i++) {
           max = Math.max(dp[i], max);
       }
       return max;
    }



    public static int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0] == null || envelopes[0].length != 2) return 0;
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int n = envelopes.length, len = 1;
        int[] dp = new int[n];
        dp[0] = envelopes[0][1];
        for (int i = 1; i < n; i++) {
            if (envelopes[i][1] > dp[len - 1]) {
                dp[len++] = envelopes[i][1];
            } else {
                int id = Arrays.binarySearch(dp, 0, len, envelopes[i][1]);
                if (id < 0) id = -(id + 1);
                dp[id] = envelopes[i][1];
            }
        }
        return len;
    }
}