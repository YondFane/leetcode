package src.question979;


/**
 * 979. 在二叉树中分配硬币
 * 给你一个有 n 个结点的二叉树的根结点 root ，其中树中每个结点 node 都对应有 node.val 枚硬币。整棵树上一共有 n 枚硬币。
 * <p>
 * 在一次移动中，我们可以选择两个相邻的结点，然后将一枚硬币从其中一个结点移动到另一个结点。移动可以是从父结点到子结点，或者从子结点移动到父结点。
 * <p>
 * 返回使每个结点上 只有 一枚硬币所需的 最少 移动次数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [3,0,0]
 * 输出：2
 * 解释：一枚硬币从根结点移动到左子结点，一枚硬币从根结点移动到右子结点。
 * 示例 2：
 * <p>
 * 输入：root = [0,3,0]
 * 输出：3
 * 解释：将两枚硬币从根结点的左子结点移动到根结点（两次移动）。然后，将一枚硬币从根结点移动到右子结点。
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目为 n
 * 1 <= n <= 100
 * 0 <= Node.val <= n
 * 所有 Node.val 的值之和是 n
 */
public class LeetCode979 {
    public static void main(String[] args) {

    }
}


class Solution {
    int move = 0;

    /**
     * 移动的情况只有三种可能，1 子节点向父节点移动 2 父节点向子节点移动 3 不移动
     * 那么只需要计算二叉树左子树、右子树每条边的差值，加绝对值即可
     *
     * @param root
     * @return
     */
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return move;
    }

    public int dfs(TreeNode root) {
        int moveleft = 0;
        int moveright = 0;
        if (root == null) {
            return 0;
        }
        if (root.left != null) {
            moveleft = dfs(root.left);
        }
        if (root.right != null) {
            moveright = dfs(root.right);
        }
        move += Math.abs(moveleft) + Math.abs(moveright);
        // 减一：保留自身需要的硬币
        return moveleft + moveright + root.val - 1;
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