package happy_number_202;

import java.util.HashMap;

/*
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example:

Input: 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
 */
public class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    int count = 0;
    public boolean isHappy(int n) {
        if(n == 1) return true;
        if(map.containsKey(n)) return false;
        map.put(n, count);
        count++;
        int sum = 0;
        while(n != 0) {
            sum += Math.pow((n%10), 2);
            n /=10;
        }
        System.out.println(sum);
        return isHappy(sum);
    }

    public static void main(String [] args) {
        Solution solution = new Solution();
        System.out.println(solution.isHappy(19));
    }
}
