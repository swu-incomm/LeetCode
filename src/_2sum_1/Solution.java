package _2sum_1;

import java.util.Arrays;
import java.util.HashMap;


/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */
public class Solution {

    //hashmap
    public int[] twoSum(int[] nums, int target) {
        int [] ans = new int [2];
        if(nums == null || nums.length == 0) return ans;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++) {
            if(!map.containsKey(target - nums[i])) {
                map.put(nums[i], i);
            } else {
                ans[0] = map.get(target - nums[i]);
                ans[1] = i;
                break;
            }
        }
        return ans;
    }
}
