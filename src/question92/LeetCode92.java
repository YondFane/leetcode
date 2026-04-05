package src.question92;

/**
 92. 反转链表 II
 中等
 相关标签
 premium lock icon
 相关企业
 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。

 示例 1：

 输入：head = [1,2,3,4,5], left = 2, right = 4
 输出：[1,4,3,2,5]
 示例 2：

 输入：head = [5], left = 1, right = 1
 输出：[5]

 提示：

 链表中节点数目为 n
 1 <= n <= 500
 -500 <= Node.val <= 500
 1 <= left <= right <= n

 进阶： 你可以使用一趟扫描完成反转吗？
 */
public class LeetCode92 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode listNode = solution.reverseBetween(head, 2, 4);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode t = new ListNode(-1);
        t.next = head;
        ListNode pre = t;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        // 一步步将next节点插入到pre.next（穿针引线）
        for (int i= 0;i<right - left;i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return t.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}