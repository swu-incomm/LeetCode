package single_number_136;

/*
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4
 */
import java.util.*;
public class Solution {
    //Solution 1 XOR
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i : nums) {
            ans = ans ^ i;
        }
        return ans;
    }

    //Solution 2, hash map
    public int singleNumberMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;

        for(int i = 0;i<nums.length;i++) {
            if(map.containsKey(nums[i])) {
                map.remove(nums[i]);
            } else {
                map.put(nums[i], i);
            }
        }
        for(int i : map.keySet()) {
            ans = i;
        }
        return ans;
    }

}
