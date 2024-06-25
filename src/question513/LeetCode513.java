package src.question513;

/**
 * 513. 找树左下角的值
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * <p>
 * 假设二叉树中至少有一个节点。
 * <p>
 * 示例 1:
 * 输入: root = [2,1,3]
 * 输出: 1
 * 示例 2:
 * 输入: [1,2,3,4,null,5,6,null,null,7]
 * 输出: 7
 * <p>
 * 提示:
 * 二叉树的节点个数的范围是 [1,104]
 * -231 <= Node.val <= 231 - 1
 */
public class LeetCode513 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(8);
        root.right.right.left.left = new TreeNode(10);

        root.left.left.left = new TreeNode(6);

        System.out.println(solution.findBottomLeftValue(root));

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}



class Solution {

    private Integer level = -1;

    private Integer result;

    public int findBottomLeftValue(TreeNode root) {
        fun(root, 0);
        return result;
    }

    private void fun(TreeNode root, int level) {
        if (root.left == null && root.right == null) {
            if (level > this.level) {
                this.level = level;
                result = root.val;
            }
        }
        if (root.left != null) {
            fun(root.left, level + 1);
        }
        if (root.right != null) {
            fun(root.right, level + 1);
        }
    }
}




class Solution2 {

    private Integer level = 0;

    private Integer result;

    public int findBottomLeftValue(TreeNode root) {
        result = root.val;
        fun(root, 0);
        return result;
    }

    private void fun(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (root.left != null && level + 1 > this.level) {
            this.level = level + 1;
            result = root.left.val;
        }
        if (root.left == null && root.right != null && level + 1 > this.level) {
            this.level = level + 1;
            result = root.right.val;
        }
        fun(root.left, level + 1);
        fun(root.right, level + 1);
    }
}