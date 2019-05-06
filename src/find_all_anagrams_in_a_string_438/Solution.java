package find_all_anagrams_in_a_string_438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

        Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

        The order of output does not matter.

        Example 1:

        Input:
        s: "cbaebabacd" p: "abc"

        Output:
        [0, 6]

        Explanation:
        The substring with start index = 0 is "cba", which is an anagram of "abc".
        The substring with start index = 6 is "bac", which is an anagram of "abc".
        Example 2:

        Input:
        s: "abab" p: "ab"

        Output:
        [0, 1, 2]

        Explanation:
        The substring with start index = 0 is "ab", which is an anagram of "ab".
        The substring with start index = 1 is "ba", which is an anagram of "ab".
        The substring with start index = 2 is "ab", which is an anagram of "ab".

 */
public class Solution {
    public List<Integer> findAnagramsBruteForce(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        if(s == null || s.length() == 0 || p == null || p.length() == 0 || p.length()>s.length()) return ans;

        int len = p.length();
        for(int i = 0; i<=s.length()-p.length();i++) {
            String temp = s.substring(i,i+len);
            //System.out.println(temp);
            if(helper(p, temp)) {
               ans.add(i);
               System.out.println(i);
            }
        }
        return ans;
    }

    private boolean helper(String a, String b) {
        char [] aStr = a.toCharArray();
        char [] bStr = b.toCharArray();
        Arrays.sort(aStr);
        Arrays.sort(bStr);
        for(int i=0;i<a.length();i++) {
            if(aStr[i] != bStr[i])
                return false;
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List <Integer> ans = new ArrayList<>();
        if(s == null || s.length() == 0 || p == null || p.length() == 0 || p.length() > s.length()) return ans;
        int [] ps = new int [26];
        for(int i = 0;i<p.length();i++) {
            ps[p.charAt(i) - 'a']++;
        }
        int count = p.length(), left = 0, right = 0;
        while(right < s.length()) {
            if(--ps[s.charAt(right++)-'a'] >= 0) count--;
            if(count == 0) {ans.add(left);System.out.println(left);}
            if((right-left) == p.length() && ps[s.charAt(left++)-'a']++ >=0) count++;
        }
        return ans;

    }
    public static void main(String [] args) {

        Solution s = new Solution();
        //s.findAnagramsBruteForce("abababe","ab");
        s.findAnagrams("abababe","ab");

    }
}
