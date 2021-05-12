package src.question404;

/**
 * 404. 左叶子之和
 *
 * @Description:
 * @Author: YFAN
 * @Date: 2021/5/12/012
 * 计算给定二叉树的所有左叶子之和。
 * 示例：
 *  3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 */
public class LeetCode404 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(solution.sumOfLeftLeaves(root));
    }
}

class Solution {
    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        fun(root);
        return sum;
    }

    public void fun(TreeNode root) {
        if (root != null) {
            if (root.left != null && root.left.left==null && root.left.right == null) {
                sum += root.left.val;
            }
            fun(root.left);
            fun(root.right);
        }
    }
}