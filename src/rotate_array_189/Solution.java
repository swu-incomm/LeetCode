package rotate_array_189;

/*
Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
Note:

Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <=0) return;
      k = k % nums.length;
      reverse(nums, 0, nums.length-k-1);
      reverse(nums, nums.length-k, nums.length-1);
      reverse(nums, 0, nums.length-1);
      for(int i : nums) {
          System.out.println(i);
      }
    }

    public void reverse (int [] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end--;
        }
//        for(int i : nums) {
//            System.out.println(i);
//        }
    }

    public static void main(String [] args) {
        Solution solution = new Solution();
        int [] test = new int [] {
                1, 2, 3, 4, 5, 6, 7, 8, 9
        };
        solution.rotate(test, 3);
        //solution.reverse(test, 0 , 8);
    }
}
