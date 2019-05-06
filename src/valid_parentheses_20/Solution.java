package valid_parentheses_20;

import java.util.Stack;

/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<> ();
        for(char c : s.toCharArray()) {
            if(c == '{' || c=='[' || c=='(') stack.push(c);
            else if(stack.isEmpty()) return false;
            else if(c == '}') {
                char temp = stack.pop();
                if(temp !='{') return false;
            }
            else if(c == ']') {
                char temp = stack.pop();
                if(temp !='[') return false;
            }
            else if(c == ')') {
                char temp = stack.pop();
                if(temp !='(') return false;
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
    public static void main(String [] args) {
        String test = "{[[()()]}";
        Solution solution = new Solution();
        System.out.println(solution.isValid(test));
    }
}
