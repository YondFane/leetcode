package src.question206;

/**
 206. 反转链表
 简单
 示例 1：

 输入：head = [1,2,3,4,5]
 输出：[5,4,3,2,1]
 示例 2：

 输入：head = [1,2]
 输出：[2,1]
 示例 3：

 输入：head = []
 输出：[]

 提示：
 链表中节点的数目范围是 [0, 5000]
 -5000 <= Node.val <= 5000

 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 */
public class LeetCode206 {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
//        root.next.next.next = new ListNode(1);
        Solution solution = new Solution();
        System.out.println(solution.reverseList(root));
    }
}


class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }


class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

/**
 * 递归
 */
class Solution2 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
