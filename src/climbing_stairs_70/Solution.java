package climbing_stairs_70;

import java.util.Arrays;

/*
You are climbing a stair case. It takes n steps to reach to the top.

        Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

        Note: Given n will be a positive integer.

        Example 1:

        Input: 2
        Output: 2
        Explanation: There are two ways to climb to the top.
        1. 1 step + 1 step
        2. 2 steps
        Example 2:

        Input: 3
        Output: 3
        Explanation: There are three ways to climb to the top.
        1. 1 step + 1 step + 1 step
        2. 1 step + 2 steps
        3. 2 steps + 1 step
        */
public class Solution {
    //Recursion solution
    public static int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        return climbStairs(n-1) + climbStairs(n-2);
    }

    public static int climbStairs2(int n) {
        if(n == 1) return 1;
        int [] res = new int [n];
        Arrays.fill(res, -1);
        res[0] = 1;
        res[1] = 2;
        return dp(n-1, res);
    }
    public static int dp(int n, int [] res) {
        if(res[n] == -1)
             res[n] = dp(n-1, res) + dp(n-2, res);
        return res[n];
    }

    public static int climbStairs3 (int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        int [] dp = new int [n];
        dp[0] = 1;
        dp[1] = 2;
        for(int i=2;i<n;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }
    public static void main(String [] args) {
        System.out.println(climbStairs3(5));
    }
}
