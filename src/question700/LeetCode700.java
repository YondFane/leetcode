package src.question700;

public class LeetCode700 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        TreeNode treeNode = solution.searchBST(root, 2);
        System.out.println(treeNode);
    }
}

class Solution {
    private TreeNode ans = null;
    public TreeNode searchBST(TreeNode root, int val) {
        dfs(root, val);
        return ans;
    }

    public void dfs(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        if (root.val==val) {
            ans = root;
            return;
        }
        if (root.val < val) {
            dfs(root.right, val);
        } else {
            dfs(root.left, val);
        }
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

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}