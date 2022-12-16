package dsa.Graphs;/*
Number of Operations to Make Network Connected

There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network where connections[i] = [ai, bi] represents a connection between computers ai and bi. Any computer can reach any other computer directly or indirectly through the network.

You are given an initial computer network connections. You can extract certain cables between two directly connected computers, and place them between any pair of disconnected computers to make them directly connected.

Return the minimum number of times you need to do this in order to make all the computers connected. If it is not possible, return -1.

Input: n = 4, connections = [[0,1],[0,2],[1,2]]
Output: 1
Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class MakeConnected {

    public static void main(String[] args) {
       int[][] connections = new int[][]{{0,1},{0,2},{0,3},{1,2},{1,3}};
       int n= 6;
       System.out.println(makeConnected(n, connections));
       int[][] connections2 = new int[][]{{0,1},{0,2},{1,2}};
       int n2= 4;
       System.out.println(makeConnected(n2, connections2));
        int[][] connections3 = new int[][]{{0,1},{0,2},{0,3},{1,2}};
        int n3= 6;
        System.out.println(makeConnected(n3, connections3));
    }

    public static int makeConnected(int n, int[][] connections) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            map.put(i, new ArrayList<>());
        }

        int edges = 0;
        for(int i=0;i<connections.length;i++) {
            map.get(connections[i][0]).add(connections[i][1]);
            map.get(connections[i][1]).add(connections[i][0]);
            edges++;
        }

        int connectedComponents = 0;
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                connectedComponents++;
                dfs(n, i, map, visited);
            }
        }

        if(edges < n-1){
            return -1;
        }
        int redundantEdges = edges-(n-connectedComponents);
        if(redundantEdges >= connectedComponents-1) {
            return connectedComponents-1;
        }
        return -1;
    }

    private static void dfs(int n, int i,
                            HashMap<Integer, ArrayList<Integer>> map, boolean[] visited) {
        visited[i] = true;
        for(Integer j: map.get(i)) {
            if(!visited[j]) {
                dfs(n,j, map, visited);
            }
        }
    }
}