package src.question1022;

public class LeetCode1022 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        System.out.println(solution.sumRootToLeaf(root));
    }

}
class Solution {
    public int sumRootToLeaf(TreeNode root) {
        if(root == null){
            return 0;
        }
        return dfs(root, 0);
    }
    private int dfs(TreeNode root, int sum){
        sum = sum * 2 + root.val;
        if(root.left == null && root.right == null){
            return sum;
        }
        if(root.left == null){
            return dfs(root.right, sum);
        }
        if(root.right == null){
            return dfs(root.left, sum);
        }
        return dfs(root.right, sum) + dfs(root.left, sum);
    }
}
class Solution1 {
    private int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return sum;
    }

    public void dfs(TreeNode root, StringBuilder sb) {
        if (root!=null) {
            sb.append(root.val);
            dfs(root.left, sb);
            dfs(root.right, sb);
            if (root.left==null && root.right ==null) {
                String str = sb.toString();
                if (!"".equals(str)) {
                    sum+=Integer.valueOf(str, 2);
                }
            }
            sb.deleteCharAt(sb.length() - 1);
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
}