package unique_binary_search_trees_96;
/*
Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
public class Solution {
    public int numTrees(int n) {
        if(n == 0 || n == 1) return 1;
        int [] dp = new int [n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i<=n;i++) {
            for(int j = 0; j<i;j++) {
                //accumulate sum, j stands for the left child of the node, i stands for the parent node
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
    }
}
