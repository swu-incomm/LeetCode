package two_sum;
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
    
    private HashMap<Integer, Integer> map;
    
    public int[] twoSum(int[] nums, int target) {
        int [] ans = new int[2];
        map = new HashMap<>();
        for(int i = 0; i< nums.length;i++) {
            if(!map.containsKey(target-nums[i])) {
                map.put(nums[i], i);
  //              System.out.println("Inspect map: " + i + " " + nums[i]);
            } else {
                ans[1] = i;
                ans[0] = map.get(target-nums[i]);
//                System.out.println("First index: " + i);
//                System.out.println("Second index: " + ans[1]);
                break;
            }
            
        }
        return ans;
    }
    public int binarySearch(int [] nums, int target, int start) {
        int end = nums.length-1;
        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            if(nums[mid] == target) return mid;
            if(nums[mid] > target) end = mid;
            else start = mid;
        }
        if (nums[start] == target) return start;
        if (nums[end] == target) return end;
        return -1;
    }
    public static void main(String [] args) {
        int [] test1 = new int [] {
          2,7,11,15  
        };
        int [] test2 = new int [] {
                3,2,4
        };
        Solution solution = new Solution();
        int [] ans = solution.twoSum(test2, 6);
        for(int num : ans)
            System.out.println(num);
    }
}