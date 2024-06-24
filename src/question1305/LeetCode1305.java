package src.question1305;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 1305. 两棵二叉搜索树中的所有元素
 * https://leetcode.cn/problems/all-elements-in-two-binary-search-trees/description/
 * 中等
 * 给你 root1 和 root2 这两棵二叉搜索树。请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。.
 * 示例 1：
 *
 * 输入：root1 = [2,1,4], root2 = [1,0,3]
 * 输出：[0,1,1,2,3,4]
 * 示例 2：
 *
 * 输入：root1 = [1,null,8], root2 = [8,1]
 * 输出：[1,1,8,8]
 *
 * 提示：
 *
 * 每棵树的节点数在 [0, 5000] 范围内
 * -105 <= Node.val <= 105
 */
public class LeetCode1305 {
    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();


        System.out.println(list.poll());
        System.out.println(list);

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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<>();
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        fun(root1, list1);
        fun(root2, list2);
        while (list1.size() >0 || list2.size() > 0) {
            Integer num1 = list1.peek();
            Integer num2 = list2.peek();
            if (num1 != null && num2 != null) {
                if (num1 < num2) {
                    list.add(list1.pop());
                } else {
                    list.add(list2.pop());
                }
            }
            if (num1 == null && num2 != null) {
                list.add(list2.pop());
            }
            if (num1 != null && num2 == null) {
                list.add(list1.pop());
            }
        }
        return list;
    }

    public void fun(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        fun (root.left, list);
        list.add(root.val);
        fun (root.right, list);
    }
}