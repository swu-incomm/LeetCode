package longest_common_prefix_14;

/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 */

//attension: out of index boundry when comparing
// check null or empty array for input
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans = "";
        if(strs == null || strs.length == 0) return ans;
        String s = strs[0];
        for(int i = 0; i<s.length();i++) {
            for(int j = 0; j<strs.length;j++) {
                if(i > strs[j].length() -1 || strs[j].charAt(i) != s.charAt(i)) {
                    return ans;
                }
            }
            ans +=s.charAt(i);
        }
        return ans;
    }
}
