package move_zeros_283;

/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 */
public class Solution {
    //Wrong answer because the position of the elements changed
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length <2) return;
        int left = 0, right = nums.length-1;
        while(left < right) {
            while((nums[left] != 0) && left < right) {
                left++;
            }
            while((nums[right] == 0) && left < right) {
                right--;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        for(int i : nums) {
            System.out.println(i);
        }
    }
    //fill all the position with non-zeros number from beginning, then put all te rest places as zeros
    public void moveZeroes2(int[] nums) {
        if(nums == null || nums.length <2) return;
        int j = 0;
        for(int i = 0; i< nums.length;i++) {
            if(nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for(int i = j;i<nums.length;i++) {
            nums[i] = 0;
        }
        for(int i : nums) {
            System.out.println(i);
        }
    }

    //swap non-zeros values with zeros values in position
    public void moveZeroes3(int[] nums) {
        if(nums == null || nums.length <2) return;
        //j will stays as the last 0 needs to be moved to the rare of the array
        int j = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }

    }
    public static void main(String [] args) {
        int [] test = new int[] {
          0,1,0,3,12
        };
        Solution solution = new Solution();
        solution.moveZeroes2(test);
    }
}
