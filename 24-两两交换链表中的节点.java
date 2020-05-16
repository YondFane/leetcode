package 两两交换链表中的节点_24;

/**
 * @Author YFAN
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例:
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 **/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        ListNode tempListNode = solution.swapPairs(listNode);

        while (tempListNode != null) {
            System.out.print(tempListNode.val + " ");
            tempListNode = tempListNode.next;
        }
    }
}
// 0ms 100%
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode listNode = new ListNode(0);
        ListNode left = listNode;
        if (head != null && head.next != null){
            ListNode mid = head;
            ListNode right = head.next;
            while (mid != null && right != null) {
                mid.next = right.next;
                right.next = mid;
                left.next = right;
                left = mid;
                mid = left.next;
                if (mid != null) {
                    right = mid.next;
                }
            }

        } else {
            return head;
        }
        return  listNode.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}