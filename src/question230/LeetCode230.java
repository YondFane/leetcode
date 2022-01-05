package src.question230;

import java.util.*;

/**
 * 230. 二叉搜索树中第K小的元素
 *
 * @Author YFAN
 * @Date 2022/1/5
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * 示例 1：
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 * 示例 2：
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 * <p>
 * 提示：
 * 树中的节点数为 n 。
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 * 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
 */
public class LeetCode230 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);
        System.out.println(solution.kthSmallest(root, 1));
    }
}

/***
 * 记录子树的结点数
 * @Author YFAN
 * @Date 2022/1/5 16:48
 * @params
 * @return
 */
class Solution {
    // 记录子树的结点数
    Map<TreeNode, Integer> map = new HashMap<>();

    public int kthSmallest(TreeNode root, int k) {
        countNode(root);
        while (root != null) {
            int num = map.getOrDefault(root.left, 0);
            if (num < k - 1) {
                k -= num + 1;
                root = root.right;
            } else if (num == k - 1) {
                break;
            } else {
                root = root.left;
            }
        }
        return root.val;
    }

    /***
     * 深度遍历统计子树的结点数
     * @Author YFAN
     * @Date 2022/1/5 17:01
     * @params [node]
     * @return int
     */
    private int countNode(TreeNode node) {
        if (node == null) {
            return 0;
        }
        map.put(node, 1 + countNode(node.left) + countNode(node.right));
        return map.getOrDefault(node, 0);
    }
}

/***
 * 中序遍历
 * 巧妙利用二叉搜索树的特性
 * @Author YFAN
 * @Date 2022/1/5 16:48
 * @params
 * @return
 */
class Solution2 {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            --k;
            if (k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }
}

// 前序遍历后排序List
class Solution1 {
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        dfs(root, list);
        Collections.sort(list);
        return list.get(k - 1);
    }

    private void dfs(TreeNode root, ArrayList<Integer> list) {
        if (root != null) {
            list.add(root.val);
            dfs(root.left, list);
            dfs(root.right, list);
        }
    }
}