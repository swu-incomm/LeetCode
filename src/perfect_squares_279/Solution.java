package perfect_squares_279;

import java.util.Arrays;

/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
 */
public class Solution {
    public int numSquares(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        int [] dp = new int [n+1];
        Arrays.fill(dp, n);
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i<= n; i++) {
            for(int j = 0; j<=i;j++) {
                if(j * j == i) dp[i] = 1;
                dp[i] = Math.min(dp[i], dp[i-j] + dp[j]);
            }
        }
        return dp[n];
    }

    public static void main(String [] args) {
        Solution solution = new Solution();
        solution.numSquares(12);
    }
}
