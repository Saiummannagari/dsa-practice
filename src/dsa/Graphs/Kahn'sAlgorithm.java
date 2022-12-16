package dsa.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

class Algorithm{

    static void findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<numCourses;i++) {
            map.put(i, new ArrayList<>());
        }
        int[] counter = new int[numCourses];
        for(int[] courses: prerequisites) {
            ArrayList<Integer> list = map.get(courses[0]);
            list.add(courses[1]);
            map.put(courses[0], list);
            counter[courses[0]]++;
        }

        LinkedList<Integer> ans = new LinkedList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++) {
            if(counter[i] == 0) {
                queue.add(i);
                ans.add(i);
            }
        }
        int coursesCounter =0;
        int len = prerequisites.length;

        while(!queue.isEmpty()) {
            int course = queue.poll();
        //    visited[course] = true;
           for(int i=0;i<len;i++) {
               if(prerequisites[i][1] == course) {
                   counter[prerequisites[i][0]]--;
                   if(counter[prerequisites[i][0]] == 0) {
                       queue.add(prerequisites[i][0]);
                       coursesCounter++;
                       ans.add(prerequisites[i][0]);
                   }
               }
           }

        }
     //   if(numCourses == coursesCounter) {
            System.out.println(ans.toString());
       // }
       // else {
         //   System.out.println("Course schedule doesnot exist");
       // }

    }
    public static void main(String[] args) {
        findOrder(2,new int[][]{{1,0}});
        findOrder(2,new int[][]{{1,0}, {0,1}});
        findOrder(6,new int[][]{{0,2},{0,3},{3,1},{4,2},{4,1},{5,0},{5,2}});
    }
}