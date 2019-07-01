package house_robber_III_337;
/*
The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root."
Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place
 forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:

Input: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \
     3   1

Output: 7
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:

Input: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \
 1   3   1

Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 */

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

public class Solution {
    public int rob(TreeNode root) {
        return Math.max(dfsDp(root)[0], dfsDp(root)[1]);
    }

    public int [] dfsDp(TreeNode root) {
        if(root == null) return new int [2];
        int [] result = new int [2];
        int [] left = dfsDp(root.left);
        int [] right = dfsDp(root.right);
        result[0] = Math.max(left[0],left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] +right[0] + root.val;

        return result;
    }
}