package subsets_78;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Solution {
    /*
    Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
     */
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        backtrack(new ArrayList<Integer>(), nums, 0);
        return res;
    }
    public void backtrack(List<Integer> sub, int[] nums, int start) {
        res.add(new ArrayList(sub));
        for(int i = start; i<nums.length; i++) {
            sub.add(nums[i]);
            backtrack(sub, nums, i+1);
            sub.remove(sub.size()-1);
        }
    }
}
