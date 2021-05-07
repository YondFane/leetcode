package src.question100;

/**100. 相同的树
* @Author: YFAN
* @Date: 2021/5/7/007
 *
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * 示例 1：
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * 示例 2：
 * 输入：p = [1,2], q = [1,null,2]
 * 输出：false
 * 提示：
 * 两棵树上的节点数目都在范围 [0, 100] 内
 * -104 <= Node.val <= 104
*/
public class LeetCode100 {
    public static void main(String[] args) {

    }
}

/** one pass
 *
 * 执行用时：
 * 0 ms
 * , 在所有 Java 提交中击败了
 * 100.00%
 * 的用户
 * 内存消耗：
 * 35.9 MB
 * , 在所有 Java 提交中击败了
 * 30.81%
 * 的用户
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p != null && q!= null) {
            //p q 都不为null时，比较值是否相等
            if (p.val == q.val) {
                // 递归
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
            return false;
        } else if (p != null || q !=null) {
            // p q 有个不为null，直接返回false
            return false;
        }
        //p q 都为null，直接返回true
        return true;
    }
}