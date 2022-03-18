package src.question559;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;

/*
 * 559. N 叉树的最大深度
 * @author YFAN
 * @date 2022/3/18/018
559. N 叉树的最大深度
给定一个 N 叉树，找到其最大深度。
最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
示例 1：
输入：root = [1,null,3,2,4,null,5,6]
输出：3
示例 2：
输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
输出：5
提示：
树的深度不会超过 1000 。
树的节点数目位于 [0, 104] 之间。
 */
public class LeetCode559 {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.children = new ArrayList<>();
        Node node = new Node(3);
        root.children.add(node);
        root.children.add(new Node(2));
        root.children.add(new Node(4));
        node.children = new ArrayList<>();
        node.children.add(new Node(5));
        node.children.add(new Node(6));
        System.out.println(new Solution().maxDepth(root));
    }
}

class Solution {
    private int deep = 0;

    public int maxDepth(Node root) {
        dfs(root, 1);
        return deep;
    }

    public void dfs(Node root, int level) {
        if (root != null) {
            if (root.children != null && root.children.size() > 0) {
                root.children.forEach(node -> dfs(node, level + 1));
            } else {
                deep = Math.max(deep, level);
            }
        }
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}