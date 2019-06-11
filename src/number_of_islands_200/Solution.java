package number_of_islands_200;

/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is
 formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
 */
public class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        if(grid == null || grid.length == 0) return ans;
        for(int i = 0; i<grid.length;i++) {
            for(int j = 0; j<grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    //System.out.println("plus 1: " + i + " "+ j);
                    ans++;
                    bfs(grid, i, j);
                }
            }
        }
        return ans;
    }
    public void bfs(char [][]grid, int i, int j) {
        //up
        if(i > 0) {
            if(grid[i-1][j] == '1') {
                for(char[] cs : grid)
                {
                    for(char c : cs) {
                        System.out.printf("%c ",c);
                    }
                    System.out.println();
                }
                System.out.println();
                grid[i-1][j] = '0';
                bfs(grid, i-1, j);
            }
        }
        //left
        if(j >= 1) {
            if(grid[i][j-1] == '1') {
                for(char[] cs : grid)
                {
                    for(char c : cs) {
                        System.out.printf("%c ",c);
                    }
                    System.out.println();
                }
                System.out.println();
                grid[i][j-1] = '0';
                bfs(grid, i, j-1);
            }
        }
        //down
        if(i<grid.length -1) {
            if(grid[i+1][j] == '1') {
                for(char[] cs : grid)
                {
                    for(char c : cs) {
                        System.out.printf("%c ",c);
                    }
                    System.out.println();
                }
                System.out.println();
                grid[i+1][j] = '0';
                bfs(grid, i+1, j);
            }
        }
        //right
        if(j<grid[0].length -1) {
            if(grid[i][j+1] == '1') {
                for(char[] cs : grid)
                {
                    for(char c : cs) {
                        System.out.printf("%c ",c);
                    }
                    System.out.println();
                }
                System.out.println();
                grid[i][j+1] = '0';
                bfs(grid, i, j+1);
            }
        }
    }
    public static void main(String [] args) {
        char [][] test = new char [][] {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        char [][] test2 = new char [][] {
                {'1','1','1'},
                {'0','1','0'},
                {'1','1','1'}
        };
        Solution solution = new Solution();
       // System.out.println(solution.numIslands(test));
        System.out.println(solution.numIslands(test2));
    }
}
