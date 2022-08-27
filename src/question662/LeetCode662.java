package src.question662;

import java.util.HashMap;
import java.util.Map;

/**
 * 662. 二叉树最大宽度
 * 给你一棵二叉树的根节点 root ，返回树的 最大宽度 。
 * 树的 最大宽度 是所有层中最大的 宽度 。
 * 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 null 节点，这些 null 节点也计入长度。
 * 题目数据保证答案将会在  32 位 带符号整数范围内。
 * 示例 1：
 * 输入：root = [1,3,2,5,3,null,9]
 * 输出：4
 * 解释：最大宽度出现在树的第 3 层，宽度为 4 (5,3,null,9) 。
 * 示例 2：
 * 输入：root = [1,3,2,5,null,null,9,6,null,7]
 * 输出：7
 * 解释：最大宽度出现在树的第 4 层，宽度为 7 (6,null,null,null,null,null,7) 。
 * 示例 3：
 * 输入：root = [1,3,2,5]
 * 输出：2
 * 解释：最大宽度出现在树的第 2 层，宽度为 2 (3,2) 。
 * <p>
 * 提示：
 * 树中节点的数目范围是 [1, 3000]
 * -100 <= Node.val <= 100
 *
 * @Author: YFAN
 * @CreateTime: 2022-08-27
 * @Version: 1.0
 */
public class LeetCode662 {
    public static void main(String[] args) {

    }
}


class Solution {
    private Map<Integer, Integer> map = new HashMap<>();

    /**
     *
     *        1
     *     2     3
     *   4  5  6  7
     *  求每一层的宽度时，因为两端点间的 null 节点也需要计入宽度，因此可以对节点进行编号。
     *  一个编号为 index 的左子节点的编号记为 2×index，
     *  右子节点的编号记为 2×index+1，
     *  计算每层宽度时，用每层节点的最大编号减去最小编号再加 11 即为宽度。
     *
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 1, 1);
    }

    public int dfs(TreeNode root, int deep, int index) {
        if (root == null) {
            return 0;
        }
        map.putIfAbsent(deep, index);
        return Math.max(index - map.get(deep) + 1, Math.max(dfs(root.left, deep + 1, 2 * index), dfs(root.right, deep + 1, 2 * index + 1)));
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}