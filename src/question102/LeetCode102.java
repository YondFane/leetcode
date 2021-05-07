package src.question102;


import java.util.ArrayList;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
 *
 * @Author: YFAN
 * @Date: 2021/5/7/007
 * <p>
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层序遍历结果：
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class LeetCode102 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(123);
        root.right = new TreeNode(1234);
        root.left.left = new TreeNode(22);
        root.left.left = new TreeNode(33);
        for (List<Integer> list : solution.levelOrder(root)) {
            System.out.println(list.toString());
        }
    }
}

/**
 * 执行用时：
 * 0 ms
 * , 在所有 Java 提交中击败了
 * 100.00%
 * 的用户
 * 内存消耗：
 * 38.7 MB
 * , 在所有 Java 提交中击败了
 * 42.87%
 * 的用户
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        levelOrder(root, list, 0);
        return list;
    }

    // 递归 通过level来判断遍历到二叉树哪一层再进行添加节点值
    public void levelOrder(TreeNode root, List<List<Integer>> list, int level) {
        if (root != null) {
            List<Integer> levelList = null;
            // 获取当前层的levelList第一次访问则初始化levelList
            if (list.size() > level) {
                levelList = list.get(level);
            } else {
                levelList = new ArrayList<>();
                list.add(levelList);
            }
            levelList.add(root.val);
            levelOrder(root.left, list, level + 1);
            levelOrder(root.right, list, level + 1);
        }
    }
}