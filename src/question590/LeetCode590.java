package src.question590;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * 描述
 * @author YFAN
 * @date 2022/3/12/012
 *  * @return
590. N 叉树的后序遍历
给定一个 n 叉树的根节点 root ，返回 其节点值的 后序遍历 。
n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
示例 1：
输入：root = [1,null,3,2,4,null,5,6]
输出：[5,6,3,2,4,1]
示例 2：
输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
输出：[2,6,14,11,7,3,12,8,4,13,9,10,5,1]
提示：
节点总数在范围 [0, 104] 内
0 <= Node.val <= 104
n 叉树的高度小于或等于 1000
进阶：递归法很简单，你可以使用迭代法完成此题吗?
 */
public class LeetCode590 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Node root = new Node(1);
        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        root.children = Arrays.asList(node3, node2, node4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node3.children = Arrays.asList(node5,node6);
        List<Integer> list = solution.postorder(root);
        list.forEach(System.out::println);
    }
}


class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    public void dfs(Node root, List<Integer> list) {
        if (root != null) {
            if (root.children != null && root.children.size() > 0) {
                root.children.forEach(node->dfs(node, list));
            }
            list.add(root.val);
        }
    }
}
//============================
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}