package binary_tree_inorder_traversal_94;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3
Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?
The in put will be the root node

Recursive way: 
Time complexity : O(n)O(n). The time complexity is O(n)O(n) 
*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
public class solution {
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> ans = new ArrayList<>();
//        if(root == null) return ans;
//        helper(root, ans);
//        return ans;
//    }
//    private void helper(TreeNode root, List<Integer> ans) {
//        if(root != null) {
//            if(root.left != null) helper(root.left, ans);
//            ans.add(root.val);
//            if(root.right != null) helper(root.right, ans);
//        }
//    }
    //left root right
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        while(curNode!= null || !stack.isEmpty()) {
            while(curNode!=null) {
                stack.add(curNode);
                curNode = curNode.left;
            }
            //make sure curNode is not null and also the right one on top of the stack
            curNode = stack.pop();
            ans.add(curNode.val);
            curNode = curNode.right;
        }
        return ans;
    }
}
