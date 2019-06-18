package word_search_79;

/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or
 vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 */

//搜索 方法 没什么多说的
public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || word == null || word.length() == 0) return false;
        char [] chars = word.toCharArray();
        for(int i = 0; i< board.length;i++) {
            for(int j = 0; j<board[0].length; j++) {
                if(exist(board, chars, 0, i, j)) {
                     return true;
                }
            }
        }
        return false;
    }
    public boolean exist(char[][] board, char [] chars, int index, int i, int j) {
        if(index == chars.length) {
            return true;
        }
        if(i >= board.length || i < 0 || j<0 || j >= board[0].length) return false;

        if(board[i][j] != chars[index]) return false;

        board[i][j] ^= 256;
        boolean res =exist(board, chars, index +1 , i +1 ,j) || exist(board, chars, index +1 , i -1 ,j) ||
                exist(board, chars, index +1 , i ,j +1) || exist(board, chars, index +1 , i  ,j-1);
        board[i][j] ^= 256;
        return res;
    }
}
