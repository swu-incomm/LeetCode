package lowest_common_ancestor_of_a_binay_tree_236;

/*
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q
as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]




Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.


Note:

All of the nodes' values will be unique.
p and q are different and both values will exist in the binary tree.
 */

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
     TreeNode(int x) { val = x; }
  }

  //结果来自于 左子树， 右子树 或者本身
 //重要条件： 所有节点不重复， 这样我们便不会出现在一条path上找到两个相同节点的情况
 //只要左子树 右子树 或者本身有两个返回 1 ， 即结果加起来为2， 则说明当前节点为答案 返回即可
public class Solution {
    TreeNode ans;
    public Solution() {
        ans = null;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }
    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return false;
        int leftSubTree = dfs(root.left ,p ,q ) ? 1 : 0;
        int rightSubTree = dfs(root.right, p, q) ? 1 : 0;
        int mid = (root.val == p.val || root.val == q.val) ? 1 : 0;

        if(leftSubTree + rightSubTree + mid >= 2) ans = root;

        return (mid + leftSubTree + rightSubTree > 0);
    }
}