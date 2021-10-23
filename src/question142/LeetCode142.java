package src.question142;

/*
 * 142. 环形链表 II
 * @author YFAN
 * @date 2021/10/23/023
给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
说明：不允许修改给定的链表。
进阶：
你是否可以使用 O(1) 空间解决此题？
示例 1：
输入：head = [3,2,0,-4], pos = 1
输出：返回索引为 1 的链表节点
解释：链表中有一个环，其尾部连接到第二个节点。
示例 2：
输入：head = [1,2], pos = 0
输出：返回索引为 0 的链表节点
解释：链表中有一个环，其尾部连接到第一个节点。
示例 3：
输入：head = [1], pos = -1
输出：返回 null
解释：链表中没有环。
提示：
链表中节点的数目范围在范围 [0, 104] 内
-105 <= Node.val <= 105
pos 的值为 -1 或者链表中的一个有效索引
 */
public class LeetCode142 {
    public static void main(String[] args) {

    }
}
class Solution {
    /*
     * a+(n+1)b+nc=2(a+b)⟹a=c+(n−1)(b+c)
     * a 链头到环的距离
     * b 为慢指针在环内被快指针追上时所走的距离
     * c 为环距离减去b的距离
     * b+c为环的长度
     * 快指针追上慢指针时，走了N圈(b+c) + b
     * 由公式所示：慢指针被快指针追上时，慢指针走完剩下的环距离等于链头到环的距离
     * @author YFAN
     * @date 2021/10/23/023
     * @param  * @param head
     * @return src.question142.ListNode
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null) {
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            slow = slow.next;
            if (slow == fast) {
                ListNode temp = head;
                while (temp!=slow) {
                    temp = temp.next;
                    slow = slow.next;
                }
                return temp;
            }
        }
        return null;
    }
}
