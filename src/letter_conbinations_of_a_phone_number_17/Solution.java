package letter_conbinations_of_a_phone_number_17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class Solution {
    HashMap<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits!= null && digits.length() != 0) {
            backtrack("", digits);
        }
        return ans;
    }
    //方法为，当conbination符合要求时，加入到结果数组中， 如果长度不够，从要求的数字串中一个一个的从hashmap中取出数字对应的字母符号， 用于组成下一个conbination，
    //并通过递归的方式进行下一轮回溯
    //此题为经典基础回溯法
    private void backtrack(String conbination, String restString){
        if(restString.length() == 0) {
            ans.add(conbination);
            return;
        }
        String selection = phone.get(restString.substring(0,1));
        for(int i = 0; i<selection.length();i++) {
            backtrack(conbination + selection.charAt(i), restString.substring(1));
        }
    }

    public static void main(String [] args) {
        String test = "23";
        Solution solution = new Solution();
        List<String> result = solution.letterCombinations(test);
        for(String s : result) {
            System.out.println(s);
        }
    }
}
