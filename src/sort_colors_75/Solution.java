package sort_colors_75;
/*
Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors
 in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Follow up:

A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with a one-pass algorithm using only constant space?
 */
public class Solution {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length-1, i=0;
        while(i<=right) {
            System.out.println(left+" "+right+" "+nums[i]);
            if(nums[i] == 0) {
                swap(nums, i, left);
                left++;
            }
            if(nums[i] == 2) {
                swap(nums, i, right);
                --i;
                right--;
            }
            i++;
        }
        for(int n : nums) {
            System.out.printf("%d ", n);
        }

    }
    public void swap(int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    //two pass
    public void sortColors2Pass(int[] nums) {

        int redCount = 0, whiteCount = 0, blueCount = 0;

        for(int i = 0; i<nums.length; i++) {
            switch (nums[i]) {
                case 0: redCount++;break;
                case 1: whiteCount++; break;
                case 2: blueCount++; break;
            }
        }

        for(int i = 0; i< nums.length; i++) {
            if(redCount > 0) {
                nums[i] = 0;
                redCount--;
                continue;
            }
            if(whiteCount > 0) {
                nums[i] =1;
                whiteCount--;
                continue;
            }
            nums[i]=2;
        }
        for(int i : nums) {
            System.out.printf("%d ", i);
        }

    }
    public static void main (String [] args) {
        int [] test = new int[] {
                2,0,2,1,1,0
        };
        int [] test1 = new int [] {
                2,0,1
        };
        Solution solution = new Solution();
        //solution.sortColors2Pass(test);
        //System.out.println();
        //solution.sortColors(test);
        solution.sortColors(test1);
    }
}
