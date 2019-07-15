package valid_palindrome_125;

/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
 */
public class Solution {
    //Method 1, time exceed
    public boolean isPalindrome(String s) {
        if(s == null) return false;
        s = s.replaceAll("[^A-Za-z0-9]", "").trim().toLowerCase();
        return helper(s);
    }
    public boolean helper(String s) {
        if(s.equals("") || s.length() == 1) return true;
        if(s.charAt(0) != s.charAt(s.length()-1)) return false;
        return isPalindrome(s.substring(1, s.length()-1));
    }

    //Reverse a string
    public boolean isPalindromeReverse(String s) {
        if(s == null) return false;
        s = s.replaceAll("[^A-Za-z0-9]", "").trim().toLowerCase();
        String s1 = reverseString(s);
        return s.equals(s1);
    }

    public String reverseString(String s) {
        if(s.isEmpty()) {
            System.out.println("s = " + s);
            return s;
        }
        return reverseString(s.substring(1)) + s.charAt(0);
    }

    public static void main(String [] args) {
//        String test = "abcdefg";
//        System.out.println(test.substring(1, test.length()-1));
//
//        String test1 = "A man, a plan, a canal: Panama";
//        System.out.println(test1.replaceAll("[^A-Za-z0-9]", "").trim().toLowerCase());
        String test = "A man";
        Solution solution = new Solution();
        System.out.println();
        solution.isPalindrome(test);
        //substring(begin index) will go less than or equal to the length of the string
        String s1 = "a";
        System.out.println(solution.reverseString(s1));
    }
}
