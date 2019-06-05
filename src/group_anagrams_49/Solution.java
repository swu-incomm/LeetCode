package group_anagrams_49;

import java.util.*;

/*
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs == null || strs.length == 0) return res;
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i< strs.length;i++) {
            //sort each string
            char [] charArr = strs[i].toCharArray();
            Arrays.sort(charArr);
            String temp = String.copyValueOf(charArr);

            if(!map.containsKey(temp)) {
                map.put(temp, new ArrayList<String>());
            }
            map.get(temp).add(strs[i]);
        }
        for(List<String> subList : map.values()) res.add(subList);
        return res;
    }
}
