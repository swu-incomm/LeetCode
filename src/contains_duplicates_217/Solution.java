package contains_duplicates_217;

import java.util.HashMap;

/*
Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, and it should return false if
 every element is distinct.

Example 1:

Input: [1,2,3,1]
Output: true
Example 2:

Input: [1,2,3,4]
Output: false
Example 3:

Input: [1,1,1,3,3,4,3,2,4,2]
Output: true
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length <=1) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length;i++) {
            if(map.containsKey(nums[i])) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;

    }
}
