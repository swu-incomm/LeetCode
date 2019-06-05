package find_first_and_last_position_of_element_in_sorted_array_34;
/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = -1, end = -1;
        for(int i = 0; i<nums.length; i++) {
            if(nums[i] == target) {
                start = i;
                end = i;
                break;
            }
        }
        for(int i = start + 1; i<nums.length;i++) {
            if(nums[i] == target) end++;
            else break;
        }
        int [] ans = new int [] {start, end};
        return ans;
    }
}
