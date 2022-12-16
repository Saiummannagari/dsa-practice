package dsa.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class UnionByRank {

    static class Node {
        int parent;
        int rank;

        Node(int parent, int rank) {
            this.rank = rank;
            this.parent = parent;
        }
    }

    static int find(int v, Node[] arr) {
        if(arr[v].parent == -1) {
         //   arr[v].parent = v;
            return v;
        }
        return arr[v].parent = find(arr[v].parent, arr);
    }

    static void union(int from, int to, Node[] arr) {
        int fromp = find(from, arr);
        int top = find(to, arr);

        if(arr[fromp].rank < arr[top].rank) {
            arr[fromp].parent = top;
        } else if(arr[fromp].rank > arr[top].rank) {
            arr[top].parent = fromp;
        } else {
            arr[top].parent = fromp;
            arr[fromp].rank = arr[fromp].rank+1;
        }

    }

    static boolean findCycle(int n, int[][] graph, Node[] arr) {
        for(int i=0;i<n;i++) {
            arr[i] = new Node(-1, 0);
        }
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
        Node[] rankArr = new Node[n];
        System.out.println(findCycle(n, graph, rankArr));
    }
}