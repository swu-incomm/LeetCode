package next_permutation_31;
/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 */
public class Solution {
    public void nextPermutation(int[] nums) {

        if(nums == null || nums.length == 0) return;
        int p = -1, q = -1;

        for(int i = nums.length -2; i>=0;i--) {
            if(nums[i] < nums[i + 1]) {
                p = i;
                break;
            }
        }

        if(p == -1) {
            reverse(nums, 0, nums.length-1);
            return;
        }

        for(int i = nums.length -1; i>=0;i--) {
            if(nums[i] > nums[p]) {
                q = i;
                break;
            }
        }
        System.out.println(p + " " + q);
        swap(nums, p, q);
        reverse(nums, p +1 , nums.length-1);
        return;

    }

    public void swap(int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int [] nums, int i, int j) {
        while(i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void main(String [] args) {
        int [] test = new int [] {
                2 ,3,1
        };
        Solution solution = new Solution();
        solution.nextPermutation(test);
    }
}

