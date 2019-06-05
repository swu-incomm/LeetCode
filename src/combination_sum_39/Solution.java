package combination_sum_39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 */
public class Solution {

    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0) return ans;
        Arrays.sort(candidates);
        backtrack(0, target, candidates, new ArrayList<>(),0);
        return ans;
    }
    private void backtrack(int cur, int target, int [] candidates, ArrayList<Integer> curSet,int start) {
        if(cur == target) {
            ans.add(new ArrayList<Integer>(curSet));
            return;
        }
        if(cur > target) return;

        for(int i = start; i<candidates.length; i++) {
            curSet.add(candidates[i]);
            backtrack(cur+candidates[i], target, candidates,curSet,i);
            curSet.remove(curSet.size()-1);
        }
    }
    public static void main(String [] args) {
        Solution solution = new Solution();
        int [] candidates = new int [] {
          2,3,5
        };
        List<List<Integer>> result = solution.combinationSum(candidates, 8);
        if(result == null) System.out.println("empty result");
        for(int i = 0;i<result.size();i++) {
            for(int j = 0; j<result.get(i).size();j++) {
                System.out.printf("%d ", result.get(i).get(j));
            }
            System.out.println();
        }
    }
}
