package src.question876;

/*
 * 876. 链表的中间结点
 * @author YFAN
 * @date 2021/9/25/025
给定一个头结点为 head 的非空单链表，返回链表的中间结点。
如果有两个中间结点，则返回第二个中间结点。
示例 1：
输入：[1,2,3,4,5]
输出：此列表中的结点 3 (序列化形式：[3,4,5])
返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
注意，我们返回了一个 ListNode 类型的对象 ans，这样：
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
示例 2：
输入：[1,2,3,4,5,6]
输出：此列表中的结点 4 (序列化形式：[4,5,6])
由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
提示：
给定链表的结点数介于 1 和 100 之间。
 */
public class LeetCode876 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(6);
//        while (listNode != null) {
//            System.out.println(listNode.val);
//            listNode = listNode.next;
//        }
        System.out.println(new Solution().middleNode(listNode).val);
    }
}
class Solution {
    /*
     * 双指针
     * 1 2 3 4 5 6
     * @author YFAN
     * @date 2021/9/25/025
     * @param  * @param head
     * @return src.question876.ListNode
     */
    public ListNode middleNode(ListNode head) {
        // 慢指针
        ListNode slow = head;
        // 快指针
        ListNode fast = head;
        while (slow != null && fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            } else {
                break;
            }
            slow = slow.next;
        }
        return slow;
    }

    /*
     * 优解
     * @author YFAN
     * @date 2021/9/25/025
     * @param  * @param head
     * @return src.question876.ListNode
     */
    public ListNode middleNode2(ListNode head) {
        // 慢指针
        ListNode slow = head;
        // 快指针
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}