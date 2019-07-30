package surrounded_regions_130;
import java.util.*;

/*
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'.
 Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are
  connected if they are adjacent cells connected horizontally or vertically.
  思路是从四个边的O入手， 并进行广度优先的搜索， 将搜到的O全部变成+号， 然后将所有剩下的O变为X， 将+号变回O
 */
public class Solution {
    class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;

        int m = board.length;
        int n = board[0].length;

        Queue<Point> queue = new LinkedList<>();

        for(int i = 0; i<m; i++) {
            if(board[i][0] == 'O') {
                queue.offer(new Point(i, 0));
                board[i][0] = '+';
            }
            if(board[i][n-1] == 'O') {
                queue.offer(new Point(i, n-1));
                board[i][n-1] = '+';
            }
        }
        for(int i = 0; i<n; i++) {
            if(board[0][i] == 'O') {
                queue.offer(new Point(0, i));
                board[0][i] = '+';
            }
            if(board[m-1][i] == 'O') {
                queue.offer(new Point(m-1, i));
                board[m-1][i] = '+';
            }
        }

        while(!queue.isEmpty()) {
            Point temp = queue.poll();
            int row = temp.x;
            int col = temp.y;
            if(row-1 >= 0 && board[row-1][col] == 'O') {queue.offer(new Point(row-1, col));board[row-1][col] ='+';}
            if(row+1 < m && board[row+1][col] == 'O') {queue.offer(new Point(row+1, col));board[row+1][col] ='+';}
            if(col -1 >= 0 && board[row][col-1] == 'O') {queue.offer(new Point(row, col-1));board[row][col-1] ='+';}
            if(col+1 < n && board[row][col+1] == 'O') {queue.offer(new Point(row, col+1));board[row][col+1] ='+';}
        }

        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                else if(board[i][j] == '+') board[i][j] = 'O';
            }
        }
    }
}
