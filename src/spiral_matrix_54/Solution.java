package spiral_matrix_54;

import java.util.ArrayList;
import java.util.List;

/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
//using simulation method
//define right->down->left->up cycling direction array
//every time encounter a visited element or at the edge of the metrix, change direction
public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return ans;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] seen = new boolean[m][n];
        int[] rd = new int[]{0, 1, 0, -1};
        int[] cd = new int[]{1, 0, -1, 0};
        int r = 0, c = 0, p = 0;
        for(int i = 0; i<m * n; i++) {
            ans.add(matrix[r][c]);
            seen[r][c] = true;
            int tempR = r + rd[p];
            int tempC = c + cd[p];
            if(tempR <0 || tempR >=m || tempC <0 || tempC>=n || seen[tempR][tempC] == true) {
                p = (p+1)%4;
                r += rd[p];
                c+=cd[p];
            } else {
                r = tempR;
                c = tempC;
            }
        }
        return ans;
    }
}
