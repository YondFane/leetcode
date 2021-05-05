package src.question94;

import java.util.ArrayList;
import java.util.List;

/**94. 二叉树的中序遍历
 * @Author: YFAN
* @Date: 2021/5/5/005
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 * 输入：root = [1,2]
 * 输出：[2,1]
 * 示例 5：
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 * 提示：
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
*/
public class LeetCode94 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        for(Integer i : solution.inorderTraversal(root)) {
            System.out.println(i);
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
 * 36.5 MB
 * , 在所有 Java 提交中击败了
 * 89.93%
 * 的用户
 */

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        fun(list,root);
        return list;
    }

    public void fun(List<Integer> list, TreeNode node) {
        if(node != null) {
            fun(list,node.left);
            list.add(node.val);
            fun(list, node.right);
        }
    }
}
