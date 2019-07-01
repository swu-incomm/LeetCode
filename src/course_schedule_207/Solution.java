package course_schedule_207;

import java.util.Queue;

import java.util.LinkedList;

/*
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
 */
public class Solution {
    //Solution1 BFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //邻接矩阵
        int [][] matrix = new int [numCourses][numCourses];
        //degree array
        int [] degrees = new int [numCourses];

        for(int i = 0; i<prerequisites.length;i++) {
            int pre = prerequisites[i][1];
            int take = prerequisites[i][0];

            degrees[take]++;
            matrix[pre][take] = 1;
        }

        Queue<Integer> queue = new LinkedList <> ();

        for(int i = 0; i<numCourses;i++) {
            if(degrees[i] == 0) {
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()) {
            int p = queue.poll();
            for(int i = 0; i<numCourses; i++) {
                if(matrix[p][i] != 0) {
                    if(--degrees[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }
        for(int i = 0; i<numCourses;i++) {
            if(degrees[i] != 0) return false;
        }
        return true;
    }
}
