package dsa.Graphs;/*
Critical Connections in a Network

There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections forming a network where connections[i] = [ai, bi] represents a connection between servers ai and bi. Any server can reach other servers directly or indirectly through the network.

A critical connection is a connection that, if removed, will make some servers unable to reach some other server.

Return all critical connections in the network in any order.

Example 1:
Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
Output: [[1,3]]
Explanation: [[3,1]] is also accepted.

Example 2:

Input: n = 2, connections = [[0,1]]
Output: [[0,1]]

Time complexity: O(V+E)
 */


import java.util.*;

public class CriticalConnections {

    public static void main(String[] args) {
        int n=4;
        int[][] connections = new int[][]{{0,1},{1,2},{2,0},{1,3}};
        criticalConnections(n, connections);
        for(List<Integer> l : res) {
            for(Integer i: l) {
                System.out.print(i+ " ");
            }
            System.out.println();
        }
        res = new ArrayList<>();
        int n2 = 2;
        int[][] connections2 = new int[][] {{0,1}};
        criticalConnections(n2, connections2);
        for(List<Integer> l : res) {
            for(Integer i: l) {
                System.out.print(i+ " ");
            }
            System.out.println();
        }
    }
    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> criticalConnections(int n, int[][] connections) {
       int[] disc = new int[n];
       int[] low = new int[n];
       int[] parent = new int[n];
       Arrays.fill(disc, -1);
       Arrays.fill(low, -1);
        Arrays.fill(parent, -1);
       int counter = 0;

       Map<Integer, ArrayList<Integer>> map = new HashMap<>();
       for(int i=0;i<n;i++) {
           map.put(i, new ArrayList<>());
       }
       //adding undirected edges
       for(int i=0;i< connections.length;i++) {
           map.get(connections[i][0]).add(connections[i][1]);
           map.get(connections[i][1]).add(connections[i][0]);
       }
       for(int i=0;i<n;i++) {
           if(disc[i]==-1) {
               dfs(n, i, map, disc, low, counter, parent);
           }
       }
     return  res;
    }

    private static void dfs(int n, int i,Map<Integer, ArrayList<Integer>> connections, int[] disc, int[] low, int counter, int[] parent) {
        disc[i] = counter;
        low[i] = counter;
        ArrayList<Integer> connects = connections.get(i);
        counter++;
        for(Integer x : connects) {
            parent[x] = i;
         if(disc[x] == -1) {
             dfs(n, x, connections, disc, low, counter, parent);
             low[i] = Math.min(low[i], low[x]);

             if(low[x]>disc[i]) {
                 res.add(new ArrayList<>(){{add(i);add(x);}});
             }
         } else if(x!=parent[i]){
             //backedge
             low[i] = Math.min(low[i], disc[x]);
         }
      }
    }
}