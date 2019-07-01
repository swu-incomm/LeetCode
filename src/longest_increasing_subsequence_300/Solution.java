package longest_increasing_subsequence_300;

import java.util.Arrays;

/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Note:

There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.
Follow up: Could you improve it to O(n log n) time complexity?
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int ans = 1;
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return ans;
        int [] dp = new int [nums.length];
        Arrays.fill(dp, 1);
        for(int i = 1; i<nums.length; i++) {
            for(int j = 0; j<i;j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    ans = Math.max(ans, dp[i]);
                }
            }
        }
        return ans;
    }
}
