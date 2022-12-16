package dsa.Graphs;/*
Network Delay Time

You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.

Example 1:
Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2

Example 2:
Input: times = [[1,2,1]], n = 2, k = 1
Output: 1

time complexity: O(V+E)
 */

import java.util.*;

class NetworkDelayTime {

    public static class Edge{
        int dst;
        int wt;
        Edge(int dst , int wt){
            this.dst = dst;
            this.wt = wt;
        }
    }
    public static class pair{
        int v;
        int dist;
        pair(int v, int dist){
            this.v = v;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        int[][] times = new int[][] {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4;
        int k = 2;
        System.out.println(networkDelayTime(times, n, k));
        int[][] times2 = new int[][] {{1,2,1}};
        int n2 = 2;
        int k2 = 1;
        System.out.println(networkDelayTime(times2, n2, k2));
        int[][] times3 = new int[][] {{1,2,1}};
        int n3 = 2;
        int k3 = 2;
        System.out.println(networkDelayTime(times3, n3, k3));
    }

    static int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, ArrayList<Edge>> map = new HashMap<>();
        for(int i=1;i<=n;i++) {
            map.put(i, new ArrayList<>());
        }
        for(int i=0;i<times.length;i++) {
            Edge ed = new Edge(times[i][1], times[i][2]);
            map.get(times[i][0]).add(ed);
        }
//        for(Integer i: map.keySet()) {
//            System.out.print("key :: "+i);
//            for(Edge j: map.get(i)) {
//                System.out.print("value :: "+j.dst+" "+j.wt);
//            }
//            System.out.println();
//        }

        //pushing initial source and distance
        pair pair = new pair(k, 0);

        //creating queue
        Queue<pair> queue = new LinkedList<>();
        queue.add(pair);

        //creating distance matrix
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[k] = 0;
        int time = 0;

        while(!queue.isEmpty()) {
            pair p = queue.poll();

            for(Edge e: map.get(p.v)){
                pair temp = new pair(e.dst, e.wt+p.dist);
                if(distance[temp.v] > temp.dist) {
                    queue.add(temp);
                    distance[temp.v] = e.wt+p.dist;
                }
            }
        }

        for(int i=1;i<n+1;i++) {
            if(distance[i]==Integer.MAX_VALUE) {
                return -1;
            }
            time=Math.max(time, distance[i]);
        }
        return time;
    }
}