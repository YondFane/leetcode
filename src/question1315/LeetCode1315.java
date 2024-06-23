package src.question1315;

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