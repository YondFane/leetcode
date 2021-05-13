package src.question145;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/** 145. 二叉树的后序遍历
* @Description:
* @Author: YFAN
* @Date: 2021/5/13/013
 * 给定一个二叉树，返回它的 后序 遍历。
 * 示例:
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
*/
public class LeetCode145 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        root.left.right = new TreeNode(123);
        for(Integer i : solution.postorderTraversal(root)) {
            System.out.println(i);
        }
    }
}

class Solution {
    /**
     * 迭代
     * 后序遍历 左 -> 右 -> 根
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        // 记录上一节点
        TreeNode pre = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            //如果当前节点右子叶不为null 但前节点等于右子叶说明遍历到右子树
            if(root.right == null || pre == root.right) {
                //添加左子叶
                list.add(root.val);
                //记录前一个节点
                pre = root;
                //置null 摘叶子操作
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return list;
    }
}