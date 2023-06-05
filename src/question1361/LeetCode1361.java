package src.question1361;

import java.util.HashSet;

/**
 * 1361. 验证二叉树
 * 二叉树上有 n 个节点，按从 0 到 n - 1 编号，其中节点 i 的两个子节点分别是 leftChild[i] 和 rightChild[i]。
 * 只有 所有 节点能够形成且 只 形成 一颗 有效的二叉树时，返回 true；否则返回 false。
 * 如果节点 i 没有左子节点，那么 leftChild[i] 就等于 -1。右子节点也符合该规则。
 * 注意：节点没有值，本问题中仅仅使用节点编号。
 * <p>
 * 示例 1：
 * 输入：n = 4, leftChild = [1,-1,3,-1], rightChild = [2,-1,-1,-1]
 * 输出：true
 * 示例 2：
 * 输入：n = 4, leftChild = [1,-1,3,-1], rightChild = [2,3,-1,-1]
 * 输出：false
 * 示例 3：
 * 输入：n = 2, leftChild = [1,0], rightChild = [-1,-1]
 * 输出：false
 * 示例 4：
 * 输入：n = 6, leftChild = [1,-1,-1,4,-1,-1], rightChild = [2,-1,-1,5,-1,-1]
 * 输出：false
 * <p>
 * 提示：
 * 1 <= n <= 10^4
 * leftChild.length == rightChild.length == n
 * -1 <= leftChild[i], rightChild[i] <= n - 1
 */
public class LeetCode1361 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validateBinaryTreeNodes(4, new int[]{1,-1,3,-1}, new int[]{2,-1,-1,-1}));
    }
}

class Solution {

    private int count = 0;

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        HashSet<Integer> set = new HashSet<>();
        // 每个节点只能被一个地方引用
        for (int i = 0; i < n; i++) {
            if (!set.add(leftChild[i]) && leftChild[i] != -1) {
                return false;
            }
            if (!set.add(rightChild[i]) && rightChild[i] != -1) {
                return false;
            }
        }

        // 多树情况
        set.remove(-1);
        if (set.size() != n - 1) {
            return false;
        }

        // 寻找跟节点
        int rootIndex = -1;
        for (int i = 0; i < n; i++) {
            if (!set.contains(i)) {
                rootIndex = i;
                break;
            }
        }

        dfs(rootIndex, leftChild, rightChild);
        return count == n;
    }

    // 前序遍历计数
    private void dfs(int rootIndex, int[] leftChild, int[] rightChild) {
        if (rootIndex == -1) {
            return;
        }
        count++;
        dfs(leftChild[rootIndex], leftChild, rightChild);
        dfs(rightChild[rootIndex], leftChild, rightChild);
    }
}