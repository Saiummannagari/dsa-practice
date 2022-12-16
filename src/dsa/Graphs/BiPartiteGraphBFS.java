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
import java.util.LinkedList;
import java.util.Map;

public class BiPartiteGraphBFS {

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
        for(int i: map.keySet()){
            if(color[i] ==0) {
                color[i]=1;
                LinkedList<Integer> queue = new LinkedList<>();
                queue.add(i);
                while(!queue.isEmpty()) {
                    int node = queue.poll();
                    if(map.containsKey(node)) {
                        ArrayList<Integer> list = map.get(node);
                        for (int l : list) {
                            if (color[l] == color[node]) {
                                return false;
                            }
                            if (color[l] == 0) {
                                color[l] = -color[node];
                                queue.add(l);
                            }
                        }
                    }
                }
            }
        }
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