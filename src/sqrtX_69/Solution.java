package sqrtX_69;
/*
Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since
             the decimal part is truncated, 2 is returned.
 */
public class Solution {

    //brute force
    public int mySqrt(int x) {
        if(x == 0) return 0;
        for(int i = 1; i <= x/i; i++) {
            if(i < x/i && i+1 > x/(i+1)) return i;
        }
        return 0;
    }

    //binary search
    public int mySqrtBS(int x) {
        if(x == 0) return 0;
        int left = 1, right = x;
        if(x ==1) return 1;
        while(left < right) {
            int mid = left + (right - left)/2;
            if(mid <= x/mid && mid+1 > x/(mid+1)) return mid;
            else if(mid < x/mid) left = mid;
            else right = mid;
        }
        return 0;
    }
}
