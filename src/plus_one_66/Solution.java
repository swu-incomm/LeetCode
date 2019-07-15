package plus_one_66;
/*
Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element
 in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) return null;
        for(int i = 0; i<digits.length;i++) {
            if(digits[i] != 9) break;
            else if(digits[i] == 9 && i == digits.length -1) {
                int [] ans1 = new int [digits.length + 1];
                ans1[0] = 1;
                return ans1;
            }
        }

        for(int i = digits.length-1; i>=0;i--) {
            if(digits[i] != 9) {
                digits[i] ++;
                return digits;
            }
            digits[i] = 0;
        }
        return null;
    }
}
