package excel_column_number_171;

/*
Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28

    ...
Example 1:

Input: "A"
Output: 1
Example 2:

Input: "AB"
Output: 28
Example 3:

Input: "ZY"
Output: 701
 */
public class Solution {

    public int titleToNumber(String s) {
        int sum = 0;
        if(s == null || s.length() == 0) return sum;
        for(int i = 0; i<s.length();i++) {
            sum = sum * 26 + s.charAt(i) - 'A' + 1;
            System.out.printf("%d ", sum);
        }
        return sum;
    }

    public static void main(String [] args) {
        Solution solution = new Solution();
        solution.titleToNumber("AB");
    }
}
