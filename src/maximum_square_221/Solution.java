package maximum_square_221;
/*
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4
 */
public class Solution {
    public int maximalSquare(char[][] matrix) {
        int ans = 0;
        if(matrix == null || matrix.length == 0) return ans;
        //represent side length
        int [][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0; i<matrix.length;i++) {
            for(int j = 0; j<matrix[0].length;j++) {
                if(i == 0 || j ==0) {
                    dp[i][j] = matrix[i][j] - '0';
                }
                else if(matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1])) + 1;
                }
                if(ans < dp[i][j]) ans = dp[i][j];
            }
        }
        for(int []  i : dp) {
            for(int j : i) {
                System.out.printf("%d ", j);
            }
            System.out.println();
        }
        return ans * ans;
    }

    public static void main(String [] args) {
        char [][] test = new char [][] {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        Solution solution = new Solution();
        System.out.println(solution.maximalSquare(test));
    }
}
