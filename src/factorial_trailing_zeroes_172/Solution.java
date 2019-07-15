package factorial_trailing_zeroes_172;

/*
Given an integer n, return the number of trailing zeroes in n!.

Example 1:

Input: 3
Output: 0
Explanation: 3! = 6, no trailing zero.
Example 2:

Input: 5
Output: 1
Explanation: 5! = 120, one trailing zero.
 */
public class Solution {
    public int trailingZeroes(int n) {
        //每一个25会多一个5， 125 会再多一个5，以此类推 所以需要递归的方式找到更多
        int result=0;
        while (n>0){
            result+=n/5;

            n/=5;
        }
        return result;
    }

    public static void main(String [] args) {
        Solution solution = new Solution();
        System.out.println(solution.trailingZeroes(3));
    }
}
