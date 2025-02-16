package src.question515;

import java.time.temporal.Temporal;
import java.util.*;

/**
 515. 在每个树行中找最大值
 中等
 相关标签
 相关企业
 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。

 示例1：


 输入: root = [1,3,2,5,3,null,9]
 输出: [1,3,9]
 示例2：

 输入: root = [1,2,3]
 输出: [1,3]


 提示：

 二叉树的节点个数的范围是 [0,104]
 -231 <= Node.val <= 231 - 1
 */
public class LeetCode515 {

    public static void main(String[] args) {

        Solution solution = new Solution();

        /*TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(0, "A");
        treeMap.put(1, "A");
        treeMap.put(2, "A");
        treeMap.put(3, "A");
        treeMap.put(2, "B");

        treeMap.forEach((k,v) -> {
            System.out.println(k + "" + v);
        });*/
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        System.out.println(solution.largestValues(root));

        // 解2

        Solution solution2 = new Solution();
        System.out.println(solution2.largestValues(root));
    }
}
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        fun(root, treeMap, 0);
        treeMap.forEach((k,v) -> list.add(v));
        return list;
    }

    public void fun(TreeNode root, TreeMap<Integer, Integer> treeMap, int level) {
        if (root == null) {
            return;
        }
        treeMap.put(level, Math.max(root.val, treeMap.getOrDefault(level, Integer.MIN_VALUE)));
        fun(root.left, treeMap, level + 1);
        fun(root.right, treeMap, level + 1);
    }
}

class Solution2 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        fun(root, list, 0);
        return list;
    }

    public void fun(TreeNode root, List<Integer> list, int level) {
        if (root == null) {
            return;
        }
        if (list.size() <= level) {
            list.add(root.val);
        } else {
            list.set(level, Math.max(root.val, list.get(level)));
        }
        fun(root.left, list, level + 1);
        fun(root.right, list, level + 1);
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