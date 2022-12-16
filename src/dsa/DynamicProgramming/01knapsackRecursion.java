package dsa.DynamicProgramming;/*
time complexity (2 power n)
 */

class Knapsack {

    public static void main(String[] args) {
        int val[] = { 60, 100, 120 };
        int wt[] = { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.println(knapsack(W, wt, val, n));
    }

    private static int knapsack(int w, int[] wt, int[] val, int n) {
        if(w==0 || n==0) {
            return 0;
        } else if(wt[n-1]>w) {
            return knapsack(w, wt, val, n-1);
        } else {
            return Math.max(val[n-1]+knapsack(w-wt[n-1], wt, val, n-1), knapsack(w, wt, val, n-1));
        }
    }
}