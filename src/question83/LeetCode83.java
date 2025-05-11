package src.question83;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 83. 删除排序链表中的重复元素
 简单
 相关标签
 相关企业
 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。

 示例 1：


 输入：head = [1,1,2]
 输出：[1,2]
 示例 2：


 输入：head = [1,1,2,3,3]
 输出：[1,2,3]


 提示：

 链表中节点数目在范围 [0, 300] 内
 -100 <= Node.val <= 100
 题目数据保证链表已经按升序 排列
 */
public class LeetCode83 {
    public static void main(String[] args) {

        Solution solution = new Solution();
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(4);
        listNode.next.next.next = new ListNode(4);
        ListNode t = solution.deleteDuplicates(listNode);
        while (t != null) {
            System.out.println(t.val);
            t = t.next;
        }

    }
}

class Solution {
    // 2 4 4
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        ListNode p = head;
        ListNode pre = head;
        while (p != null) {
            pre = p;
            p = p.next;
            if (p != null) {
                if (set.contains(p.val)) {
                    pre.next = p.next;
                    p = pre;
                    continue;
                }
                set.add(p.val);
            }
        }
        return head;
    }
}

/**
 * 官方题解
 * 已排序链表不需要记录之前的节点
 */
class Solution2 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode temp = head;
        while(temp.next!= null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}