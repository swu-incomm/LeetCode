package flatten_binary_tree_to_linked_list_114;

import java.util.Stack;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class Solution {
    public void flattenIterative(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if(cur.right != null) stack.push(cur.right);
            if(cur.left != null) stack.push(cur.left);
            if(!stack.isEmpty()) {
                cur.right = stack.peek();
                cur.left = null;
            }
        }
    }

    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}