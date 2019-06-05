package permutations_46;

import java.util.ArrayList;
import java.util.List;

/*
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */
public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0) {
            return ans;
        }
        backtrack(new ArrayList<>(), nums);
        return ans;
    }
    public void backtrack(ArrayList<Integer> subList, int [] nums) {
        if(subList.size() == nums.length) {
            ans.add(new ArrayList<>(subList));
            return;
        }

        for(int i = 0; i< nums.length; i++) {
            if(subList.contains(nums[i])) continue;
            subList.add(nums[i]);
            backtrack(subList, nums);
            subList.remove(subList.size()-1);
        }
    }
    public static void main(String [] args) {
        int [] test = new int []{1,2,3};
        Solution solution = new Solution();
        List<List<Integer>> res = solution.permute(test);
        for(int i = 0;i<res.size();i++) {
            for(int j = 0; j<res.get(i).size();j++) {
                System.out.printf("%d ", res.get(i).get(j));
            }
            System.out.println();
        }
    }
}
