package dsa.Graphs;/*
Course Schedule II

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].

Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].


Topological Sort (used only for directed acyclic graph)
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class CourseSchedule2TopologicalSort {

    static int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || numCourses ==0 || prerequisites.length == 0 || prerequisites[0].length == 0) {
            return new int[0];
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
                return new int[0];
            }
        }
        Stack<Integer> courses = new Stack<>();
        for(int i=0;i<numCourses;i++) {
            if(!visited[i]) {
                courseOrder(map, visited, i, courses);
            }
        }
        int[] ans = new int[numCourses];
        int i=0;
        for(Integer val: courses) {
           ans[i++] = val;
        }
       return ans;

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

    private static void courseOrder(HashMap<Integer, ArrayList<Integer>> map,
                                       boolean[] visited, int i, Stack<Integer> courses) {

        visited[i] = true;
        if(map.containsKey(i)) {
            ArrayList<Integer> list = map.get(i);
            for (Integer val : list) {
                if (!visited[val]) {
                    courseOrder(map, visited, val, courses);
                }
            }
        }
        courses.push(i);
    }


    public static void main(String[] args) {
//        System.out.println(findOrder(2,new int[][]{{1,0}}).toString());
//        System.out.println(findOrder(4,new int[][]{{1,0},{2,0},{3,1},{3,2}}));
        for(int i :findOrder(6,new int[][]{{0,2},{0,3},{3,1},{4,2},{4,1},{5,0},{5,2}})) {
            System.out.print(i+" ");
        }
    }
}