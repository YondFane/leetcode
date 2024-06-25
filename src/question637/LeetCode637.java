package src.question637;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 637. 二叉树的层平均值
 给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。

 示例 1：

 输入：root = [3,9,20,null,null,15,7]
 输出：[3.00000,14.50000,11.00000]
 解释：第 0 层的平均值为 3,第 1 层的平均值为 14.5,第 2 层的平均值为 11 。
 因此返回 [3, 14.5, 11] 。
 示例 2:

 输入：root = [3,9,20,15,7]
 输出：[3.00000,14.50000,11.00000]
 */
public class LeetCode637 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(7);

        root.left.left.left = new TreeNode(6);

        System.out.println(solution.averageOfLevels(root));

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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> doubles = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.poll();
                sum+= t.val;
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
            doubles.add(sum/size);
        }
        return doubles;
    }
}