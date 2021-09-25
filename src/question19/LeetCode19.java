package src.question19;

import java.util.ArrayList;
import java.util.List;

/**删除链表的倒数第N个节点
 * @Author YFAN
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * 你能尝试使用一趟扫描实现吗？
 **/
public class LeetCode19 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = new ListNode(6);

        ListNode listNode = solution.removeNthFromEnd(root, 1);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

// 0ms 100% 思路：使用双指针遍历ListNode
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root = head;
        // 记录删除节点的前节点
        ListNode pre = head;
        // 记录删除节点当前位置
        ListNode current = head;
        ListNode temp = head;
        while(n > 0) {
            temp = temp.next;
            n--;
        }
        // temp为null说明需要删除链表第一个节点
        if (temp == null) {
            return root.next;
        }
        // temp为null时，current指定需要删除的节点
        while(temp !=null) {
            // 记录前一个位置
            pre = current;
            // 当前遍历位置
            current = current.next;
            temp = temp.next;
        }
        // current.next为null，说明删除节点为链表的倒数第一个节点
        if (current.next == null) {
            pre.next = null;
        } else {
            // 前节点指向删除节点的下一个位置
            pre.next = current.next;
        }
        return root;
    }
}

// 1ms 37.54% 思路：遍历ListNode将节点存进List集合中，然后再进行删除，最后返回结果
class Solution2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> listNodes = new ArrayList<>();
        while (head != null) {
            listNodes.add(head);
            head = head.next;
        }
        if (n == 0) {
            return listNodes.get(0);
        } else {
            int len = listNodes.size();
            int index = len - n;
            if (index == 0) {
                if (listNodes.size() == 1) {
                    return null;
                }
                return listNodes.get(1);
            } else if (index == len - 1) {
                listNodes.get(index - 1).next = null;
            } else {
                listNodes.get(index - 1).next = listNodes.get(index + 1);
            }
        }
        return listNodes.get(0);
    }
}




/*
 * 再解一遍
 * @author YFAN
 * @date 2021/9/25/025
 * @param  * @param null
 * @return
 */
class Solution3 {
    /*
     * 1 2 3 4 5 6
     * n = 1 -- 1 2 3 4 5
     * n = 2 -- 1 2 3 4 6
     * n = 6 -- 2 3 4 5 6
     *
     * @author YFAN
     * @date 2021/9/25/025
     * @param  * @param head
     * @param n
     * @return src.question19.ListNode
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        ListNode p = head;
        ListNode q = head;
        // 先行n步
        while (n-- > 0) {
            temp = temp.next;
        }
        // 遍历n个链表节点后，temp为null，那么n等于链表长度
        if (temp == null) {
            return p.next;
        } else {
            // 记录前一个节点
            ListNode pre = p;
            // 当前节点
            ListNode cur = p;
            while (temp!=null) {
                temp = temp.next;
                pre = p;
                p = p.next;
                cur = p;
            }
            // 如果当前节点的下个节点为null，那么cur为最后一个节点
            if (cur.next == null) {
                pre.next = null;
            } else {
                pre.next = cur.next;
            }
        }
        return q;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}