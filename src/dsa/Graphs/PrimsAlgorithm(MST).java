package dsa.Graphs;

import java.util.ArrayList;
import java.util.Arrays;

class PrimsAlgorithm {

    private static void printMST(int[][] graphArray) {

    int[] mstArray = new int[graphArray.length];
    int[] weights = new int[graphArray.length];
    boolean[] visited = new boolean[graphArray.length];

    //fill the weights of the edges as a maximum value
    Arrays.fill(weights, Integer.MAX_VALUE);

    weights[0] = 0;
    mstArray[0] = -1;
    for(int i=0;i<graphArray.length;i++) {
        int edge = findMinWeightVertex(weights, visited, graphArray.length);
        visited[edge] = true;

        for(int vertex =0;vertex< graphArray.length;vertex++) {
            if(graphArray[edge][vertex]!=0 &&visited[vertex] == false
                    && graphArray[edge][vertex] < weights[vertex]) {
                mstArray[vertex] = edge;
                weights[vertex] = graphArray[edge][vertex];
            }
        }
    }
        showMinimumSpanningTree(mstArray, graphArray);
    }

    private static void showMinimumSpanningTree(int[] mstArray, int[][] graphArray) {
        System.out.println("Edge \t\t weight");
        for(int i=1;i< graphArray.length;i++) {
            System.out.println(mstArray[i] + "<->"+i+"\t\t"+ graphArray[i][mstArray[i]]);
        }
    }

    private static int findMinWeightVertex(int[] weights, boolean[] visited, int n) {
        int min_index = -1;
        int min_weight = Integer.MAX_VALUE;

        for(int i=0;i<n;i++) {
            if(visited[i] == false && weights[i]<min_weight) {
                min_weight = weights[i];
                min_index = i;
            }
        }
        return min_index;
    }

    public static void main(String[] args) {
        int graphArray[][] = new int[][]{{ 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 }};

        printMST(graphArray);
    }
}