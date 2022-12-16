package dsa.Graphs;

import java.util.Arrays;

public class Dijkstra {

    static class Edge{
        int src;
        int dest;
        int cost;

        public Edge(int src , int dest, int cost) {
            this.src = src;
            this.dest = dest;
            this.cost = cost;
        }
    }


    public static void main(String[] args) {
        Edge[] edges = new Edge[8];

        edges[0] = new Edge(1,2,4);
        edges[1] = new Edge(1,4,9);
        edges[2] = new Edge(2,3,-1);
        edges[3] = new Edge(3,6,3);
        edges[4] = new Edge(4,3,2);
        edges[5] = new Edge(4,5,-5);
        edges[6] = new Edge(5,6,0);
        edges[7] = new Edge(1,0,1);
        dijkstraAlgo(edges, 7, 1);
    }

    static void dijkstraAlgo(Edge[] edges, int n, int src) {
        int[] parent = new int[n];
        int[] cost = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(cost, Integer.MAX_VALUE);

        parent[src] = -1;
        cost[src] = 0;

        for(int i=0;i<n;i++) {
            int vertex = findMinValueEdge(cost, visited, n);
            visited[vertex] = true;
            System.out.println("vertex :: "+vertex);
            for(int j=0;j<edges.length;j++) {
                if(edges[j].src==vertex && cost[vertex]!=Integer.MAX_VALUE
                && (cost[vertex]+edges[j].cost<cost[edges[j].dest])) {
                    cost[edges[j].dest] = cost[vertex] + edges[j].cost;
                    parent[edges[j].dest] = vertex;
                }
            }
        }
        //printing shortest path graph
        for(int i=0;i<n;i++) {
            System.out.println(parent[i]+"->"+i+" cost to reach = "+cost[i]);
        }
    }

    private static int findMinValueEdge(int[] cost, boolean[] visited, int n) {
        int min_index = -1;
        int min_weight = Integer.MAX_VALUE;

        for(int i=0;i<n;i++) {
//            System.out.println("cost :: "+cost[i]);
//            System.out.println("visited :: "+visited[i]);
            if(visited[i] == false && cost[i]<min_weight) {
                min_weight = cost[i];
                min_index = i;
//                System.out.println("min index :: "+ min_index);
            }
        }
        return min_index;
    }
}