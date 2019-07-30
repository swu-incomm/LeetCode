package palindrome_partitioning_131;

import java.util.ArrayList;
import java.util.List;

/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]

经典back trcking 解法
 */
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if(s == null || s.length() == 0) return res;
        List<String> subRes = new ArrayList<>();
        backtrack(s, 0, subRes, res);
        return res;
    }

    private void backtrack(String s, int p, List<String> subRes, List<List<String>> res) {
        if(p == s.length()) {
            res.add(new ArrayList<String>(subRes));
            return;
        }
        for(int i = p+1; i<=s.length();i++) {
            String subString = s.substring(p, i);
            if(!isPalindrome(subString)) {
                continue;
            }
            subRes.add(subString);
            backtrack(s, i, subRes, res);
            subRes.remove(subRes.size()-1);
        }
    }

    private boolean isPalindrome(String s) {
        if(s.length() == 1) return true;
        for(int i = 0; i<s.length();i++) {
            if(s.charAt(i) != s.charAt(s.length()-i-1)) return false;
        }
        return true;
    }
}
