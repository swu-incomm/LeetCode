package merge_intervals_56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */
public class Solution {

    public int[][] merge(int[][] intervals) {
        List<int []> res = new ArrayList<>();
        if(intervals == null || intervals.length == 0) return res.toArray(new int[0][]);

        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        int [] prev = intervals[0];
        res.add(prev);
        for(int [] interval : intervals) {
            System.out.println(interval[0] + " "+ interval[1]);
            if(interval[0] <= prev[1]) {
                prev[1] = Math.max(interval[1], prev[1]);
            } else {
                prev = interval;
                res.add(prev);
            }
        }

        return res.toArray(new int [res.size()][]);
    }

    public static void main(String [] args) {
        int [][] test = new int [][] {
                {1,3},
                {2,6},
                {8,10},
                {15,18}
        };
        Solution solution = new Solution();
        solution.merge(test);
    }
}
