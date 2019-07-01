package word_break_139;

import java.util.Arrays;
import java.util.List;

/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine
 if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
 */
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean [] dp = new boolean [s.length()];
        if(s == null || s.length() == 0 || wordDict == null || wordDict.size() ==0) return false;
        for(int i = 0; i<wordDict.size();i++) {
            wordDict.set(i, wordDict.get(i).toLowerCase());
        }
        s=s.toLowerCase();
        //for(String i : wordDict) System.out.println(i);
        //System.out.println(s);
        if(wordDict.contains(s.substring(0,1))) dp[0] = true;
        for(int i = 1; i<s.length(); i++) {
            if(wordDict.contains(s.substring(0,i+1))) {
                dp[i] = true;
                continue;
            }
            for(int j = 0; j<i;j++) {
                if(dp[j] == true && wordDict.contains(s.substring(j+1, i+1))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        //for(boolean i : dp)
            //System.out.printf("%b ", i);
        return dp[s.length()-1];
    }
    public static void main(String [] args) {
        String test = "LeetCode";
        String [] testArray = new String [] {
                "leet", "code", "L"
        };
        List<String> list = Arrays.asList(testArray);
        //System.out.println(list.toString());
        Solution solution = new Solution();
        solution.wordBreak(test, list);
    }
}
