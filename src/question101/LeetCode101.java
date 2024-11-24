package src.question101;

import java.util.LinkedList;

/** 101. 对称二叉树
* @Description:
* @Author: YFAN
* @Date: 2021/5/7/007
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 进阶：
 * 你可以运用递归和迭代两种方法解决这个问题吗？
*/
public class LeetCode101 {
}
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return checkSymmetric(root,root);
    }
    //递归法
    public boolean checkSymmetric(TreeNode p, TreeNode q) {
        if(p != null && q!= null) {
            //p q 都不为null时，比较值是否相等
            if (p.val == q.val) {
                // 递归
                return checkSymmetric(p.left, q.right) && checkSymmetric(p.right, q.left);
            }
            return false;
        } else if (p != null || q !=null) {
            // p q 有个不为null，直接返回false
            return false;
        }
        //p q 都为null，直接返回true
        return true;
    }
    //迭代法 性能差
    public boolean checkSymmetric2(TreeNode p, TreeNode q) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while(!queue.isEmpty()) {
            TreeNode p1 = queue.pop();
            TreeNode q1 = queue.pop();
            if (p1 != null && q1 != null && p1.val == q1.val) {
                queue.offer(p1.left);
                queue.offer(q1.right);
                queue.offer(p1.right);
                queue.offer(q1.left);
            } else if(p1 != null || q1 != null){
                return false;
            }
        }
        return true;
    }
}