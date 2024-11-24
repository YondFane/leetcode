package src.question61;

/**
 * 61. 旋转链表
 *
 * @Description:
 * @Author: YFAN
 * @Date: 2021/5/17/017
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * 示例 2：
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 * 提示：
 * 链表中节点的数目在范围 [0, 500] 内
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
 */
public class LeetCode61 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        Solution solution = new Solution();
        listNode = solution.rotateRight(listNode, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

class Solution {
    /**
     * 闭合链表成环
     * 计算链表长度
     * 返回结果
     * 1 2 3 4      2 3 4 1 2
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode tail = head;
        int n = 1;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }
        // 往右走多少步
        k = n - k % n;
        if (k == n) {
            return head;
        }
        // 闭环
        tail.next = head;
        while (k-- > 0) {
            tail = tail.next;
        }
        head = tail.next;
        tail.next = null;
        return head;
    }
}