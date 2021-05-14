package src.question226;

/** 226. 翻转二叉树
* @Description:
* @Param:
* @return:
* @Author: YFAN
* @Date: 2021/5/14/014
 * 翻转一棵二叉树。
 * 示例：
 * 输入：
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
*/
public class LeetCode226 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        root.left.right = new TreeNode(123);
        root = solution.invertTree(root);

    }

}
class Solution {
    public TreeNode invertTree(TreeNode root) {
        TreeNode temp = root;
        if(temp != null) {
            fun(temp);
        }
        return root;
    }

    public void fun(TreeNode root) {
        if(root!=null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            fun(root.left);
            fun(root.right);
        }
    }
}