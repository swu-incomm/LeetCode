package word_ladder_127;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/*
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest
 transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class Solution {
    //    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//
//    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || beginWord.length() == 0 || endWord.length() == 0 || beginWord.length() != endWord.length())
            return 0;

        LinkedList<String> wordQueue = new LinkedList<String>();
        int level = 1; //the start string already count for 1
        int curnum = 1;//the candidate num on current level
        int nextnum = 0;//counter for next level

        wordQueue.add(beginWord);

        while (!wordQueue.isEmpty()) {
            String word = wordQueue.poll();
            curnum--;

            for (int i = 0; i < word.length(); i++) {
                char[] wordunit = word.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    wordunit[i] = j;
                    String temp = new String(wordunit);

                    if (temp.equals(endWord))
                        return level + 1;
                    if (wordList.contains(temp)) {
                        wordQueue.add(temp);
                        nextnum++;
                        wordList.remove(temp);
                    }
                }
            }

            if (curnum == 0) {
                curnum = nextnum;
                nextnum = 0;
                level++;
            }
        }

        return 0;
    }
}
