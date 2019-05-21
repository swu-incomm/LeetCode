package shortest_unsorted_continuous_subarray_581;

import java.util.Stack;

/*
Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order,
then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Note:
Then length of the input array is in range [1, 10,000].
The input array may contain duplicates, so ascending order here means <=.
 */
public class Solution {
    //Solution 1, using stack, time: O(n), space:O(n)
    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int l = nums.length, r = 0;
        for(int i=0;i<nums.length;i++) {
            while(!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                l = Math.min(l, stack.pop());
            }
            stack.push(i);
        }
        stack.clear();

        for(int i = nums.length-1;i>=0;i--) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                r = Math.max(r, stack.pop());
            }
            stack.push(i);
        }
        return r-l > 0 ? r - l + 1 : 0;
    }
    //re-write of solution 1
    public int findUnsortedSubarray1(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int l = nums.length, r = 0;
        //find most left index
        for(int i=0;i<nums.length;i++) {
            if(!stack.isEmpty()) {
                if(nums[stack.peek()] > nums[i]) {
                    while(!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                        stack.pop();
                    }
                    if(stack.isEmpty()) {l = 0; break;}
                    //We need to go through the whole array to find the most little index
                    else {l = Math.min(stack.peek() +1, l);}
                }
            }
            stack.push(i);
        }
        stack.clear();
        for(int i = nums.length-1;i>=0;i--) {
            if(!stack.isEmpty()) {
                if(nums[stack.peek()] < nums[i]) {
                    while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                        stack.pop();
                    }
                    if(stack.isEmpty()) {r = nums.length -1;break;}
                    //we nned to go through the whole array to find the most max index
                    else {r = Math.max(stack.peek()-1, r);}
                }
            }
            stack.push(i);
        }
        //System.out.println(l);
        //System.out.println(r);
        return r-l+1 > 0 ? r-l+1 : 0;
    }

    public int findUnsortedSubarray2(int[] nums) {
        int l = nums.length, r = 0;
        for(int i= 0;i<nums.length;i++) {
            for(int j= i+1; j< nums.length;j++) {
                if(nums[i] > nums[j]) {
                    l = Math.min(l, i);
                    r = Math.max(r, j);
                }
            }
        }
        return r-l+1 > 0 ? r-l+1 : 0;
    }

    public static void main(String [] args) {
        int [] test = new int [] {
                2,6,4,8,10,9,15
        };
        int [] test1 = new int [] {
                1,2,3,4
        };
        int [] test2 = new int [] {
                3,2,3,2,4
        };
        int [] test3 = new int[] {
                1,3,5,4,2
        };
        Solution solution = new Solution();
        System.out.println(solution.findUnsortedSubarray1(test));
        System.out.println(solution.findUnsortedSubarray1(test1));
        System.out.println(solution.findUnsortedSubarray1(test2));
        System.out.println(solution.findUnsortedSubarray1(test3));
    }
}
