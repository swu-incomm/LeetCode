package invert_binary_tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}
public class Solution {
    //Recursive
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        TreeNode node = new TreeNode(root.val);

        node.left = invertTree(root.right);
        node.right = invertTree(root.left);

        return node;
    }

    public TreeNode invertTree2(TreeNode root) {
        if(root == null) return root;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }


}
