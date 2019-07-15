package missing_number_268;

/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1:

Input: [3,0,1]
Output: 2
Example 2:

Input: [9,6,4,2,3,5,7,0,1]
Output: 8
Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
public class Solution {
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int sum = (1 + nums.length) * nums.length/2;
        int realSum = 0;
        for(int i : nums) {
            realSum+=i;
        }
        return sum-realSum;
    }
}
