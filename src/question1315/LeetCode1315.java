package src.question1315;

/**
 1315. 祖父节点值为偶数的节点和
 给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：

 该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）
 如果不存在祖父节点值为偶数的节点，那么返回 0 。

 示例：

 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 输出：18
 解释：图中红色节点的祖父节点的值为偶数，蓝色节点为这些红色节点的祖父节点。

 提示：

 树中节点的数目在 1 到 10^4 之间。
 每个节点的值在 1 到 100 之间。
 */
public class LeetCode1315 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        TreeNode root = new TreeNode(6);
        TreeNode copyRoot = root;
        copyRoot.left = new TreeNode(7);
        copyRoot.left.left = new TreeNode(2);
        copyRoot.left.right = new TreeNode(7);
        copyRoot.left.left.left = new TreeNode(9);
        copyRoot.left.right.left = new TreeNode(1);
        copyRoot.left.right.right = new TreeNode(4);

        copyRoot.right = new TreeNode(8);
        copyRoot.right.left = new TreeNode(1);
        copyRoot.right.right = new TreeNode(3);
        copyRoot.right.right.right = new TreeNode(5);

        System.out.println(solution.sumEvenGrandparent(root));
    }
}


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        return function(root, root.val % 2 ==0);
    }

    public int function(TreeNode root, boolean flag) {
        if (root == null) {
            return 0;
        }
        int num = 0;
        if (root.left != null) {
            num += function(root.left, root.left.val %2==0);
            if (flag && root.left.left != null) {
                num += root.left.left.val;
            }
            if (flag && root.left.right != null) {
                num += root.left.right.val;
            }
        }
        if (root.right != null) {
            num += function(root.right, root.right.val %2==0);
            if (flag && root.right.left != null) {
                num += root.right.left.val;
            }
            if (flag && root.right.right != null) {
                num += root.right.right.val;
            }
        }
        return num;
    }
}