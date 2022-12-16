package dsa.Graphs;/*
Possible Bipartition

We want to split a group of n people (labeled from 1 to n) into two groups of any size. Each person may dislike some other people, and they should not go into the same group.

Given the integer n and the array dislikes where dislikes[i] = [ai, bi] indicates that the person labeled ai does not like the person labeled bi, return true if it is possible to split everyone into two groups in this way.

Example 1:

Input: n = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4] and group2 [2,3].
Example 2:

Input: n = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false
Example 3:

Input: n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
Output: false
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BipartiteGraphDFS {

    static boolean possibleBipartition(int n, int[][] dislikes) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i < dislikes.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            if(map.containsKey(dislikes[i][0])) {
                list = map.get(dislikes[i][0]);
                list.add(dislikes[i][1]);
                map.put(dislikes[i][0], list);
            } else {
                list.add(dislikes[i][1]);
                map.put(dislikes[i][0], list);
            }
        }

        int[] color = new int[n+1];
        for(Map.Entry<Integer, ArrayList<Integer>> m: map.entrySet()) {
            if(!biPartition(map, m.getKey(), 1,color)) {
                return false;
            }
        }
      return true;
    }

    private static boolean biPartition(HashMap<Integer, ArrayList<Integer>> map, Integer key,int color, int[] visited) {
        if(visited[key] != 0 && visited[key]!=color) {
            return false;
        }
        visited[key] = color;
        if(map.containsKey(key)) {
            for (Integer value : map.get(key)) {
                if (!biPartition(map, value, -color, visited)) {
                    return false;
                }
            }
        }
        visited[key] = -color;
        return true;
    }

    public static void main(String[] args) {
        int[][] dislikes =  {{1,2},{1,3},{2,4}};
        System.out.println(possibleBipartition(4,dislikes));

        int[][] dislikes2 = {{1,2},{1,3},{2,3}};
        System.out.println(possibleBipartition(3,dislikes2));

        int[][] dislikes3 = {{1,2},{2,3},{3,4},{4,5},{1,5}};
        System.out.println(possibleBipartition(5,dislikes3));
    }
}