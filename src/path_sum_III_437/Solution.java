package path_sum_III_437;

/*
You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
//非常经典的深度优先搜索算法
class Solution {

    //给他一个节点和一个目标值，他返回以这个节点为根的树中，和为目标值的路径总数
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    //给他一个节点和一个目标值，他返回以这个节点为根的树中，能凑出几个以该节点为路径开头，和为目标值的路径总数。
    private int helper(TreeNode root, int sum) {
        if(root == null) return 0;
        //此时和达到了总数并不能停止 还因该继续递归下去，因为可能存在负数
        return (root.val == sum ? 1 : 0)+helper(root.left, sum-root.val) + helper(root.right, sum - root.val);
    }
}