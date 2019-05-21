package find_all_numbers_disappeared_in_an_array_448;
/*
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
 */
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> ans = new ArrayList<>();

        if(nums == null || nums.length == 0) return ans;

        for(int i= 0;i<nums.length;i++) {
            int temp = Math.abs(nums[i])-1;
            nums[temp] = Math.abs(nums[temp]) * (-1);
        }
        for(int i = 0;i<nums.length;i++) {
            if(nums[i] > 0) {
                ans.add(i+1);
            }
        }
        for(int i = 0;i<ans.size();i++)
            System.out.println(ans.get(i));
        return ans;
    }
    public static void main(String [] args) {
        int [] test = new int [] {
          4,3,2,7,8,2,3,1
        };
        Solution solution = new Solution();
        solution.findDisappearedNumbers(test);
    }
}
