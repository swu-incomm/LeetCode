package pascals_triangle_118;

import java.util.ArrayList;
import java.util.List;

/*
Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it.

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        if(numRows <= 0) return triangle;

        //add first line
        triangle.add(new ArrayList<>());
        triangle.get(1).add(1);

        for(int i = 1; i<numRows;i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(i-1);

            row.add(1);

            for(int j = 1; j<i;j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }

            row.add(1);

            triangle.add(row);
        }
        return triangle;

    }
}
