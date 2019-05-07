package symmetric_tree_101;

/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3


But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3


Note:
Bonus points if you could solve it both recursively and iteratively.
 */
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
public class Solution {
     //Recursive
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return checkSymmetric(root.left, root.right);
    }
    private boolean checkSymmetric(TreeNode l, TreeNode r) {
        if(l == null && r == null) return true;
        if(l == null || r == null) return false;
        if(l.val != r.val) return false;
        if(!(checkSymmetric(l.left, r.right) && checkSymmetric(l.right, r.left))) return false;
        return true;
    }
}