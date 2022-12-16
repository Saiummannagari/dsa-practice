package dsa.Graphs;

import java.util.ArrayList;
import java.util.HashMap;

/*
Course Schedule

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.
 */
public class CourseScheduleDFS {

    static boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || numCourses ==0 || prerequisites.length == 0) {
            return false;
        }
        boolean[] visited = new boolean[numCourses];
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for(int[] arr: prerequisites) {
            if(map.containsKey(arr[0])) {
                map.get(arr[0]).add(arr[1]);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(arr[1]);
                map.put(arr[0], list);
            }
        }

        for(int i=0;i<numCourses;i++) {
            if(!canFinish(map, visited, i)) {
                return false;
            }
        }
      return true;
    }

    static boolean canFinish(HashMap<Integer, ArrayList<Integer>> map,boolean [] visited, int i) {
        if(visited[i]) {
            return false;
        }
        visited[i] = true;
        if(map.containsKey(i)) {
            for(int j: map.get(i)) {
                if(!canFinish(map, visited, j)){
                    return false;
                }
            }
        }
        visited[i] = false;
        return true;
    }



    public static void main(String[] args) {
        System.out.println(canFinish(2,new int[][]{{1,0}}));
        System.out.println(canFinish(2,new int[][]{{1,0}, {0,1}}));
    }

}