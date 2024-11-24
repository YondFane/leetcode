package src.question144;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/** 144. 二叉树的前序遍历
* @Author: YFAN
* @Date: 2021/5/13/013
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 * 输入：root = [1,2]
 * 输出：[1,2]
 * 示例 5：
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 * 提示：
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
*/
public class LeetCode144 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        root.left.right = new TreeNode(123);
        for(Integer i : solution.preorderTraversal(root)) {
            System.out.println(i);
        }
    }
}
class Solution {
    /**
     *     迭代
     *     前序遍历 根 -> 左 -> 右
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (root!=null || !stack.isEmpty()) {
            //循环压入左子树
            while(root != null) {
                //添加根节点值
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }
            //遍历右节点
            root = stack.pop();
            root = root.right;
        }
        return list;
    }
}