package src.question148;

/**148. 排序链表
* @Description:
* @Author: YFAN
* @Date: 2021/5/9/009
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * 进阶：
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 * 示例 1：
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 *
 * 链表中节点的数目在范围 [0, 5 * 104] 内
 * -105 <= Node.val <= 105
*/
public class LeetCode148 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(4);
        listNode.next = new ListNode(86);
        listNode.next.next = new ListNode(23);
        listNode.next.next.next = new ListNode(2);
        listNode.next.next.next.next = new ListNode(4456);
        listNode.next.next.next.next.next = new ListNode(66);
        listNode.next.next.next.next.next.next = new ListNode(7);
        listNode.next.next.next.next.next.next.next = new ListNode(71);
        listNode.next.next.next.next.next.next.next.next = new ListNode(17);
        listNode.next.next.next.next.next.next.next.next.next = new ListNode(27);
        listNode.next.next.next.next.next.next.next.next.next.next = new ListNode(37);
        listNode.next.next.next.next.next.next.next.next.next.next.next = new ListNode(9997);
        Solution solution = new Solution();
        ListNode resultListNode = solution.sortList(listNode);
        while(resultListNode != null) {
            System.out.print(resultListNode.val + " ");
            resultListNode = resultListNode.next;
        }
    }
}
class Solution {
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }
    /**
     *  使用快慢指针，找出中间节点后,对两边进行合并成有序链
     *
     */
    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        // 链头等于链尾
        if (head.next == tail) {
            // 链头下一节点置null
            head.next = null;
            return head;
        }
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (fastPointer != tail) {
            // 慢指针走一步 快指针走两步
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
            if (fastPointer != tail) {
                fastPointer = fastPointer.next;
            }
        }
        // 循环结束后 慢指针就是当前链表的中间节点
        ListNode midPointer = slowPointer;
        // 递归 继续把链表拆分成2份
        ListNode list1 = sortList(head, midPointer);
        ListNode list2 = sortList(midPointer, tail);
        // 将拆分好的链表进行有序合并
        return mergeTwoLists2(list1, list2);
    }

    /**
     * 这个方法为leetcode21的合成有序链表解题
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(-1);
        ListNode temp = root;
        while (l1 !=null || l2 !=null) {
            if (l1 != null && l2 !=null) {
                if (l1.val <= l2.val) {
                    temp.next = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    temp.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
                temp = temp.next;
            } else if (l1 != null) {
                temp.next = new ListNode(l1.val);
                l1 = l1.next;
                temp = temp.next;
            } else if (l2 != null) {
                temp.next = new ListNode(l2.val);
                l2 = l2.next;
                temp = temp.next;
            } else {
                break;
            }
        }
        return root.next;
    }

    /**
     * 这个方法为leetcode21的合成有序链表解题
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode root = new ListNode();
        ListNode temp = root;
        while (l1 !=null && l2 !=null) {
            if (l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if(l1 != null) {
            temp.next = l1;
        } else if(l2 != null){
            temp.next = l2;
        }
        return root.next;
    }
    /**
     * 这个方法为leetcode21的合成有序链表解题
     * 递归
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        if (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        } else if (l1 == null) {
            return l2;
        } else{
            return l1;
        }
    }
}