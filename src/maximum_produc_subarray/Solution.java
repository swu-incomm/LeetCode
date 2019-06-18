package maximum_produc_subarray;

/*
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class Solution {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        if(nums == null || nums.length == 0) return ans;
        int [] dpMax = new int [nums.length];
        int [] dpMin = new int [nums.length];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        if(dpMax[0]>ans) ans = dpMax[0];
        for(int i = 1; i< nums.length; i++) {
            dpMax[i] = Math.max(Math.max(nums[i], nums[i] * dpMax[i-1]), nums[i]*dpMin[i-1]);
            //used for keep record of the negative productions
            dpMin[i] = Math.min(Math.min(nums[i], nums[i] * dpMax[i-1]), nums[i]*dpMin[i-1]);
            if(dpMax[i] > ans) ans = dpMax[i];
            System.out.println(ans);
        }
        return ans;
    }
    public static void main(String [] args) {
        Solution solution = new Solution();
        int [] test = new int [] {
          2,-1,1,1
        };
        solution.maxProduct(test);
    }
}
