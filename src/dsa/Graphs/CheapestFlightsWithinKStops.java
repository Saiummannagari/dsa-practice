package dsa.Graphs;/*
Cheapest Flights Within K Stops

There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
Output: 700
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CheapestFlightsWithinKStops {

    static public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

       Map<Integer, Integer> map = new HashMap<>();
       for(int i=0;i<flights.length;i++) {
           if(flights[i][0] == src) {
               map.put(flights[i][1], flights[i][2]);
           }
       }

     //  boolean[] visited = new boolean[n];
       int cost = Integer.MAX_VALUE;
       for(Map.Entry<Integer, Integer> i: map.entrySet()) {
          int cost1 = findCheapest(i.getKey(), dst, flights, i.getValue(), --k, cost);
          if(cost1<cost) {
              cost = cost1;
          }
       }
     return cost;
    }

    static int findCheapest(int src, int dest, int[][] flights, int cost, int k, int cheapestCost) {
        if(src == dest) {
           if(cheapestCost<cost) {
               return cheapestCost;
           }
           return cost;
        }
        if(k<0) {
            return Integer.MAX_VALUE;
        }
        for(int i=0;i<flights.length;i++) {
            if(src == flights[i][0]) {
              int cost1 = findCheapest(flights[i][1], dest, flights, cost + flights[i][2], --k, cheapestCost);
              if(cost1<cheapestCost){
                  cheapestCost = cost1;
              }
            }
        }
        return cheapestCost;
    }

    public static void main(String[] args) {
        int numVertices=3;
        int[][] flights = new int[][]{{0,1,100},{1,2,100},{0,2,500}};
        int src=0;
        int dest=2;
        int k=0;
        System.out.println(findCheapestPrice(numVertices, flights, src, dest, k));

        int[][] flights2 = {{0,1,100}, {1,2,100}, {0,2,500}};
        System.out.println(findCheapestPrice(3, flights2, 0, 2, 1));

        int[][] flights3 = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        System.out.println(findCheapestPrice(4, flights3, 0, 3, 1));
    }
}