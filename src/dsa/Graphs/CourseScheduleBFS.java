package dsa.Graphs;

import java.util.LinkedList;

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
public class CourseScheduleBFS {

    static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || numCourses == 0 || prerequisites.length == 0) {
            return false;
        }
        //prerequisites length can be greater than num courses
        int len = prerequisites.length;

        //storing number of pre-requisites for a course
        int[] pcounter = new int[numCourses];
        for(int i=0;i<len;i++) {
            pcounter[prerequisites[i][0]]++;
        }

        //adding the courses with 0 pre-requisites to the queue
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++) {
            if(pcounter[i] == 0) {
                queue.add(i);
            }
        }
        // number of courses that have no prerequisites
        int num =  queue.size();
        while(!queue.isEmpty()) {
            int top = queue.poll();
            for(int i=0;i<len;i++) {
                // if a course's prerequisite can be satisfied by a course in queue
                if(prerequisites[i][1] == top) {
                    pcounter[prerequisites[i][0]]--;
                    if(pcounter[prerequisites[i][0]] == 0) {
                        num++;
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }
        return num==numCourses;
    }



    public static void main(String[] args) {
        System.out.println(canFinish(2,new int[][]{{1,0}}));
        System.out.println(canFinish(2,new int[][]{{1,0}, {0,1}}));
    }

}