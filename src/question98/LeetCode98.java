package src.question98;

import java.util.Stack;

/**
 * 98. 验证二叉搜索树
 *
 * @Author: YFAN
 * @Date: 2021/5/6/006
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例 2:
 * 输入:
 * 5
 * / \
 * 1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class LeetCode98 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(4);
        System.out.println(solution.isValidBST(root));
    }
}

/**
 * * 节点的左子树只包含小于当前节点的数。
 * * 节点的右子树只包含大于当前节点的数。
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
//        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
//        return isValidBST2(root, null, null);
        return isValidBST3(root, null, null);
//        return inorder(root);
    }
    // 递归 lower为下界 upper为上届

    /**
     * 对于 节点7来说  5为下界 8为上届
     * 对于 节点9来说  8为下界 无上届
     * 对于 节点1来说  5为上届 无下界
     * *   5  -----------
     * * / \
     * * 1   8
     * *      / \
     * *     7   9
     */
    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node != null) {
            if (node.val <= lower || node.val >= upper) {
                return false;
            }
            return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
        }
        return true;
    }

    public boolean isValidBST2(TreeNode node, Long lower, Long upper) {
        if (node != null) {
            if (lower != null && node.val <= lower) {
                return false;
            }
            if (upper != null && node.val >= upper) {
                return false;
            }
            return isValidBST2(node.left, lower, (long) node.val) && isValidBST2(node.right, (long) node.val, upper);
        }
        return true;
    }

    public boolean isValidBST3(TreeNode node, Integer lower, Integer upper) {
        if (node != null) {
            if (lower != null && node.val <= lower) {
                return false;
            }
            if (upper != null && node.val >= upper) {
                return false;
            }
            return isValidBST3(node.left, lower, node.val) && isValidBST3(node.right, node.val, upper);
        }
        return true;
    }

    // 中序遍历
    public boolean inorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Long inorder = Long.MIN_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (inorder != null && inorder <= root.val) {
                return false;
            }
            inorder = (long) root.val;
            root = root.right;
        }
        return true;
    }
}