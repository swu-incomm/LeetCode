package validate_binary_search_tree_98;
/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.


Example 1:

    2
   / \
  1   3

Input: [2,1,3]
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    //wrong solution, this one doesn't consider the upper and lower bound for each left and right sub-tree
    public boolean isValidBSTWrong(TreeNode root) {
        if(root == null) return true;
        if(root.left != null && root.val <= root.left.val) return false;
        if(root.right != null && root.val >= root.right.val) return false;
        return (isValidBSTWrong(root.left) && (isValidBSTWrong(root.right)));
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    public boolean helper(TreeNode root, long upper, long lower) {
        if(root == null) return true;
        if(root.val >= upper || root.val <= lower) return false;
        return helper(root.left, root.val, lower) && helper(root.right, upper, root.val);
    }
}