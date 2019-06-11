package rotate_image_48;

/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Given input matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
Example 2:

Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
],

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
 */
public class Solution {
    //The solution for this problem would be rotate the matrix layer by layer
    public void rotate(int[][] matrix) {
        int count = matrix.length;
        int top = 0, left = 0, right = matrix[0].length-1, bot = matrix.length -1;
        while(count > 1) {
            for(int i = 0; i<count-1;i++) {
                int temp = matrix[top][left + i];
                matrix[top][left + i] = matrix[bot - i][left];
                matrix[bot - i][left] = matrix[bot][right - i];
                matrix[bot][right - i] = matrix[top+i][right];
                matrix[top+i][right] = temp;
            }
            count -= 2;
            top += 1;
            left += 1;
            right -= 1;
            bot += 1;
        }
        for(int i = 0;i < matrix.length;i++){
            for(int j=0; j<matrix[0].length;j++){
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }

    }
    public static void main(String [] args){
        int [][]test1 = new int [][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int [][]test2 = new int [][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        Solution obj = new Solution();
        //obj.rotate(test1);
        obj.rotate(test2);
    }

}
