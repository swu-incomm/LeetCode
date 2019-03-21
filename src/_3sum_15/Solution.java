package _3sum_15;

import java.util.*;
/*
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        if(nums == null || nums.length < 3) return ans;
        
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length-2;i++) {
            if(i == 0 || (i>0 && nums[i] != nums[i-1])) {
                int j = i+1;
                int k = nums.length-1;
                while(j < k) {
                    if(nums[j] + nums[k] + nums[i] == 0) {
                        List<Integer> subAns = new ArrayList<>();
                        subAns.add(nums[i]);
                        subAns.add(nums[j]);
                        subAns.add(nums[k]);
                        ans.add(subAns);
                        while(j<k && nums[j] == nums[j+1]) {j++;}
                        while(j<k && nums[k] == nums[k-1]) {k--;}
//                        while(((nums[j] == nums[j+1]) && (j<k))) {j++;}
//                        while(((nums[k] == nums[k-1]) && (j<k))) {k--;}
                        j++;
                        k--;
                    } else if(nums[j] + nums[k] + nums[i] < 0) j++;
                    else k--;
                }
            }
        }   
        return ans;
    }
    public static void main(String [] args) {
        int [] test = new int [] {
            -1, 0, 1, 2, -1, -4 
        } ;
        int [] test2 = new int [] {
            0,0,0
        };
        Solution solution = new Solution();
        List<List<Integer>> testRes = solution.threeSum(test2);       
        for(List<Integer> list : testRes) {
            for(int i : list) {
                System.out.printf("%d ", i);
            }
            System.out.println();
        }
    }
}
