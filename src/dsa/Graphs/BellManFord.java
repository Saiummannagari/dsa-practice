package dsa.Graphs;/*
https://gist.github.com/SuryaPratapK/5d8de644480b94fe57041a6b6c857659
 */

import java.util.Arrays;
import java.util.Scanner;

public class BellManFord {

    static class Edge{
        int src;
        int dest;
        int cost;

        Edge(int src , int dest, int cost) {
            this.src = src;
            this.dest = dest;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
//        System.out.println("Enter number of vertices and edges :: ");
//        Scanner sc = new Scanner(System.in);
//        int v = sc.nextInt();
//        int e = sc.nextInt();
          Edge[] edges = new Edge[8];
//        for(int i=0;i<e;i++) {
//            System.out.println("add edge and cost for "+i);
//            edges[i] = new Edge();
//            edges[i].src = sc.nextInt();
//            edges[i].dest = sc.nextInt();
//            edges[i].cost = sc.nextInt();
//        }

        edges[0] = new Edge(1,2,4);
        edges[1] = new Edge(1,4,9);
        edges[2] = new Edge(2,3,-1);
        edges[3] = new Edge(3,6,3);
        edges[4] = new Edge(4,3,2);
        edges[5] = new Edge(4,5,-5);
        edges[6] = new Edge(5,6,0);
        edges[7] = new Edge(1,0,1);

        bellmanFord(edges, 7, 1);
    }

    private static void bellmanFord(Edge[] edges, int n,int source) {
        //creating cost array
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);

        //creating parent array
        int[] parent = new int[n];

        //marking 0 as source
        cost[source] = 0;
        parent[source] = -1;

        boolean updated=false;
        //we have to exclude the source. so we have to run for v-1
        for(int i=0;i<n-1;i++) {
            updated = false;

            for(int j=0;j<edges.length;j++) {
                 int u = edges[j].src;
                 int v = edges[j].dest;
                 int wt = edges[j].cost;
                 if(cost[u]!=Integer.MAX_VALUE && cost[u]+wt<cost[v]) {
                     cost[v] = cost[u]+wt;
                     parent[v] = u;
                     updated = true;
                 }
            }
            if(updated == false){
                break;
            }
        }

        //check by relaxing once more for checking if there is a negative cycle
        for(int j=0;j<edges.length-1 && updated==true;j++) {
            int u= edges[j].src;
            int v= edges[j].dest;
            int wt= edges[j].cost;
            if(cost[v]!=Integer.MAX_VALUE && cost[u]+wt<cost[v]) {
                System.out.println("Graph has -ve edge cycle");
                return;
            }
        }

        for(int i=0;i<n;i++) {
            System.out.println(parent[i]+"->"+i+" cost to reach = "+cost[i]);
        }
    }
}