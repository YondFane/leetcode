package src.question21;


/**合并两个有序链表
 * @Author YFAN
将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
 **/
public class LeetCode21 {
    public static void main(String[] args) {

    }
}
// 0ms 100%
// 使用递归，不使用第三条链操作
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
// 1ms 65.05%
class Solution2 {
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

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(-1);
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
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}