package find_the_duplicate_number_287;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Example 1:

Input: [1,3,4,2,2]
Output: 2
Example 2:

Input: [3,1,3,4,2]
Output: 3
Note:

You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.
 */
public class Solution {
    //如果是找missing number 则可以用将对应下标的元素赋值为负数的方法
    //appraoch1 set
    public int findDuplicateSet(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<Integer>();
        for(int i : nums) {
            if(!set.contains(i)) {
                set.add(i);
                continue;
            }
            return i;
        }
        return 0;
    }

    //Sort
    public int findDuplicateSort(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        for(int i = 1; i<nums.length; i++) {
            if(nums[i] == nums[i-1])
            return nums[i];
        }
        return 0;
    }

    public static void main(String [] args) {
        int [] test = new int [] {
             3,1,3,4,2
        };
        Solution solution = new Solution();
        System.out.println(solution.findDuplicateSort(test));
    }
}
