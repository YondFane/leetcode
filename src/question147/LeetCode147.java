package src.question147;

/**
 * @Description 147. 对链表进行插入排序
 * @Author YFAN
 * @Date 2021/6/1
 * 对链表进行插入排序。
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 * 插入排序算法：
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 * 示例 1：
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
public class LeetCode147 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(7);
        listNode.next.next.next = new ListNode(-23);
        Solution solution = new Solution();
        ListNode temp = solution.insertionSortList(listNode);
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}

class Solution {
    /**
    * -1 - 3 -4 0
     * -1 3 5 4 0
    */
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode root = new ListNode();
        root.next = head;
        ListNode lastSortNode = head;
        ListNode curSortNode = head.next;
        while (curSortNode != null) {
            if (lastSortNode.val <= curSortNode.val) {
                lastSortNode = lastSortNode.next;
            } else {
                ListNode pre = root;
                while (pre.next.val <= curSortNode.val) {
                    pre = pre.next;
                }
                lastSortNode.next = curSortNode.next;
                curSortNode.next = pre.next;
                pre.next = curSortNode;
            }
            curSortNode = lastSortNode.next;
        }
        return root.next;
    }

}
