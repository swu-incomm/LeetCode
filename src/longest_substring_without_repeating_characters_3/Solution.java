package longest_substring_without_repeating_characters_3;

import java.util.HashMap;

/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0,j = 0;j<s.length();j++) {
            if(map.containsKey(s.charAt(j))) {
                //map will store each character's latest position to the right
                //Math.max() makes sure every time you place the i at the correct place and you won't compare i with the i that  is in the map but
                //not in our current string from [i,j]
                i = Math.max(i, map.get(s.charAt(j))+1);
            }
            map.put(s.charAt(j), j);
            max = Math.max(max, j-i+1);
        }
        return max;
    }
}
