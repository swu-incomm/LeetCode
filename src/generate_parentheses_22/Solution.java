package generate_parentheses_22;

import java.util.ArrayList;
import java.util.List;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */
public class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if(n == 0) return ans;
        backtrack("",0,0,n);
        return ans;
    }
    public void backtrack(String cur, int open, int close, int max) {
        if(cur.length() == max * 2) {
            ans.add(cur);
            return;
        }
        //the rules will be open brackets first and then close brackets
        if(open < max) {
            backtrack(cur+"(", open +1, close, max);
        }
        if(close < open) {
            backtrack(cur+")", open, close+1, max);
        }
    }
    public static void main(String [] args) {
        Solution solution = new Solution();
        List<String> result = solution.generateParenthesis(3);
        for(String s : result) {
            System.out.println(s);
        }
    }
}
