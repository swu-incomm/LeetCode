package merge_two_binary_trees_617;

/*
Given two binary trees and imagine that when you put one of them to cover the other,
some nodes of the two trees are overlapped while the others are not.
You need to merge them into a new binary tree. The merge rule is that if two nodes overlap,
then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return null;
        int sum = (t1 != null ? t1.val : 0) + (t2 != null ? t2.val :0);
        TreeNode newNode = new TreeNode(sum);
        newNode.left = mergeTrees(t1 != null ? t1.left : null,t2 != null ? t2.left : null);
        newNode.right = mergeTrees(t1 != null ? t1.right : null,t2 != null ? t2.right : null);
        return newNode;
    }
}
