package product_of_array_except_self_238;

/*
Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product
 of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity?
 (The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class Solution {
    public int[] productExceptSelfSpace(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        int [] ans = new int [nums.length];
        int [] left = new int [nums.length];
        int [] right = new int [nums.length];
        left[0] = 1;
        right[nums.length-1] = 1;
        for(int i = 1; i<nums.length;i++) {
            left[i] = left[i-1] * nums[i-1];
        }
        for(int i = nums.length -2; i>=0;i--) {
            right[i] = right[i+1] * nums[i+1];
        }
        for(int i = 0; i<nums.length; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }
    //O(1) space
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        int [] ans = new int [nums.length];
        int r = 1;
        ans[0] = 1;
        for(int i = 1; i<nums.length;i++) {
            ans[i] = ans[i-1] * nums[i-1];
        }

        for(int i = nums.length-1; i>=0; i--) {
            ans[i] = ans[i] * r;
            r = r * nums[i];
        }
        return ans;
    }
}
