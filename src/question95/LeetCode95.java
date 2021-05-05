package src.question95;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树 II
 *
 * @Author: YFAN
 * @Date: 2021/5/5/005
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 * 示例：
 * 输入：3
 * 输出：
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释：
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * <p>
 * 提示：
 * 0 <= n <= 8
 */
public class LeetCode95 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        for (TreeNode i : solution.generateTrees(3)) {

        }
    }
}

/**
 * 二叉搜索树
 * 左大于根 根大于右
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> list = new ArrayList<>();
        if(n == 0) {
            return list;
        }
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        for (int i = start; i <= end; i++) {
            //获取可用左子树
            List<TreeNode> leftTreeNode = generateTrees(start, i - 1);
            //获取可用右子树
            List<TreeNode> rightTreeNode = generateTrees(i + 1, end);
            for(TreeNode left : leftTreeNode) {
                for(TreeNode right:rightTreeNode) {
                    TreeNode newTreeNode = new TreeNode(i);
                    newTreeNode.left = left;
                    newTreeNode.right = right;
                    list.add(newTreeNode);
                }
            }
        }
        return list;
    }
}