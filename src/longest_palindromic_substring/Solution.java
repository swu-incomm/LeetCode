package longest_palindromic_substring;
/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
 */
public class Solution {
    //expand center
    public String longestPalindrome(String s) {
        String ans = "";
        if(s == null || s.length() == 0) return ans;
        int maxLenth = 0;
        for(int i = 0;i<s.length();i++) {
            int len1 = helper(s, i, i);
            int len2 = helper (s, i, i+1);
            int len = Math.max(len1, len2);
            //System.out.println(i + " **** " + len);
            if(len > maxLenth) {
                ans = s.substring(i-(len -1 )/2 , i+len/2+1);
                //System.out.println(ans);
                maxLenth = len;
            }
        }
        return ans;
    }

    public int helper(String s, int i, int j) {
        while(i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        //System.out.println(i + " "+ j);
        //j 和 i 分别多加了 和多减了 1 位
        return j - i - 1;
    }

    public static void main(String [] args) {
        Solution solution = new Solution();
        //solution.helper("babad", 1, 1);
        solution.longestPalindrome("babad");
        System.out.println("babad".substring(0,2));
    }

    //dynamic programming

}
