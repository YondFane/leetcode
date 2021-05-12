package src.question257;

import java.util.ArrayList;
import java.util.List;

/** 257. 二叉树的所有路径
* @Description:
* @Param:  
* @return:  
* @Author: YFAN
* @Date: 2021/5/12/012
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * 输入:
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 * 输出: ["1->2->5", "1->3"]
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
*/
public class LeetCode257 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(5);
        for(String str : solution.binaryTreePaths(root)) {
            System.out.println(str);
        }
    }
}
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        fun(root, list, new StringBuilder());
        return list;
    }
    public void fun(TreeNode root, List<String> list, StringBuilder builder) {
        StringBuilder stringBuilder = new StringBuilder(builder);
        if (root != null) {
            stringBuilder.append(root.val);
            // 无子叶节点
            if (root.left == null && root.right == null) {
                list.add(stringBuilder.toString());
            } else {
                // 有子叶节点继续遍历
                stringBuilder.append("->");
                fun(root.left,list,stringBuilder);
                fun(root.right,list,stringBuilder);
            }
        }
    }
}