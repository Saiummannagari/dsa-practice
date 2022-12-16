package dsa.Graphs;/*
Disjoint set

Find if there is a cycle using union and find operations
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class DisjointSet {

    //used for finding the parent node
    static int find(int v, int[] arr) {
        if(arr[v] == -1) {
            return v;
        }
        return find(arr[v], arr);
    }

    static void union(int from, int to, int[] arr) {
        int fromp = find(from, arr);
        int top = find(to, arr);

        arr[top] = fromp;
    }

    static boolean findCycle(int n, int[][] graph) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        int[] arr = new int[n];
        Arrays.fill(arr, -1);
        for(int i=0;i<graph.length;i++) {
             int from = find(graph[i][0], arr);
             int to = find(graph[i][1], arr);
             if(from == to) {
                 return true;
             }
             union(from, to, arr);
        }
      return false;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] graph = new int[][]{{0,1},{0,2},{1,3},{1,2}};
        System.out.println(findCycle(n, graph));
    }
}